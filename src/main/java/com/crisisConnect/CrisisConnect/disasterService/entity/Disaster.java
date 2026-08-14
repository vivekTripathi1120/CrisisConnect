package com.crisisConnect.CrisisConnect.disasterService.entity;

import com.crisisConnect.CrisisConnect.disasterService.utils.DisasterEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "disaster")
public class Disaster {

    @Id
    private Enum<DisasterEnum> Type; //
    private Number Level; //upto 10;
}
