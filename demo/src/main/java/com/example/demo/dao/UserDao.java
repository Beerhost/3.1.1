package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.List;

public interface UserDao {
    public void addUser(String name, int age, String gender, boolean marriage);
    public List<User> getAllUsers();
    public void changeUser(int id, String name, int age, String gender, boolean marriage);
    public void deleteUser(int id);
}
