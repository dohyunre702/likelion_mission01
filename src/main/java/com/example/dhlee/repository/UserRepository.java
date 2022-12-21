package com.example.dhlee.repository;

import com.example.dhlee.domain.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<UserDto, Long> {

    UserDetails getByUid(String uid);


}
