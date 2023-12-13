package com.devmagri.tradimeals.dtos;

import com.devmagri.tradimeals.enums.ProfileEnum;
import lombok.Data;

@Data
public class UserProfileDTO {
    private Long id;
    private String firstname;
    private String lastname;
}
