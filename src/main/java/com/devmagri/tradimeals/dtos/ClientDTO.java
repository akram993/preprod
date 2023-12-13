package com.devmagri.tradimeals.dtos;

import com.devmagri.tradimeals.entities.UserProfile;
import lombok.Data;

@Data
public class ClientDTO {
    private Long id;
    private String email;
    private String password;
}
