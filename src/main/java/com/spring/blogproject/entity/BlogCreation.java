package com.spring.blogproject.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
@NoArgsConstructor
public class BlogCreation {
    @NotBlank
    private String title;
    private String image;
    @NotBlank
    private String text;
    private UUID blogCategoryId;

    public BlogCreation(String title, String image, String text, UUID blogCategoryId) {
        this.title = title;
        this.image = image;
        this.text = text;
        this.blogCategoryId = blogCategoryId;
    }
}
