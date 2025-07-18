package com.nerdtic.humanos.security.controllers;

import com.nerdtic.humanos.security.entities.User;
import com.nerdtic.humanos.security.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public User createUser(
            @RequestBody
            User user
    ) {
        return userService.createUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{user-id}")
    public User getUserById(
            @PathVariable("user-id")
            Integer userId
    ){
        return userService.getUser(userId);
    }

    @GetMapping("/users/{user-name}")
    public List<User> getUserByName(
            @PathVariable("user-name")
            String userName
    ){
        return userService.getAllUserByFirstName(userName);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(
            Integer id
    ){
        userService.deleteUser(id);
    }


}
