package com.crisisConnect.CrisisConnect.masterService.service;

import com.crisisConnect.CrisisConnect.masterService.dtos.GeneralResponseDTO;
import com.crisisConnect.CrisisConnect.masterService.dtos.OnboardingDTO;
import com.crisisConnect.CrisisConnect.masterService.dtos.RegistrationResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface EmergencyServService {
    RegistrationResponseDTO onboardEmerServ(OnboardingDTO onboardingDTO);

    GeneralResponseDTO emerServVerif(Long emerServId, Integer verType, Long verifrId);
}
