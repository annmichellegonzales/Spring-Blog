package com.codeup.SpringBlog.repositories;

import com.codeup.SpringBlog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Post, Long> {

}
