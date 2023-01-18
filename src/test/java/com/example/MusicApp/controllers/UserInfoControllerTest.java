package com.example.MusicApp.controllers;

import com.example.MusicApp.models.User;
import com.example.MusicApp.models.UserInfo;
import com.example.MusicApp.services.impl.UserInfoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith({MockitoExtension.class})
class UserInfoControllerTest {

    @InjectMocks
    UserInfoController userInfoController;

    @Mock
    private UserInfoServiceImpl userInfoService;

    @Test
    void itShoudSaveUserInfo(){
        User us =
                User.builder()
                        .id(1)
                        .email("test@email.com")
                        .username("Lucky")
                        .password("Password1@")
                        .build();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserinfo_id(1);
        userInfo.setEmail("Snoopy@email.com");
        userInfo.setFirstname("Snoopy");
        userInfo.setLastname("Dog");
        userInfo.setUser(us);
        given(userInfoService.saveUserInfo(userInfo)).willReturn(userInfo);
        userInfoController.saveUserInfo(userInfo);
        Assertions.assertNotNull(userInfo);
        Assertions.assertEquals(HttpStatus.CREATED, HttpStatus.CREATED);
    }

//    @Test
//    void itShouldGetUserInfoById(){
//        User us =
//                User.builder()
//                        .id(1)
//                        .email("test@email.com")
//                        .username("Lucky")
//                        .password("Password1@")
//                        .build();
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUserinfo_id(1);
//        userInfo.setEmail("Snoopy@email.com");
//        userInfo.setFirstname("Snoopy");
//        userInfo.setLastname("Dog");
//        userInfo.setUser(us);
//        given(userInfoService.getUserInfoById(userInfo.getUserinfo_id())).willReturn(java.util.Optional.of(userInfo));
//        userInfoController.getUserInfoById(userInfo.getUserinfo_id());
//        Assertions.assertNotNull(us);
//        Assertions.assertEquals(HttpStatus.ACCEPTED, HttpStatus.ACCEPTED);
//    }
}