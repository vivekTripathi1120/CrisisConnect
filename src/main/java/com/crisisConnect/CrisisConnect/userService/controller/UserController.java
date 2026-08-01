package com.crisisConnect.CrisisConnect.userService.controller;


import com.crisisConnect.CrisisConnect.userService.dtos.CitizenDTO;
import com.crisisConnect.CrisisConnect.userService.dtos.GeneralResponseDTO;
import com.crisisConnect.CrisisConnect.userService.dtos.OnboardingDTO;
import com.crisisConnect.CrisisConnect.userService.dtos.RegistrationResponseDTO;
import com.crisisConnect.CrisisConnect.userService.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    CitizenService citizenService;

    @PostMapping("/onboard")
    private ResponseEntity<RegistrationResponseDTO> oboardUser(@RequestBody OnboardingDTO onboardingDTO){
        return new ResponseEntity<>(citizenService.onboardUser(onboardingDTO), HttpStatus.CREATED);
    }

    @PutMapping("/updateDetails")
    private ResponseEntity<GeneralResponseDTO> updateDetails(@RequestBody CitizenDTO citizenDTO){
        return new ResponseEntity<>(citizenService.updateDetails(citizenDTO),HttpStatus.ACCEPTED);
    }

    @PostMapping("/verifyPhoneNumber")
    private ResponseEntity<GeneralResponseDTO> verifyPhoneNumber(@RequestParam Long citId, @RequestParam Long otp,
                                                                 @RequestParam Integer type){
        return new ResponseEntity<>(citizenService.verifyPhoneNumber(citId,otp,type),HttpStatus.OK);
    }

    @PostMapping("/addEmergencyContact")
    private ResponseEntity<GeneralResponseDTO> addEmergencyContact(@RequestParam Long citId, @RequestParam Long emerConNum){
        return new ResponseEntity<>(citizenService.addEmergencyContact(citId,emerConNum),HttpStatus.OK);
    }
}
