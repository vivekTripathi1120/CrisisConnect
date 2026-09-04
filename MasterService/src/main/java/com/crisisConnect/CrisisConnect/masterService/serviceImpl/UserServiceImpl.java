package com.crisisConnect.CrisisConnect.masterService.serviceImpl;

import com.crisisConnect.CrisisConnect.masterService.dtos.*;
import com.crisisConnect.CrisisConnect.masterService.entity.*;
import com.crisisConnect.CrisisConnect.masterService.exception.CustomValidationException;
import com.crisisConnect.CrisisConnect.masterService.exception.ErrorCodes;
import com.crisisConnect.CrisisConnect.masterService.repository.*;
import com.crisisConnect.CrisisConnect.masterService.service.UsersService;
import com.crisisConnect.CrisisConnect.masterService.utils.UserConstants;
import com.crisisConnect.CrisisConnect.masterService.utils.UserStatus;
import jakarta.transaction.Transactional;
import org.flywaydb.core.internal.util.CollectionsUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class UserServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    CitizenRepository citizenRepository;

    @Autowired
    UserAddressRepository addressRepository;

    @Autowired
    UserEmergencyContactRepository emergencyContactRepository;

    @Autowired
    UserEmergencyProfileRepository emergencyProfileRepository;

    @Autowired
    GeoStructureRepository geoStructureRepository;

    @Override
    public GeneralResponseDTO registerUser(OnboardingDTO onboardingDTO) {

        usersRepository.findByEmailAndDeletedFlagFalse(onboardingDTO.getEmail(),onboardingDTO.getPhoneNumber())
                .ifPresent( d -> {
                    throw new CustomValidationException(ErrorCodes.ERRORCODES_2001);
                });

        Users newUser = new Users();
        newUser.setName(onboardingDTO.getName());
        newUser.setPhoneNumber(onboardingDTO.getPhoneNumber());
        newUser.setEmail(onboardingDTO.getEmail());
        newUser.setStatus(UserStatus.PENDING);
        newUser.setCreatedBy(onboardingDTO.getEmail());
        newUser.setUpdatedBy(onboardingDTO.getEmail());
        newUser.setCreatedAt(LocalDateTime.now());
        newUser.setUpdatedAt(LocalDateTime.now());

        usersRepository.save(newUser);

        // trigger to Auth Service to register User Details and password there....

        GeneralResponseDTO responseDTO = new GeneralResponseDTO();
        responseDTO.setStatus(true);
        responseDTO.setMsg(UserConstants.USER_CREATED_MSG);
        responseDTO.setTimeStamp(System.currentTimeMillis());
        return responseDTO;
    }

    @Transactional(rollbackOn = Exception.class)
    public GeneralResponseDTO completeProfile(UserRequestDTO onboardingDTO, UserCacheDTO cacheDTO) {

        Users users = usersRepository.findAllByUserIdAndDeletedFlagFalse(cacheDTO.getUserId())
                .orElseThrow( () -> new CustomValidationException(ErrorCodes.ERRORCODES_2003));

        Citizen citizen = new Citizen();
        citizen.setDateOfBirth(onboardingDTO.getDateOfBirth());
        citizen.setGender(onboardingDTO.getGender());
        citizen.setFamilyMemberCount(onboardingDTO.getFamilyMemberCount());
        citizen.setUser(users);
        citizen.setCreatedAt(LocalDateTime.now());
        citizen.setUpdatedAt(LocalDateTime.now());
        citizenRepository.save(citizen);


        saveUserDetails(onboardingDTO, users, citizen);

        GeneralResponseDTO responseDTO = new GeneralResponseDTO();

        responseDTO.setStatus(true);
        responseDTO.setMsg("Profile Updated!");

        return responseDTO;
    }

    private void saveUserDetails(UserRequestDTO onboardingDTO, Users users, Citizen citizen) {
        // Primary Address
        if (onboardingDTO.getPrimaryAddress() != null) {
            saveUserAddress(onboardingDTO.getPrimaryAddress(), users);
        }

        // Secondary Address
        if (onboardingDTO.getSecondaryAddress() != null) {
            saveUserAddress(onboardingDTO.getSecondaryAddress(), users);
        }

        // Emergency Contact
        if (onboardingDTO.getEmergencyContact() != null) {
            saveEmergencyContactDetails(onboardingDTO, users);
        }

        // Medical History
        if (onboardingDTO.getMedicalHistory() != null) {
            saveMedicalHistory(onboardingDTO, citizen);
        }
    }

    private void saveMedicalHistory(UserRequestDTO onboardingDTO, Citizen citizen) {
        userMedicalHistoryDTO historyDTO = onboardingDTO.getMedicalHistory();
        UserEmergencyProfile profile = new UserEmergencyProfile();
        profile.setCitizen(citizen);
        profile.setBloodGroup(historyDTO.getBloodGroup());
        profile.setMedicalConditions(historyDTO.getMedicalCondition());
        profile.setAllergies(historyDTO.getAllergies());
        profile.setSpecialRequirements(historyDTO.getSpecialRequirement());
        profile.setDeletedFlag(false);
        profile.setCreatedAt(LocalDateTime.now());
        profile.setUpdatedAt(LocalDateTime.now());
        emergencyProfileRepository.save(profile);
    }

    private void saveEmergencyContactDetails(UserRequestDTO onboardingDTO, Users users) {
        EmergencyContactReqDTO contactDTO = onboardingDTO.getEmergencyContact();
        UserEmergencyContact contact = new UserEmergencyContact();
        contact.setUser(users);
        contact.setContactName(contactDTO.getContactName());
        contact.setRelationship(contactDTO.getRelationShip());
        contact.setPhoneNumber(contactDTO.getPhoneNumber());
        contact.setEmail(contactDTO.getEmail());
        contact.setIsPrimary(contactDTO.getIsPrimary() != null ? contactDTO.getIsPrimary() : false);
        contact.setIsVerified(false);
        contact.setDeletedFlag(false);
        contact.setCreatedAt(LocalDateTime.now());
        contact.setUpdatedAt(LocalDateTime.now());
        emergencyContactRepository.save(contact);
    }

    private void saveUserAddress(UserAddressReqDTO primary, Users users) {

        UserAddress address = new UserAddress();
        address.setUser(users);
        address.setAddressLine(primary.getAddressLine());
        address.setLandmark(primary.getLandMark());
        address.setPostalCode(primary.getPostalCode());
        address.setLatitude(primary.getLatitude());
        address.setLongitude(primary.getLongitude());
        address.setIsPrimary(true);
        address.setDeletedFlag(false);
        address.setCreatedAt(LocalDateTime.now());
        address.setUpdatedAt(LocalDateTime.now());
        if (primary.getGeoStructId() != null) {
            GeoStructure geo = geoStructureRepository.findByGeoIdAndLevelAndDeletedFlagFalse(primary.getGeoStructId(),UserConstants.CITY_GEO_LVL)
                    .orElseThrow(()-> new CustomValidationException(ErrorCodes.ERRORCODES_2001));
            address.setGeoStructure(geo);
        }
        addressRepository.save(address);
    }

    @Transactional(rollbackOn = Exception.class)
    public GeneralResponseDTO updateDetails(UserRequestDTO onboardingDTO, UserCacheDTO cacheDTO) {

        Users users = usersRepository.findAllByUserIdAndDeletedFlagFalse(cacheDTO.getUserId())
                .orElseThrow(() -> new CustomValidationException(ErrorCodes.ERRORCODES_2003));

        // Update Citizen
        Citizen citizen = citizenRepository.findByUserIdAndDeletedFlagFalse(users.getUserId())
                .orElseThrow(() -> new CustomValidationException(ErrorCodes.ERRORCODES_2003));

        citizen.setFamilyMemberCount(onboardingDTO.getFamilyMemberCount());
        citizen.setUpdatedAt(LocalDateTime.now());
        citizenRepository.save(citizen);

        processAndUpdateUserProfile(onboardingDTO, users, citizen);

        GeneralResponseDTO responseDTO = new GeneralResponseDTO();
        responseDTO.setMsg("Profile updated successfully");
        responseDTO.setStatus(true);

        return responseDTO;
    }

    private void processAndUpdateUserProfile(UserRequestDTO onboardingDTO, Users users, Citizen citizen) {
        // Update Primary Address
        if (onboardingDTO.getPrimaryAddress() != null) {
            updatePrimaryAddress(onboardingDTO.getPrimaryAddress(), users);
        }

        // Update Secondary Address
        if (onboardingDTO.getSecondaryAddress() != null) {
            updatePrimaryAddress(onboardingDTO.getSecondaryAddress(), users);
        }

        // Update Emergency Contact
        if (onboardingDTO.getEmergencyContact() != null) {
            updateEmergencyContactDetails(onboardingDTO, users);
        }

        // Update Medical History
        if (onboardingDTO.getMedicalHistory() != null) {
            updateMedicalHistory(onboardingDTO, citizen);
        }
    }

    private  void updateMedicalHistory(UserRequestDTO onboardingDTO, Citizen citizen) {
        userMedicalHistoryDTO historyDTO = onboardingDTO.getMedicalHistory();
        UserEmergencyProfile profile = emergencyProfileRepository.findByCitizenAndDeletedFlagFalse(citizen.getCitizenId())
                .orElse(new UserEmergencyProfile()); // create if not exists
        profile.setCitizen(citizen);
        profile.setBloodGroup(historyDTO.getBloodGroup());
        profile.setMedicalConditions(historyDTO.getMedicalCondition());
        profile.setAllergies(historyDTO.getAllergies());
        profile.setSpecialRequirements(historyDTO.getSpecialRequirement());
        profile.setUpdatedAt(LocalDateTime.now());
        profile.setDeletedFlag(false);
        emergencyProfileRepository.save(profile);
    }

    private void updateEmergencyContactDetails(UserRequestDTO onboardingDTO, Users users) {
        EmergencyContactReqDTO contactDTO = onboardingDTO.getEmergencyContact();
        UserEmergencyContact contact = emergencyContactRepository
                .findByUserIdAndEmergencyContactIdAndDeletedFlagFalse(users.getUserId(),contactDTO.getEmergencyContId())
                .orElse(new UserEmergencyContact()); // create if not exists
        contact.setUser(users);
        contact.setContactName(contactDTO.getContactName());
        contact.setRelationship(contactDTO.getRelationShip());
        contact.setPhoneNumber(contactDTO.getPhoneNumber());
        contact.setEmail(contactDTO.getEmail());
        contact.setIsPrimary(contactDTO.getIsPrimary() != null ? contactDTO.getIsPrimary() : false);
        contact.setUpdatedAt(LocalDateTime.now());
        contact.setDeletedFlag(false);
        emergencyContactRepository.save(contact);
    }

    private void updatePrimaryAddress(UserAddressReqDTO primaryDTO, Users users) {

        UserAddress primaryAddress = addressRepository.findByUserAndIsPrimaryAndDeletedFlagFalse(users.getUserId(),primaryDTO.getIsPrimary())
                .orElse(new UserAddress()); // create if not exists
        primaryAddress.setUser(users);
        primaryAddress.setAddressLine(primaryDTO.getAddressLine());
        primaryAddress.setLandmark(primaryDTO.getLandMark());
        primaryAddress.setPostalCode(primaryDTO.getPostalCode());
        primaryAddress.setLatitude(primaryDTO.getLatitude());
        primaryAddress.setLongitude(primaryDTO.getLongitude());
        primaryAddress.setIsPrimary(true);
        primaryAddress.setDeletedFlag(false);
        primaryAddress.setUpdatedAt(LocalDateTime.now());
        if (primaryDTO.getGeoStructId() != null) {
            GeoStructure geo = geoStructureRepository.findById(primaryDTO.getGeoStructId()).orElse(null);
            primaryAddress.setGeoStructure(geo);
        }
        addressRepository.save(primaryAddress);
    }

    @Override
    public GeneralResponseDTO fetchUser( UserCacheDTO cacheDTO) {
        return null;
    }

    @Transactional(rollbackOn = Exception.class)
    public GeneralResponseDTO deleteUser(UserCacheDTO cacheDTO) {

        Users users = usersRepository.findAllByUserIdAndDeletedFlagFalse(cacheDTO.getUserId())
                .orElseThrow(() -> new CustomValidationException(ErrorCodes.ERRORCODES_2003));

        LocalDateTime now = LocalDateTime.now();

        // Soft delete User
        users.setDeletedFlag(true);
        users.setUpdatedAt(now);
        usersRepository.save(users);

        // Soft delete Citizen
        Citizen citizen = citizenRepository.findByUserIdAndDeletedFlagFalse(users.getUserId()).orElse(null);
        if(null != citizen){
            citizen.setDeletedFlag(true);
            citizen.setUpdatedAt(now);
            citizenRepository.save(citizen);
        }

        // Soft delete Addresses
        addressRepository.findAllByUserAndDeletedFlagFalse(users.getUserId()).forEach(address -> {
            address.setDeletedFlag(true);
            address.setUpdatedAt(now);
            addressRepository.save(address);
        });

        // Soft delete Medical Profile
        UserEmergencyProfile profile = emergencyProfileRepository.findByCitizenAndDeletedFlagFalse(citizen.getCitizenId()).orElse(null);
        if(null != profile){
            profile.setDeletedFlag(true);
            profile.setUpdatedAt(now);
            emergencyProfileRepository.save(profile);
        }

        // Soft delete Medical Profile
        List<UserEmergencyContact> contacts = emergencyContactRepository.findAllByUserIdAndDeletedFlagFalse(users.getUserId());
        if(!contacts.isEmpty()){
            contacts.forEach(c->{
                c.setDeletedFlag(true);
            });

            emergencyContactRepository.saveAll(contacts);
        }

        GeneralResponseDTO responseDTO = new GeneralResponseDTO();
        responseDTO.setMsg("ser deleted successfully ");
        responseDTO.setStatus(true);
        return responseDTO;
    }

}
