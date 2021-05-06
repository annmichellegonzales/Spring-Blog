package com.codeup.SpringBlog.models;
import org.springframework.cglib.core.ProcessArrayCallback;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(columnDefinition = "TEXT NOT NULL")
    private String body;

    @OneToOne(cascade = CascadeType.ALL)
    private PostDetails postDetails;

    public Post(){
    }

    public Post(long id, String title, String body, PostDetails postDetails) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.postDetails = postDetails;
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
}