package com.example.MusicApp.services;

import com.example.MusicApp.models.UserInfo;
import com.example.MusicApp.repositories.UserInfoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

//initializes all the mocks in this test class
@ExtendWith(MockitoExtension.class)
class UserInfoServiceImplTest {

    @Mock
    private UserInfoRepository userInfoRepository;
    private UserInfoService userInfoService;
    private UserInfoServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new UserInfoServiceImpl(userInfoService,userInfoRepository);
    }

    @Test
    void itShouldSaveUserInfo() {
        UserInfo userInfo = new UserInfo(1,
                "Bart", "Simpson",
                "ElBarto@email.com");
//        userInfo.setUserinfo_id(1);
//        userInfo.setFirstname("Bart");
//        userInfo.setLastname("Simpson");
//        userInfo.setEmail("ElBarto@email.com");
        //when
        underTest.saveUserInfo(userInfo);
        //then
        verify(userInfoRepository).save(userInfo);

        /**
         * Another way to write test case
         */
//        //when
//        underTest.saveUserInfo(userInfo);
//
//        //then
//        ArgumentCaptor<UserInfo> userInfoArgumentCaptor =
//                ArgumentCaptor.forClass(UserInfo.class);
//
//        //verify the repository was verified with save and want to catch the actual info passed
//        verify(userInfoRepository)
//                .save(userInfoArgumentCaptor.capture());
//
//       UserInfo capturedUserInfo = userInfoArgumentCaptor.getValue();
//
//       assertThat(capturedUserInfo).isEqualTo(userInfo);
    }
}
