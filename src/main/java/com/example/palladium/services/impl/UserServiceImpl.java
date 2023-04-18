package com.example.palladium.services.impl;

import com.example.palladium.dto.UserRegistrationDto;
import com.example.palladium.model.User;
import com.example.palladium.repository.UserRepository;
import com.example.palladium.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public String userRegistration(UserRegistrationDto userRegistrationDto) {
        User user = User.builder()
                .fullName(userRegistrationDto.getFullName())
                .username(userRegistrationDto.getUsername())
                .email(userRegistrationDto.getEmail())
                .address(userRegistrationDto.getAddress())
                .phoneNumber(userRegistrationDto.getPhoneNumber())
                        .build();
        userRepository.save(user);
        return "You have successfully signed up";
    }

    @Override
    public Page<User> listRegisteredUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
