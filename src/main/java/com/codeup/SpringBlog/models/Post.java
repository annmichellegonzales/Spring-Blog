package com.codeup.SpringBlog.models;
import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT NOT NULL")
    private String body;

    @ManyToOne(optional=false)
    private User user;

    public Post(){
    }

    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post(long id, String title, String body, User user) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public Post(String title, String body) {
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
}