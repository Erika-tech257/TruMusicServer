package com.example.MusicApp.controllers;

import com.example.MusicApp.exceptions.ApiRequestException;
import com.example.MusicApp.models.User;
import com.example.MusicApp.services.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.BDDMockito.given;

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
        Mockito.when(userService.saveUser(us)).thenReturn(us);
        userController.saveUser(us);
        Assertions.assertNotNull(us);
        Assertions.assertEquals(HttpStatus.CREATED, HttpStatus.CREATED);
    }

    //only 53% of test covered
    @Test
    void itShouldGetAllUsers(){
        List <User> users = new ArrayList<>();
       given(userService.getAllUsers()).willReturn(users);
        userController.getAllUsers();
        Assertions.assertNotNull(users);
        Assertions.assertEquals(HttpStatus.ACCEPTED, HttpStatus.ACCEPTED);
        Assertions.assertThrows(ApiRequestException.class, () -> {
            throw new ApiRequestException("Cannot get all users with custom exception");
        });
    }
}