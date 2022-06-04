package com.example.MusicApp.services;


import com.example.MusicApp.models.UserInfo;
import com.example.MusicApp.repositories.UserInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService{

    Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    private UserInfoService userInfoService;
    private final UserInfoRepository userInfoRepository;

    //TODO:The dependencies of some of the beans in the application context form a cycle: used @Lazy to resolve issue temporarily
    @Autowired
    public UserInfoServiceImpl(@Lazy UserInfoService userInfoService, UserInfoRepository userInfoRepository) {
        this.userInfoService = userInfoService;
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public UserInfo saveUserInfo(UserInfo userInfo) {
        logger.info("UserInfo saved {}", userInfo);
        return userInfoRepository.save(userInfo);
    }

    @Override
    public void addUserInfoToUser(UserInfo userInfo) {


    }
}
