package com.codeup.SpringBlog.models;
import javax.persistence.*;

@Entity
@Table(name = "dogs")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long age;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String resideState;


    public Dog(long id, long age, String name, String resideState) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.resideState = resideState;
    }

    public Dog() {

    }


    public long getId() {
        return id;
    }


    public long getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getResideState() {
        return resideState;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setResideState(String resideState) {
        this.resideState = resideState;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
