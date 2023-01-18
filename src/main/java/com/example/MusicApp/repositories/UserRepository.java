package com.example.MusicApp.repositories;

import com.example.MusicApp.models.User;
import com.example.MusicApp.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}

