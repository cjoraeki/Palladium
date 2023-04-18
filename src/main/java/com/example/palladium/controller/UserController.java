package com.example.palladium.controller;


import com.example.palladium.dto.UserRegistrationDto;
import com.example.palladium.model.User;
import com.example.palladium.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserRegistrationDto userRegistrationDto){
        return ResponseEntity.ok(userService.userRegistration(userRegistrationDto));
    }

    @GetMapping("/list-users/{from}/{to}")
    public ResponseEntity<Page<User>> listOfUsers(@PathVariable int from, @PathVariable int to){
        Pageable pageable = PageRequest.of(from, to);
        return ResponseEntity.ok(userService.listRegisteredUsers(pageable));
    }

}
