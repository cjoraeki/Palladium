package com.example.palladium.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class UserRegistrationDto {
    @NotBlank
    private String username;
    @NotBlank
    private String fullName;
    @Email(message = "This field must be a valid email")
    @NotBlank
    private String email;
    private String address;
    @NotBlank
    private String phoneNumber;
}
