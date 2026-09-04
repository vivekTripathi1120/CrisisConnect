package com.crisisConnect.CrisisConnect.masterService.serviceImpl;

import com.crisisConnect.CrisisConnect.exception.CustomValidationException;
import com.crisisConnect.CrisisConnect.exception.ErrorCodes;
import com.crisisConnect.CrisisConnect.masterService.dtos.GeneralResponseDTO;
import com.crisisConnect.CrisisConnect.masterService.dtos.OnboardingDTO;
import com.crisisConnect.CrisisConnect.masterService.dtos.RegistrationResponseDTO;
import com.crisisConnect.CrisisConnect.masterService.entity.Administrator;
import com.crisisConnect.CrisisConnect.masterService.repository.AdministratorRepository;
import com.crisisConnect.CrisisConnect.masterService.service.EmergencyServService;
import com.crisisConnect.CrisisConnect.masterService.utils.UserConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmergencyServServiceImpl implements EmergencyServService {

    @Autowired
    AdministratorRepository administratorRepository;

    @Override
    public RegistrationResponseDTO onboardEmerServ(OnboardingDTO onboardingDTO) {

        if(UserConstants.HOSPITAL_TYPE.equals(onboardingDTO.getServiceType())){

        } else if (UserConstants.SHELTER_TYPE.equals(onboardingDTO.getServiceType())) {

        } else if (UserConstants.POLICE_STATION_TYPE.equals(onboardingDTO.getServiceType())) {

        } else if (UserConstants.FIRE_STATION_TYPE.equals(onboardingDTO.getServiceType())) {

        }

        RegistrationResponseDTO responseDTO = new RegistrationResponseDTO();
        return responseDTO;
    }

    @Override
    public GeneralResponseDTO emerServVerif(Long emerServId, Integer verType, Long verifrId) {

        Administrator administrator = administratorRepository.findByUserId(verifrId);

        if(UserConstants.HOSPITAL_TYPE.equals(verType.longValue())){}
        else if(UserConstants.FIRE_STATION_TYPE.equals(verType.longValue() )){}
        else if(UserConstants.SHELTER_TYPE.equals(verType.longValue())){}
        else if(UserConstants.POLICE_STATION_TYPE.equals(verType.longValue())){}


        if(null == administrator){
            throw new CustomValidationException(ErrorCodes.USER_NOT_FOUND);
        }

        GeneralResponseDTO responseDTO = new GeneralResponseDTO();

        return responseDTO;

    }
}
