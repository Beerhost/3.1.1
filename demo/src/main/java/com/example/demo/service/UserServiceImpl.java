package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.UserDao;
import com.example.demo.model.User;

import java.util.List;
@Service
public class UserServiceImpl implements com.example.demo.service.UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(String name, int age, String gender, boolean marriage) {
        userDao.addUser(name, age, gender, marriage);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void changeUser(int id, String name, int age, String gender, boolean marriage) {
        userDao.changeUser(id, name, age, gender, marriage);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}