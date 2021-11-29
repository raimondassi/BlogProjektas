package com.spring.blogproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "blogs")
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;
    private String title;
    private String image;
    //    @Column(columnDefinition = "text")
    private String text;
    private Date date;
    @ManyToOne
    private BlogCategory blogcategory;

    public Blog(String title, String image, String text, Date date, BlogCategory blogcategory) {
        this.title = title;
        this.image = image;
        this.text = text;
        this.date = date;
        this.blogcategory = blogcategory;
    }
}
