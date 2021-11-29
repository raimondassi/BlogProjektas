package com.spring.blogproject.service;

import com.spring.blogproject.entity.Blog;
import com.spring.blogproject.entity.Comment;
import com.spring.blogproject.exception.BlogNotExistException;
import com.spring.blogproject.repository.CommentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    Page<Comment> getBlogs(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    public void updateComment(Comment comment) {
        commentRepository.save(comment);
    }

    public Comment getBlog(UUID id) {
        return commentRepository.findById(id).orElseThrow(() -> new BlogNotExistException(id));
    }

    public void deleteComment(UUID id) {
        commentRepository.deleteById(id);
    }

    public List<Comment> getAllCommentsByBlog(Blog blog) {
        return commentRepository.findAllByBlog(blog);
    }

}
