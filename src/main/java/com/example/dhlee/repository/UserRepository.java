package com.example.dhlee.repository;

import com.example.dhlee.domain.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDto, Long> {

    UserDto getById();


}
