package com.spring.blogproject.repository;

import com.spring.blogproject.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BlogRepository extends JpaRepository<Blog, UUID> {

    //  List<Blog> findAllByBlogcategory(BlogCategory blogcategory);

}
