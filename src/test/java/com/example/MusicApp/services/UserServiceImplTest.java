package com.example.MusicApp.services;

import com.example.MusicApp.models.Role;
import com.example.MusicApp.models.User;
import com.example.MusicApp.repositories.RoleRepository;
import com.example.MusicApp.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    private UserServiceImpl underTest;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        underTest = new UserServiceImpl(userRepository, roleRepository, passwordEncoder);
    }

    @Test
    @Disabled
    void loadUserByUsername() {
    }

    //TODO: GETTING NULLPOINTEREXCEPTION FIX LATER
    @Test
    void ShouldSaveUser() {
        User user = new User();
        user.setId(1);
        user.setEmail("Joyful@email.com");
        user.setUsername("Joy123");
        user.setPassword(passwordEncoder.encode("Password!@"));

        underTest.saveUser(user);

        ArgumentCaptor<User> userArgumentCaptor =
                ArgumentCaptor.forClass(User.class);

        verify(userRepository).save(userArgumentCaptor.capture());

        User capturedUser = userArgumentCaptor.getValue();

        assertThat(capturedUser).isEqualTo(user);
    }

    @Test
    void ShouldSaveRole() {
        Role role = new Role(1, "User");
        underTest.saveRole(role);
        verify(roleRepository).save(role);
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