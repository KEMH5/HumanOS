package com.nerdtic.humanos.security.services;

import com.nerdtic.humanos.security.dto.UserCreateRequest;
import com.nerdtic.humanos.security.entities.User;

import java.util.List;


public interface UserService {
    User createUser(UserCreateRequest createRequest);

    List<User> getAllUsers();

    User getUser(Long id);

    void deleteUser(Long id);

    List<User> getAllUserByFirstName(String name);

}
