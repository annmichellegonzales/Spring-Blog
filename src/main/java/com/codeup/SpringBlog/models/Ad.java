package com.codeup.SpringBlog.models;
import javax.persistence.*;

@Entity
@Table(name = "ads")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(unique = true, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private int priceInCents;

}
