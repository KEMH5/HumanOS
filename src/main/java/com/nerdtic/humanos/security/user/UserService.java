package com.nerdtic.humanos.security.user;

import java.util.List;


public interface UserService {
    User createUser(UserCreateRequest createRequest);

    List<User> getAllUsers();

    User getUser(Long id);

    void deleteUser(Long id);

    List<User> getAllUserByFirstName(String name);

}
