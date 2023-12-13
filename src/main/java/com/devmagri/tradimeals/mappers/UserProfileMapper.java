package com.devmagri.tradimeals.mappers;

import com.devmagri.tradimeals.dtos.ClientDTO;
import com.devmagri.tradimeals.dtos.UserProfileDTO;
import com.devmagri.tradimeals.entities.Client;
import com.devmagri.tradimeals.entities.UserProfile;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserProfileMapper {
    public UserProfile fromUserProfileDTO(UserProfileDTO userProfileDTO){
        UserProfile userProfile = new UserProfile();
        BeanUtils.copyProperties(userProfileDTO, userProfile);
        return userProfile;
    }

    public UserProfileDTO fromUserProfile(UserProfile userProfile){
        UserProfileDTO userProfileDTO = new UserProfileDTO();
        BeanUtils.copyProperties(userProfile, userProfileDTO);
        return userProfileDTO;
    }
}
