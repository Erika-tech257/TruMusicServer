package com.example.MusicApp.services;

import com.example.MusicApp.models.Role;
import com.example.MusicApp.models.User;
import com.example.MusicApp.repositories.RoleRepository;
import com.example.MusicApp.repositories.UserInfoRepository;
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
    void ShouldSaveRole() {
        Role role = new Role(1, "User");
        underTest.saveRole(role);
        verify(roleRepository).save(role);
    }

    //TODO: Executes but throws a GETTING NULLPOINTEREXCEPTION
//    @Test
//    void shouldAddRoleToUser() {
//        String username = "Lucky";
//        Integer roleId = 2;
//       underTest.addRoleToUser(username, roleId);
//        User user = verify(userRepository).findByUsername(username);
//        Role role = verify(roleRepository).findByRoleId(roleId);
//        assertThat(user.getRoles().add(role)).isNotEqualTo();
//    }

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


    //TODO://FIND OUT HOW TO RUN TEST WITH IF STATEMENT
//    @Test
//    void deleteUser() {
//        int id = 1;
//        underTest.deleteUser(userRepository.getById());
//        verify(userRepository).deleteById(id);
//    }
}