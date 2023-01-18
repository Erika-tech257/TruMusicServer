package com.example.MusicApp.services;

import com.example.MusicApp.exceptions.UserInfoNotFoundException;
import com.example.MusicApp.models.UserInfo;
import com.example.MusicApp.repositories.UserInfoRepository;
import com.example.MusicApp.repositories.UserRepository;
import com.example.MusicApp.services.impl.UserInfoServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserInfoServiceImplTest {

    @Mock
    private UserInfoRepository userInfoRepository;

    @Mock
    private UserInfoService userInfoService;

    private UserInfoServiceImpl underTest;

    @Mock
    private UserRepository userRepository;

//    @BeforeEach
//    void setUp() {
//        underTest = new UserInfoServiceImpl(userInfoService, userInfoRepository, userRepository);
////        mock(System.class);
//    }

    @AfterEach
    void tearDown() {
        userInfoRepository.deleteAll();
    }


    @Test
    void itShouldSaveUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserinfo_id(1);
        userInfo.setFirstname("Bart");
        userInfo.setLastname("Simpson");
        userInfo.setEmail("ElBarto@email.com");

        Timestamp updatedTime = new Timestamp(System.currentTimeMillis());
        userInfo.setLastUpdate(updatedTime);

        //when
        underTest.saveUserInfo(userInfo);
        //then
        verify(userInfoRepository).save(userInfo);
    }


    @Test
    void testUserInfoIsNull() {
        UserInfo userInfo = null;
        assertThatThrownBy(() -> underTest.saveUserInfo(userInfo))
                .isInstanceOf(UserInfoNotFoundException.class)
                .hasMessage("UserInfo not associated with this User");
    }

    @Test
    void itShouldGetUserInfoById() {
        int userinfo_id = 4;
        underTest.getUserInfoById(userinfo_id);
        verify(userInfoRepository).findById(userinfo_id);
    }

    @Test
    void itShouldDeleteUserInfo() {
        UserInfo userInfo = new UserInfo();
        underTest.deleteUserInfo(userInfo);
        verify(userInfoRepository).delete(userInfo);
    }
//
//    @Test
//    void itShouldGetAListOfUserInfo() {
//        underTest.getAllUserInfo();
//        verify(userInfoRepository).findAll();
//    }
}

