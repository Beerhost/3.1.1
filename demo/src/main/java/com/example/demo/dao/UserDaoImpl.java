package com.example.demo.dao;



import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements com.example.demo.dao.UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addUser(String name, int age, String gender, boolean marriage) {
        User user = new User(name, age, gender, marriage);
        entityManager.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    @Transactional
    public void changeUser(int id, String name, int age, String gender, boolean marriage) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            user.setName(name);
            user.setAge(age);
            user.setGender(gender);
            user.setMarriage(marriage);
        }
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}
