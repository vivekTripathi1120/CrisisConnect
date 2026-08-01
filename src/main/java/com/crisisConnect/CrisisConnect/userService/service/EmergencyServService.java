package com.crisisConnect.CrisisConnect.userService.service;

import com.crisisConnect.CrisisConnect.userService.dtos.OnboardingDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

@Service
public interface EmergencyServService {
    HttpStatusCode onboardEmerServ(OnboardingDTO onboardingDTO);

    HttpStatusCode emerServVerif(Long emerServId, Integer verStat, Long verifrId);
}
