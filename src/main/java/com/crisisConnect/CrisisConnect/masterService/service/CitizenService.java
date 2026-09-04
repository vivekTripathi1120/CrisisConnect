package com.crisisConnect.CrisisConnect.masterService.service;

import com.crisisConnect.CrisisConnect.exception.CustomValidationException;
import com.crisisConnect.CrisisConnect.masterService.dtos.CitizenDTO;
import com.crisisConnect.CrisisConnect.masterService.dtos.GeneralResponseDTO;
import com.crisisConnect.CrisisConnect.masterService.dtos.OnboardingDTO;
import com.crisisConnect.CrisisConnect.masterService.dtos.RegistrationResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface CitizenService {
    RegistrationResponseDTO onboardUser(OnboardingDTO onboardingDTO) throws CustomValidationException;

    GeneralResponseDTO updateDetails(CitizenDTO citizenDTO);

//    GeneralResponseDTO verifyPhoneNumber(Long citId, Long otp, Integer type, Integer userType, Long phoneNumber);

    GeneralResponseDTO addEmergencyContact(Long citId, Long emerConNum);
}
