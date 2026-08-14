package com.crisisConnect.CrisisConnect.disasterService.controller;

import com.crisisConnect.CrisisConnect.disasterService.service.DisasterService;
import com.crisisConnect.CrisisConnect.masterService.dtos.GeneralResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/disaster")
public class DisasterController {

    @Autowired
    DisasterService disasterService;

    @PostMapping("/report")
    public ResponseEntity<GeneralResponseDTO> reportDisaster(){
        return new ResponseEntity<>(disasterService.reportDisaster(), HttpStatus.CREATED);
    }


}
