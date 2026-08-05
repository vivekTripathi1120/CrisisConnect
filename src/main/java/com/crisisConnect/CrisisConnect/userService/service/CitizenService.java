package com.crisisConnect.CrisisConnect.userService.service;

import com.crisisConnect.CrisisConnect.exception.CustomValidationException;
import com.crisisConnect.CrisisConnect.userService.dtos.CitizenDTO;
import com.crisisConnect.CrisisConnect.userService.dtos.GeneralResponseDTO;
import com.crisisConnect.CrisisConnect.userService.dtos.OnboardingDTO;
import com.crisisConnect.CrisisConnect.userService.dtos.RegistrationResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface CitizenService {
    RegistrationResponseDTO onboardUser(OnboardingDTO onboardingDTO) throws CustomValidationException;

    GeneralResponseDTO updateDetails(CitizenDTO citizenDTO);

    GeneralResponseDTO verifyPhoneNumber(Long citId, Long otp, Integer type, Integer userType, Long phoneNumber);

    GeneralResponseDTO addEmergencyContact(Long citId, Long emerConNum);
}
