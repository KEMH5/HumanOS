package com.nerdtic.humanos.security.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(
            @RequestBody
            UserCreateRequest user
    ) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{user-id}")
    public User getUserById(
            @PathVariable("user-id")
            Long userId
    ){
        return userService.getUser(userId);
    }

    @GetMapping("/{user-name}")
    public List<User> getUserByName(
            @PathVariable("user-name")
            String userName
    ){
        return userService.getAllUserByFirstName(userName);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(
            Long id
    ){
        userService.deleteUser(id);
    }


}
