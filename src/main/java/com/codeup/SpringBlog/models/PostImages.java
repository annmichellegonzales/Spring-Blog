package com.codeup.SpringBlog.models;


import javax.persistence.*;

@Entity
@Table
public class PostImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private long id;

    @Column(nullable = false, length = 100)
    private String imageTitle;

    @Column(nullable = false, length = 1000)
    private String url;

    @ManyToOne
    private Post post;
}