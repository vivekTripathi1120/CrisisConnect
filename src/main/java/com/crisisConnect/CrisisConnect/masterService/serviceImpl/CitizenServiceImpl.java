package com.crisisConnect.CrisisConnect.masterService.serviceImpl;

import com.crisisConnect.CrisisConnect.exception.CustomValidationException;
import com.crisisConnect.CrisisConnect.exception.ErrorCodes;
import com.crisisConnect.CrisisConnect.masterService.dtos.CitizenDTO;
import com.crisisConnect.CrisisConnect.masterService.dtos.GeneralResponseDTO;
import com.crisisConnect.CrisisConnect.masterService.dtos.OnboardingDTO;
import com.crisisConnect.CrisisConnect.masterService.dtos.RegistrationResponseDTO;
import com.crisisConnect.CrisisConnect.masterService.entity.Citizen;
import com.crisisConnect.CrisisConnect.masterService.repository.CitizenMedicalDataRepository;
import com.crisisConnect.CrisisConnect.masterService.repository.CitizenRepository;
import com.crisisConnect.CrisisConnect.masterService.repository.OtpHistoryRepository;
import com.crisisConnect.CrisisConnect.masterService.service.CitizenService;
import com.crisisConnect.CrisisConnect.masterService.utils.UserConstants;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class CitizenServiceImpl implements CitizenService {

    @Autowired
    CitizenRepository citizenRepository;

    @Autowired
    CitizenMedicalDataRepository medicalDataRepository;

    @Autowired
    OtpHistoryRepository otpHistoryRepository;

    @Autowired
    UserConstants userConstants;

    @Override
    public RegistrationResponseDTO onboardUser(OnboardingDTO onboardingDTO) throws CustomValidationException {

        Citizen citizen = new Citizen();

        if(!userConstants.CitizenUniqIdLength.equals(onboardingDTO.getUniqId().toString().length())){
            throw new CustomValidationException(ErrorCodes.CITIZEN_WRONG_UNIQUE_ID);
        }
        citizen.setCitizenName(onboardingDTO.getName());
        citizen.setAadharCardNumber(onboardingDTO.getUniqId());
        citizen.setPhoneNumber(onboardingDTO.getConNum());
        citizen.setEmergencyContactNumber(onboardingDTO.getEmerConNum());
        citizen.setPermanentAddress(onboardingDTO.getAddress());
        citizen.setFamilyMember(onboardingDTO.getHeadCount());
        citizen.setPhoneVerified(false);
        citizen.setEmergencyConNumVerified(false);
        citizen.setCreatedAt(LocalDateTime.now());
        citizen.setUpdatedAt(LocalDateTime.now());
        citizen.setCurrentAddress(onboardingDTO.getCurrentAddress());
        citizen.setZipCode(onboardingDTO.getZipCode());
        citizen.setCityId(onboardingDTO.getCityId());
        citizen.setCreatedBy("Admin");
        citizen.setUpdatedBy("Admin");
        citizenRepository.save(citizen);

        RegistrationResponseDTO responseDTO =  new RegistrationResponseDTO();
        responseDTO.setUsrId(citizen.getCitizenId());
        responseDTO.setName(citizen.getCitizenName());
        responseDTO.setPhoneNum(citizen.getPhoneNumber());

        return responseDTO;
    }

    @Override
    public GeneralResponseDTO updateDetails(CitizenDTO citizenDTO) {

        Citizen citizen = getCitizen(citizenDTO.getCitId());

        if(!citizen.getPhoneNumber().equals(citizenDTO.getPhoneNumber())){
            citizen.setPhoneNumber(citizenDTO.getPhoneNumber());
            citizen.setPhoneVerified(false);
        }

        if(!citizen.getEmergencyContactNumber().equals(citizenDTO.getEmergencyContactNumber())){
            citizen.setEmergencyContactNumber(citizenDTO.getEmergencyContactNumber());
            citizen.setEmergencyConNumVerified(false);
        }

        if(citizen.getPermanentAddress().equals(citizenDTO.getPermanentAddress())){
            citizen.setPermanentAddress(citizenDTO.getPermanentAddress());
            citizen.setCityId(citizenDTO.getCityId());
            citizen.setZipCode(citizenDTO.getZipCode());
        }

        if(citizen.getCurrentAddress().equals(citizenDTO.getCurrAddress())){
            citizen.setCurrentAddress(citizenDTO.getCurrAddress());
            citizen.setCityId(citizenDTO.getCityId());
            citizen.setZipCode(citizenDTO.getZipCode());
        }

        citizen.setUpdatedAt(LocalDateTime.now());
        citizen.setUpdatedBy("ADMIN");

        citizenRepository.save(citizen);

        GeneralResponseDTO responseDTO = new GeneralResponseDTO();
        responseDTO.setId(citizen.getCitizenId());
        responseDTO.setStatus(true);
        responseDTO.setTimeStamp(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
        responseDTO.setMsg(UserConstants.USER_UPDATE_MSG);

        return responseDTO;
    }



    private Citizen getCitizen(Long citId) {
        Citizen citizen = citizenRepository.findByCitizenId(citId);
        if(null == citizen){
            throw new CustomValidationException(ErrorCodes.USER_NOT_FOUND);
        }
        return citizen;
    }

    @Override
    public GeneralResponseDTO addEmergencyContact(Long citId, Long emerConNum) {

        Citizen citizen = getCitizen(citId);

        citizen.setEmergencyContactNumber(emerConNum);
        citizen.setEmergencyConNumVerified(false);
        citizenRepository.save(citizen);

        GeneralResponseDTO responseDTO = new GeneralResponseDTO();
        responseDTO.setMsg("Emergency Contact Updated Successfully!");
        responseDTO.setTimeStamp(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
        responseDTO.setStatus(true);
        return responseDTO;

    }
}
