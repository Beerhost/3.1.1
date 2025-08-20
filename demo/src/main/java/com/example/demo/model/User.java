package com.example.demo.model;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "marriage")
    private boolean marriage;

    public User(String name, int age, String gender, boolean marriage) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.marriage = marriage;
    }

    public User() {

    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isMarriage() {
        return marriage;
    }

    public void setMarriage(boolean marriage) {
        this.marriage = marriage;
    }

}
