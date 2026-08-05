package com.crisisConnect.CrisisConnect.userService.serviceImpl;

import com.crisisConnect.CrisisConnect.exception.CustomValidationException;
import com.crisisConnect.CrisisConnect.exception.ErrorCodes;
import com.crisisConnect.CrisisConnect.userService.dtos.GeneralResponseDTO;
import com.crisisConnect.CrisisConnect.userService.entity.Citizen;
import com.crisisConnect.CrisisConnect.userService.entity.OtpHistory;
import com.crisisConnect.CrisisConnect.userService.repository.CitizenRepository;
import com.crisisConnect.CrisisConnect.userService.repository.OtpHistoryRepository;
import com.crisisConnect.CrisisConnect.userService.service.CommonUtilsService;
import com.crisisConnect.CrisisConnect.userService.utils.UserConstants;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class CommonUtilsServiceImpl implements CommonUtilsService {

    @Autowired
    CitizenRepository citizenRepository;

    @Autowired
    OtpHistoryRepository otpHistoryRepository;

    @Override
    public GeneralResponseDTO triggerOtp(Long id, Long phoneNumber, Integer userType, Integer phoneType) {
        return null;
    }


    @Override
    public GeneralResponseDTO verifyOtp(Long citId, Long otp, Integer phoneType, Integer userType,
                                                Long phoneNumber) {

        if(UserConstants.USER_TYPE.equals(userType) ){
            verifyUserOtp(citId, otp, phoneType, userType, phoneNumber);
        }
        if(UserConstants.EMERGENCY_AUTHROITY_TYPE.equals(userType)){
            //
        }

        GeneralResponseDTO responseDTO = new GeneralResponseDTO();
        responseDTO.setMsg("Verified SuccessFully!");
        responseDTO.setStatus(true);
        responseDTO.setTimeStamp(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
        return responseDTO;
    }

    private void verifyUserOtp(Long citId, Long otp, Integer phoneType, Integer userType, Long phoneNumber) {
        Citizen citizen = getCitizen(citId);

        OtpHistory otpHistory = otpHistoryRepository
                .findByIdAndPhoneNumberAndPhoneTypeAndUserType(citId, phoneNumber, phoneType, userType);

        if(null == otpHistory || !citizen.getPhoneNumber().equals(otpHistory.getPhoneNumber()) ||
                !otpHistory.getOtp().equals(otp) ){
            throw new CustomValidationException(ErrorCodes.INVALID_OTP);
        }

        if(UserConstants.USER_PHONE_TYPE.equals(phoneType)){
            citizen.setPhoneVerified(true);
        }
        else if (UserConstants.USER_EMERGENCY_PHONE_TYPE.equals(phoneType)){
            citizen.setEmergencyConNumVerified(true);
        }
    }



    private Citizen getCitizen(Long citId) {
        Citizen citizen = citizenRepository.findByCitizenId(citId);
        if(null == citizen){
            throw new CustomValidationException(ErrorCodes.USER_NOT_FOUND);
        }
        return citizen;
    }
}
