package com.nerdtic.humanos.security.repositories;

import com.nerdtic.humanos.security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
   List<User> findAllByFirstNameContaining(String name);
}
