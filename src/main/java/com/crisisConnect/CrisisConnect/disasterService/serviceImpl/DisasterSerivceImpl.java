package com.crisisConnect.CrisisConnect.disasterService.serviceImpl;

import com.crisisConnect.CrisisConnect.masterService.dtos.GeneralResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class DisasterSerivceImpl {
    @Autowired


    public GeneralResponseDTO reportDisaster(){

        GeneralResponseDTO responseDTO = new GeneralResponseDTO();
        responseDTO.setStatus(true);

        return responseDTO;
    }
}
