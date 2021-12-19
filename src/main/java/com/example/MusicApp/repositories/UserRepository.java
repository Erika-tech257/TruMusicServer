package com.example.MusicApp.repositories;

import com.example.MusicApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String username);
    Optional<User> findUserByUsername(String username);

}

