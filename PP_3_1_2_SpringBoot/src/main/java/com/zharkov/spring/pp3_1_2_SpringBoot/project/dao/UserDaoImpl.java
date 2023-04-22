package com.zharkov.spring.pp3_1_2_SpringBoot.project.dao;

import com.zharkov.spring.pp3_1_2_SpringBoot.project.model.User;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUserById(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }


    @Override
    public List<User> getAllUser() {
        return entityManager.createQuery("FROM User").getResultList();
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
/*    @Override
    public void userEditor(User user, Long id) {
        User existingUser = entityManager.find(User.class, id);
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        entityManager.merge(existingUser);
    }*/

}
