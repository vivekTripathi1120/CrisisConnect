package com.crisisConnect.CrisisConnect.userService.service;

import com.crisisConnect.CrisisConnect.userService.dtos.CitizenDTO;
import com.crisisConnect.CrisisConnect.userService.dtos.GeneralResponseDTO;
import com.crisisConnect.CrisisConnect.userService.dtos.OnboardingDTO;
import com.crisisConnect.CrisisConnect.userService.dtos.RegistrationResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface CitizenService {
    RegistrationResponseDTO onboardUser(OnboardingDTO onboardingDTO);

    GeneralResponseDTO updateDetails(CitizenDTO citizenDTO);

    GeneralResponseDTO verifyPhoneNumber(Long citId, Long otp, Integer type);

    GeneralResponseDTO addEmergencyContact(Long citId, Long emerConNum);
}
