package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    void addUser(String name, int age, String gender, boolean marriage);

    List<User> getAllUsers();

    void changeUser(int id, String name, int age, String gender, boolean marriage);

    void deleteUser(int id);
}
