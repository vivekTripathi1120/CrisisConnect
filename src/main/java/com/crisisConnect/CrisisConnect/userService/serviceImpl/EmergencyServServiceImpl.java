package com.crisisConnect.CrisisConnect.userService.serviceImpl;

import com.crisisConnect.CrisisConnect.userService.dtos.OnboardingDTO;
import com.crisisConnect.CrisisConnect.userService.service.EmergencyServService;
import org.springframework.http.HttpStatusCode;

public class EmergencyServServiceImpl implements EmergencyServService {
    @Override
    public HttpStatusCode onboardEmerServ(OnboardingDTO onboardingDTO) {
        return null;
    }

    @Override
    public HttpStatusCode emerServVerif(Long emerServId, Integer verStat, Long verifrId) {
        return null;
    }
}
