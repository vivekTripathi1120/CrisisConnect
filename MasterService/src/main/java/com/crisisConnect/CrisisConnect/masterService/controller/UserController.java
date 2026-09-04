package com.crisisConnect.CrisisConnect.masterService.controller;

import com.crisisConnect.CrisisConnect.masterService.authService.JwtService;
import com.crisisConnect.CrisisConnect.masterService.dtos.GeneralResponseDTO;
import com.crisisConnect.CrisisConnect.masterService.dtos.OnboardingDTO;
import com.crisisConnect.CrisisConnect.masterService.dtos.UserCacheDTO;
import com.crisisConnect.CrisisConnect.masterService.dtos.UserRequestDTO;
import com.crisisConnect.CrisisConnect.masterService.service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.annotations.Audited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UsersService usersService;

    @PostMapping("/unsecure/register")
    public ResponseEntity<GeneralResponseDTO> registerUser(@RequestBody OnboardingDTO onboardingDTO){
        return new ResponseEntity<>(usersService.registerUser(onboardingDTO), HttpStatus.CREATED);
    }


    @PostMapping("/completeProfile")
    public ResponseEntity<GeneralResponseDTO> completeProfile(@RequestBody UserRequestDTO onboardingDTO,
                                                              HttpServletRequest request){
        UserCacheDTO cacheDTO = JwtService.extractUserCache(request);
        return new ResponseEntity<>(usersService.completeProfile(onboardingDTO,cacheDTO),HttpStatus.ACCEPTED);
    }

    @GetMapping("/fetchUser")
    public ResponseEntity<GeneralResponseDTO> fetchUser(HttpServletRequest request){
        UserCacheDTO cacheDTO = JwtService.extractUserCache(request);
        return new ResponseEntity<>(usersService.fetchUser(cacheDTO), HttpStatus.OK);
    }

    @PostMapping("/updateDetails")
    public ResponseEntity<GeneralResponseDTO> updateDetails(@RequestBody UserRequestDTO onboardingDTO,
                                                            HttpServletRequest request){
        UserCacheDTO cacheDTO = JwtService.extractUserCache(request);
        return new ResponseEntity<>(usersService.updateDetails(onboardingDTO,cacheDTO), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<GeneralResponseDTO> deleteUser(HttpServletRequest request){
        UserCacheDTO cacheDTO = JwtService.extractUserCache(request);
        return new ResponseEntity<>(usersService.deleteUser(cacheDTO), HttpStatus.OK);
    }
}
