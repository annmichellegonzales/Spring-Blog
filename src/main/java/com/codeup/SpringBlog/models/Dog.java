package com.codeup.SpringBlog.models;
import javax.persistence.*;

@Entity
@Table(name = "dogs")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 11)
    private long id;

    @Column(columnDefinition = "tinyint(3)", nullable = false)
    private short age;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(length=2, unique=true)
    private String resideState;

    public Dog() {

    }

    public Dog(long id, short age, String name, String resideState) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.resideState = resideState;
    }

    public long getId() {
        return id;
    }


    public short getAge() {
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

    public void setAge(short age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setResideState(String resideState) {
        this.resideState = resideState;
    }

}
