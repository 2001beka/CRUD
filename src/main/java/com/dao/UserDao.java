package com.dao;

import com.model.User;

import java.util.List;

public interface UserDao {

    User getByName(String name);

    void saveUser(User user);

    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUser(User user);

    User getById(Long id);

}
