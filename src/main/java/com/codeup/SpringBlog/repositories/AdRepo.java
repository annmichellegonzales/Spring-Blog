package com.codeup.SpringBlog.repositories;

import com.codeup.SpringBlog.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepo extends JpaRepository<Ad, Long> {


}
