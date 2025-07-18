package com.nerdtic.humanos.security.services;

import com.nerdtic.humanos.security.entities.User;

import java.util.List;


public interface UserService {
    User createUser(User user);

    List<User> getAllUsers();

    User getUser(Integer id);

    void deleteUser(Integer id);

    List<User> getAllUserByFirstName(String name);

}
