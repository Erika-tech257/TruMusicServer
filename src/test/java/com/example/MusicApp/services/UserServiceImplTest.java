package com.example.MusicApp.services;

import com.example.MusicApp.models.Role;
import com.example.MusicApp.models.User;
import com.example.MusicApp.repositories.RoleRepository;
import com.example.MusicApp.repositories.UserInfoRepository;
import com.example.MusicApp.repositories.UserRepository;
import com.example.MusicApp.services.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserServiceImpl underTest;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserInfoRepository userInfoRepository;

    @BeforeEach
    void setUp() {
        underTest = new UserServiceImpl(userRepository, roleRepository, passwordEncoder, userInfoRepository);
    }

    @Test
    @Disabled
    void loadUserByUsername() {
    }

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
    void shouldSaveRole() {
        Role role = new Role(1, "User");
        underTest.saveRole(role);
        verify(roleRepository).save(role);
    }

//    //TODO: Executes but throws a GETTING NULLPOINTEREXCEPTION
    @Test
    @Disabled
    void shouldAddRoleToUser(){
        String username = "Lucky";
        Integer roleId = 2;
       underTest.addRoleToUser(username, roleId);
        User user = verify(userRepository).findByUsername(username);
        Role role = verify(roleRepository).findByRoleId(roleId);
        assertThat(user.getRoles().add(role)).isNotNull();
    }

    @Test
    void shouldGetUser() {
        String name = "Snoopy";
        underTest.getUser(name);
        verify(userRepository).findByUsername(name);

    }

    @Test
    void canGetAllUsers() {
        underTest.getAllUsers();
        verify(userRepository).findAll();
    }

    @Test
    void deleteUser() {
        int id = 2;
        boolean exists = userRepository.existsById(id);
        given(exists).willReturn(false);
        assertThatThrownBy(() -> underTest.deleteUser(id))
                .isInstanceOf(IllegalStateException.class)
                        .hasMessage("User with id " + id + " does not exist");
       userRepository.deleteById(id);
    }
}