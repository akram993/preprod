package com.devmagri.tradimeals.controllers;

import com.devmagri.tradimeals.dtos.ClientDTO;
import com.devmagri.tradimeals.dtos.UserProfileDTO;
import com.devmagri.tradimeals.entities.UserProfile;
import com.devmagri.tradimeals.exceptions.UserNotFoundException;
import com.devmagri.tradimeals.services.ClientService;
import com.devmagri.tradimeals.services.UserProfileService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;

    @PostMapping("/profile/{clientId}")
    public void saveUserProfile(@RequestBody UserProfileDTO userProfileDTO, @PathVariable("clientId") Long clientId) throws UserNotFoundException {
        userProfileService.saveUserProfile(userProfileDTO, clientId);
    }
}
