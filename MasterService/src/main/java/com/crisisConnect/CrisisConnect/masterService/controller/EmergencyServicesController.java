package com.crisisConnect.CrisisConnect.masterService.controller;

import com.crisisConnect.CrisisConnect.masterService.dtos.GeneralResponseDTO;
import com.crisisConnect.CrisisConnect.masterService.dtos.OnboardingDTO;
import com.crisisConnect.CrisisConnect.masterService.dtos.RegistrationResponseDTO;
import com.crisisConnect.CrisisConnect.masterService.service.EmergencyServService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emergencyService")
public class EmergencyServicesController {

    @Autowired
    EmergencyServService emerServ;

    @PostMapping("/onboard")
    private ResponseEntity<RegistrationResponseDTO> onboardEmerServ(@RequestBody OnboardingDTO onboardingDTO){
        return new ResponseEntity<>(emerServ.onboardEmerServ(onboardingDTO), HttpStatus.CREATED);
    }

    @PutMapping("/emerServVerif")
    private ResponseEntity<GeneralResponseDTO> emerServVerif(@RequestParam Long emerServId, @RequestParam Integer verType,
                                                             @RequestParam Long verifrId){
        return new ResponseEntity<>(emerServ.emerServVerif(emerServId,verType,verifrId),HttpStatus.OK);
    }
}
