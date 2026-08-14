package com.crisisConnect.CrisisConnect.masterService.controller;

import com.crisisConnect.CrisisConnect.masterService.dtos.GeneralResponseDTO;
import com.crisisConnect.CrisisConnect.masterService.service.CommonUtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utils")
public class CommonUtilController {

    @Autowired
    CommonUtilsService utilsService;

    @PostMapping("/triggerOtp")
    public ResponseEntity<GeneralResponseDTO> triggerOtp(@RequestParam Long id, @RequestParam Long phoneNumber,
                                                         @RequestParam Integer userType, @RequestParam Integer phoneType){

        return new ResponseEntity<>(utilsService.triggerOtp(id,phoneNumber,userType,phoneType), HttpStatus.OK);
    }

    @PostMapping("/verifyOtp")
    public ResponseEntity<GeneralResponseDTO> verifyOtp(@RequestParam Long id, @RequestParam Long phoneNumber,
                                                         @RequestParam Integer userType, @RequestParam Integer phoneType,
                                                        @RequestParam Long otp){

        return new ResponseEntity<>(utilsService.verifyOtp(id, otp, phoneType, userType, phoneNumber), HttpStatus.OK);
    }


}
