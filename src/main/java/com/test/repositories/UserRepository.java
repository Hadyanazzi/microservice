package com.test.repositories;

import com.test.entities.User;
import org.springframework.data.jpa.repository.*;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
    Boolean existsByUsername(String username);
    User findByUsername(String username);
}
