package com.spring.blogproject.entity;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
//@Password
//@FieldComparator(firstField = "password", secondField = "repeatPassword")
public class UserRegistration {
    @NotBlank
    private String username;
    @NotBlank
    private String email;
    @NotBlank
    @Min(8)
    private String password;
    @NotBlank
    @Min(8)
    private String repeatPassword;

}
