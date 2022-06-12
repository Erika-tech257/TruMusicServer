package com.example.MusicApp.services;

import com.example.MusicApp.exceptions.UserInfoNotFoundException;
import com.example.MusicApp.models.User;
import com.example.MusicApp.models.UserInfo;
import com.example.MusicApp.repositories.UserInfoRepository;
import com.example.MusicApp.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;



@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService{

    Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    private final UserInfoService userInfoService;
    private final UserInfoRepository userInfoRepository;
    private final UserRepository userRepository;

    //TODO:The dependencies of some of the beans in the application context form a cycle: used @Lazy to resolve issue temporarily
    @Autowired
    public UserInfoServiceImpl(@Lazy UserInfoService userInfoService, UserInfoRepository userInfoRepository, UserRepository userRepository) {
        this.userInfoService = userInfoService;
        this.userInfoRepository = userInfoRepository;
        this.userRepository = userRepository;
    }

    @Override
    public UserInfo saveUserInfo(UserInfo userInfo) {
        logger.info("UserInfo saved {}", userInfo);
        return userInfoRepository.save(userInfo);
    }

    @Override
    public UserInfo getUserInfoById(Integer userinfo_id) {
        logger.info("Getting UserInfo by Id {}", userinfo_id);
        return userInfoRepository.getById(userinfo_id);
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

    @Override
    public User getUserByUserInfo(UserInfo userInfo){
        User user = null;
        try {
            user = userInfoRepository.findUserInfoByUser(userInfo);
            logger.info("This user is associated with this userinfo {}", userInfo);
        }catch (UserInfoNotFoundException e){
            throw new UserInfoNotFoundException(e.getMessage());
        }
        return user;
    }
}
