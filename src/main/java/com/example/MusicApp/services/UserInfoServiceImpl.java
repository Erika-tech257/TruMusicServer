package com.example.MusicApp.services;


import com.example.MusicApp.models.UserInfo;
import com.example.MusicApp.repositories.UserInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService{

    Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    private final UserInfoService userInfoService;
    private final UserInfoRepository userInfoRepository;

    @Autowired
    public UserInfoServiceImpl(UserInfoService userInfoService, UserInfoRepository userInfoRepository) {
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
