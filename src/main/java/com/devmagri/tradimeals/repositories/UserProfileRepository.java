package com.devmagri.tradimeals.repositories;

import com.devmagri.tradimeals.entities.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
