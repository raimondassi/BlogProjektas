package com.spring.blogproject.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class BlogCategoryCreation {
    @NotBlank
    private String name;

}
