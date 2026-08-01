package com.crisisConnect.CrisisConnect.userService.controller;

import com.crisisConnect.CrisisConnect.userService.dtos.GeneralResponseDTO;
import com.crisisConnect.CrisisConnect.userService.dtos.OnboardingDTO;
import com.crisisConnect.CrisisConnect.userService.dtos.RegistrationResponseDTO;
import com.crisisConnect.CrisisConnect.userService.service.EmergencyServService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emergencyService")
public class EmergencyServicesController {

    @Autowired
    EmergencyServService emerServ;

    @PostMapping("/onboard")
    private ResponseEntity<RegistrationResponseDTO> onboardEmerServ(@RequestBody OnboardingDTO onboardingDTO){
        return new ResponseEntity<>(emerServ.onboardEmerServ(onboardingDTO));
    }

    @PutMapping("/emerServVerif")
    private ResponseEntity<GeneralResponseDTO> emerServVerif(@RequestParam Long emerServId, @RequestParam Integer verStat,
                                                             @RequestParam Long verifrId){
        return new ResponseEntity<>(emerServ.emerServVerif(emerServId,verStat,verifrId));
    }
}
