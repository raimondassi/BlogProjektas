package com.spring.blogproject.repository;

import com.spring.blogproject.entity.BlogCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BlogCategoryRepository extends JpaRepository<BlogCategory, UUID> {

//    List<BlogCategory> findAllByBlogCategory(String blogCategory);
}
