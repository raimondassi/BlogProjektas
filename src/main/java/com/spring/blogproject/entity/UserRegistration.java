package com.spring.blogproject.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserRegistration {
    @NotBlank
    private String username;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String repeatPassword;

}
