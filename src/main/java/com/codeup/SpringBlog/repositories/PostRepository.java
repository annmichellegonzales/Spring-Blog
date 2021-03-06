package com.codeup.SpringBlog.repositories;


import com.codeup.SpringBlog.models.Post;
import com.codeup.SpringBlog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.codeup.SpringBlog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByTitle(String title);
}

