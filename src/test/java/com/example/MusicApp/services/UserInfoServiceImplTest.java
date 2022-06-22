package com.example.MusicApp.services;

import com.example.MusicApp.models.UserInfo;
import com.example.MusicApp.repositories.UserInfoRepository;
import com.example.MusicApp.services.impl.UserInfoServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserInfoServiceImplTest {

    @Mock
    private UserInfoRepository userInfoRepository;
    private UserInfoService userInfoService;
    private UserInfoServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new UserInfoServiceImpl(userInfoService, userInfoRepository);
    }

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
        //when
        underTest.saveUserInfo(userInfo);
        //then
        verify(userInfoRepository).save(userInfo);
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

    @Test
    void itShouldGetAListOfUserInfos() {
        underTest.listOfUserInfos();
        verify(userInfoRepository).findAll();
    }
}

