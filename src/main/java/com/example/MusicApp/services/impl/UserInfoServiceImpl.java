package com.example.MusicApp.services.impl;

import com.example.MusicApp.dto.UserInfoDto;
import com.example.MusicApp.exceptions.UserInfoNotFoundException;
import com.example.MusicApp.models.User;
import com.example.MusicApp.models.UserInfo;
import com.example.MusicApp.repositories.UserInfoRepository;
import com.example.MusicApp.repositories.UserRepository;
import com.example.MusicApp.services.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Optional;


@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    private final UserInfoService userInfoService;
    private final UserInfoRepository userInfoRepository;
    private final UserRepository userRepository;


    //TODO:The dependencies of some of the beans in the application context form a cycle: used @Lazy to resolve issue temporarily
    @Autowired
    public UserInfoServiceImpl(@Lazy UserInfoService userInfoService, UserInfoRepository userInfoRepository, UserRepository userRepository, UserRepository userRepository1) {
        this.userInfoService = userInfoService;
        this.userInfoRepository = userInfoRepository;
        this.userRepository = userRepository;
    }

    @Override
    public UserInfo saveUserInfo(UserInfo userInfo) {
        logger.info("UserInfo saved {}", userInfo);
        if (Objects.isNull(userInfo)) {
            throw new UserInfoNotFoundException();
        }
        if (Objects.nonNull(userInfo.getLastUpdate())) {
            Timestamp updatedTime = new Timestamp(System.currentTimeMillis());
            userInfo.setLastUpdate(updatedTime);
        }
        return userInfoRepository.save(userInfo);
    }

    @Override
    public Optional <UserInfo> getUserInfoById(Integer userinfo_id) {
        logger.info("Getting UserInfo by Id {}", userinfo_id);
         return userInfoRepository.findById(userinfo_id);
    }

    @Override
    public void deleteUserInfo(UserInfo userInfo) {
        logger.info("Deleting this user's info {}", userInfo);
        userInfoRepository.delete(userInfo);
    }

    @Override
    public void addUserInfoToUser(String firstname, Integer id) {
        logger.info("Adding userInfo {} to user {}", firstname, id);
        UserInfo userInfo = userInfoRepository.findByFirstname(firstname);
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            userInfo.setUser(user.orElse(null));
        } else{
            throw new UserInfoNotFoundException("UserInfo not found");
        }

    }

    public Optional <UserInfoDto> getUserInfoByUserId(Integer user_id) {
        return userInfoRepository.findById(user_id)
                .stream().map(this::convertToDto)
                .findFirst();

    }
    /**
     * Conversion for UserInfo entity to UserInfoDto
     * @param userInfo
     * @return
     */
    private UserInfoDto convertToDto (UserInfo userInfo){
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setFirstname(userInfo.getFirstname());
        userInfoDto.setLastname(userInfo.getLastname());
        userInfoDto.setEmail(userInfo.getEmail());
        Timestamp stamp = new Timestamp(System.currentTimeMillis());
        userInfoDto.setLastUpdate(stamp);
        return userInfoDto;
    }



}