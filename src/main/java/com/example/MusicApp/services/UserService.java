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
        User getUserById(Integer id);
        void addRoleToUser(String username, Integer roleId); //save role to user and attach role to user
        void getUser(String username);
        void deleteUser(Integer id);
        List<User>getAllUsers();
}

