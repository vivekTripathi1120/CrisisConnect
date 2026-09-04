package com.crisisConnect.CrisisConnect.masterService.service;

import com.crisisConnect.CrisisConnect.masterService.dtos.GeneralResponseDTO;
import com.crisisConnect.CrisisConnect.masterService.dtos.OnboardingDTO;
import com.crisisConnect.CrisisConnect.masterService.dtos.UserCacheDTO;
import com.crisisConnect.CrisisConnect.masterService.dtos.UserRequestDTO;

public interface UsersService {
    public GeneralResponseDTO registerUser(OnboardingDTO onboardingDTO);

    GeneralResponseDTO completeProfile(UserRequestDTO onboardingDTO, UserCacheDTO cacheDTO);

    GeneralResponseDTO fetchUser(UserCacheDTO cacheDTO);

    GeneralResponseDTO updateDetails(UserRequestDTO onboardingDTO, UserCacheDTO cacheDTO);

    GeneralResponseDTO deleteUser( UserCacheDTO cacheDTO);
}
