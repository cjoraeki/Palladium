package com.example.palladium.services;

import com.example.palladium.dto.UserRegistrationDto;
import com.example.palladium.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    String userRegistration(UserRegistrationDto userRegistrationDto);

    Page<User> listRegisteredUsers(Pageable pageable);
}
