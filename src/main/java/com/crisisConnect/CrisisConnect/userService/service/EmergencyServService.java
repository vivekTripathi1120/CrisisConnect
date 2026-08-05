package com.crisisConnect.CrisisConnect.userService.service;

import com.crisisConnect.CrisisConnect.userService.dtos.GeneralResponseDTO;
import com.crisisConnect.CrisisConnect.userService.dtos.OnboardingDTO;
import com.crisisConnect.CrisisConnect.userService.dtos.RegistrationResponseDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

@Service
public interface EmergencyServService {
    RegistrationResponseDTO onboardEmerServ(OnboardingDTO onboardingDTO);

    GeneralResponseDTO emerServVerif(Long emerServId, Integer verType, Long verifrId);
}
