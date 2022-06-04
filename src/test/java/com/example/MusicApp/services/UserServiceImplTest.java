package com.example.MusicApp.services;

import com.example.MusicApp.repositories.RoleRepository;
import com.example.MusicApp.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    private UserServiceImpl underTest;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        underTest = new UserServiceImpl(userRepository, roleRepository, passwordEncoder);
    }

    @Test
    @Disabled
    void loadUserByUsername() {
    }

    @Test
    @Disabled
    void saveUser() {
    }

    @Test
    @Disabled
    void saveRole() {
    }

    @Test
    @Disabled
    void addRoleToUser() {
    }

    @Test
    @Disabled
    void getUser() {
    }

    @Test
    void canGetAllUsers() {
        underTest.getAllUsers();
        verify(userRepository).findAll();
    }

    @Test
    @Disabled
    void deleteUser() {
    }
}