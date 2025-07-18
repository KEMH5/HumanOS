package com.nerdtic.humanos.security.services.Impl;

import com.nerdtic.humanos.security.entities.User;
import com.nerdtic.humanos.security.repositories.UserRepository;
import com.nerdtic.humanos.security.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Integer id) {
        return userRepository.findById(id)
                .orElse(null);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUserByFirstName(String name) {
        return userRepository.findAllByFirstNameContaining(name);
    }
}
