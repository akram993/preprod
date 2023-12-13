package com.devmagri.tradimeals.entities;

import com.devmagri.tradimeals.enums.ProfileEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private ProfileEnum isActive;
    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;
}

