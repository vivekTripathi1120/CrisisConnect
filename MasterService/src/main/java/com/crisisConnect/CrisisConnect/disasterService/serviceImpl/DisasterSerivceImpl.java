package com.crisisConnect.CrisisConnect.disasterService.serviceImpl;

import com.crisisConnect.CrisisConnect.disasterService.service.DisasterService;
import com.crisisConnect.CrisisConnect.masterService.dtos.GeneralResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisasterSerivceImpl implements DisasterService {
    @Autowired


    public GeneralResponseDTO reportDisaster(){

        GeneralResponseDTO responseDTO = new GeneralResponseDTO();
        responseDTO.setStatus(true);

        return responseDTO;
    }
}
