package com.devmagri.tradimeals.services;

import com.devmagri.tradimeals.dtos.ClientDTO;
import com.devmagri.tradimeals.dtos.UserProfileDTO;
import com.devmagri.tradimeals.exceptions.UserNotFoundException;

public interface UserProfileService {
    UserProfileDTO saveUserProfile(UserProfileDTO userProfileDTO, Long clientId) throws UserNotFoundException;
}
