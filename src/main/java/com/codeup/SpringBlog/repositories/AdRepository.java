package com.codeup.SpringBlog.repositories;

import com.codeup.SpringBlog.models.Ad;
import com.codeup.SpringBlog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad, Long> {
    Ad findByTitle(String title);
}
