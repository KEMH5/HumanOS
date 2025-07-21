package com.nerdtic.humanos.security.service;

import com.nerdtic.humanos.security.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    User createUser(User user);

    List<User> getAllUsers();

    User getUser(Long id);

    void deleteUser(Long id);

    List<User> getAllUserByFirstName(String name);

}
