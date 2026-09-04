package com.crisisConnect.CrisisConnect.masterService.service;

import com.crisisConnect.CrisisConnect.masterService.dtos.GeneralResponseDTO;

public interface CommonUtilsService {
    GeneralResponseDTO triggerOtp(Long id, Long phoneNumber, Integer userType, Integer phoneType);

    GeneralResponseDTO verifyOtp(Long citId, Long otp, Integer phoneType, Integer userType,
                                        Long phoneNumber);
}
