package com.example.MusicApp.services;

import com.example.MusicApp.models.Role;
import com.example.MusicApp.models.User;


import java.util.List;

/**
     * All the methods listed to manage users and need to implement methods
     * into User Service
     */

    public interface UserService {
        User saveUser(User user);
        Role saveRole(Role role);
        void addRoleToUser(String username, String roleName); //save role to user and attach role to user
        User getUser(String username);
        List<User> getAllUsers();

    }

