package com.crisisConnect.CrisisConnect.masterService.dtos;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCacheDTO {

    private Long userId;
    private String username;
    private String email;
    private Long geoStructId;
    private Integer geoLevel;
    private Map<Long,String> roles;
}
