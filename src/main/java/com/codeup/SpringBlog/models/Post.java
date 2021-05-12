package com.codeup.SpringBlog.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "posts")
public class Post {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(columnDefinition = "TEXT NOT NULL")
    private String body;

    @ManyToOne
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    private PostDetails postDetails;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "post",
            orphanRemoval = true
    )
    private List<PostImages> images;

    public Post(){
    }

    public Post(long id, String title, String body, User user, PostDetails postDetails, List<PostImages> images) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
        this.postDetails = postDetails;
        this.images = images;
    }

    public Post(String title, String body, PostDetails postDetails) {
        this.title = title;
        this.body = body;
        this.postDetails = postDetails;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public PostDetails getPostDetails() {
        return postDetails;
    }

    public void setPostDetails(PostDetails postDetails) {
        this.postDetails = postDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<PostImages> getImages() {
        return images;
    }

    public void setImages(List<PostImages> images) {
        this.images = images;
    }
}