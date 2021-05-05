package com.codeup.SpringBlog.models;

import javax.persistence.*;

@Entity
public class PostDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isAwesome;
    private String historyOfPost;
    private String topicDescription;

    @OneToOne(cascade = CascadeType.ALL)
    private Post post;

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}