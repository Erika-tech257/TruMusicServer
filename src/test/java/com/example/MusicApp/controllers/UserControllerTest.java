package com.example.MusicApp.controllers;

import com.example.MusicApp.models.User;
import com.example.MusicApp.services.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    private UserServiceImpl userService;



    @Test
    void itShouldSaveUser() {
        User us =
                User.builder()
                        .id(1)
                        .email("test@email.com")
                        .username("Lucky")
                        .password("Password1@")
                        .build();
        when(userService.saveUser(us)).thenReturn(us);
        userController.saveUser(us);
        Assertions.assertNotNull(us);
        Assertions.assertEquals(HttpStatus.CREATED, HttpStatus.CREATED);
    }
}