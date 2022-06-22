package com.example.MusicApp.services.impl;

import com.example.MusicApp.models.UserInfo;
import com.example.MusicApp.repositories.UserInfoRepository;
import com.example.MusicApp.services.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    private final UserInfoService userInfoService;
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
    public Optional<UserInfo> getUserInfoById(Integer userinfo_id) {
        logger.info("Getting UserInfo by Id {}", userinfo_id);
        return userInfoRepository.findById(userinfo_id);
    }

    @Override
    public void deleteUserInfo(UserInfo userInfo) {
        logger.info("Deleting this user's info {}", userInfo);
        userInfoRepository.delete(userInfo);
    }

    @Override
    public List<UserInfo> listOfUserInfos() {
        logger.info("List of User's info");
        return userInfoRepository.findAll();
    }
}
