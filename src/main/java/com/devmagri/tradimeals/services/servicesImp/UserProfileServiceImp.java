package com.devmagri.tradimeals.services.servicesImp;

import com.devmagri.tradimeals.dtos.UserProfileDTO;
import com.devmagri.tradimeals.entities.Client;
import com.devmagri.tradimeals.entities.UserProfile;
import com.devmagri.tradimeals.enums.ProfileEnum;
import com.devmagri.tradimeals.exceptions.UserNotFoundException;
import com.devmagri.tradimeals.mappers.ClientMapper;
import com.devmagri.tradimeals.mappers.UserProfileMapper;
import com.devmagri.tradimeals.repositories.ClientRepository;
import com.devmagri.tradimeals.repositories.UserProfileRepository;
import com.devmagri.tradimeals.services.UserProfileService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class UserProfileServiceImp implements UserProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;
    @Autowired
    private UserProfileMapper userProfileMapper;
    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public UserProfileDTO saveUserProfile(UserProfileDTO userProfileDTO, Long clientId) throws UserNotFoundException {
        Client client = clientRepository.findById(clientId).orElseThrow(null);
        if(client == null){
            throw new UserNotFoundException("user not found");
        }
        UserProfile userProfile = userProfileMapper.fromUserProfileDTO(userProfileDTO);
        userProfile.setIsActive(ProfileEnum.ACTIVE);
        userProfile.setClient(client);
        client.setProfile(userProfile);
        UserProfile savedUserProfile = userProfileRepository.save(userProfile);
        return userProfileMapper.fromUserProfile(savedUserProfile);
    }
}
