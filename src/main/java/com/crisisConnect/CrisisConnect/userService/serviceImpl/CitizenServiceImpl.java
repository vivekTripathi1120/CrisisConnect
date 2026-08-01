package com.crisisConnect.CrisisConnect.userService.serviceImpl;

import com.crisisConnect.CrisisConnect.userService.dtos.CitizenDTO;
import com.crisisConnect.CrisisConnect.userService.dtos.GeneralResponseDTO;
import com.crisisConnect.CrisisConnect.userService.dtos.OnboardingDTO;
import com.crisisConnect.CrisisConnect.userService.dtos.RegistrationResponseDTO;
import com.crisisConnect.CrisisConnect.userService.entity.CitizenMedicalData;
import com.crisisConnect.CrisisConnect.userService.repository.CitizenMedicalDataRepository;
import com.crisisConnect.CrisisConnect.userService.repository.CitizenRepository;
import com.crisisConnect.CrisisConnect.userService.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;

public class CitizenServiceImpl implements CitizenService {

    @Autowired
    CitizenRepository citizenRepository;

    @Autowired
    CitizenMedicalDataRepository medicalDataRepository;

    @Override
    public RegistrationResponseDTO onboardUser(OnboardingDTO onboardingDTO) {
        return null;
    }

    @Override
    public GeneralResponseDTO updateDetails(CitizenDTO citizenDTO) {
        return null;
    }

    @Override
    public GeneralResponseDTO verifyPhoneNumber(Long citId, Long otp, Integer type) {
        return null;
    }

    @Override
    public GeneralResponseDTO addEmergencyContact(Long citId, Long emerConNum) {
        return null;
    }
}
