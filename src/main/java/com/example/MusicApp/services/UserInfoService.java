package com.example.MusicApp.services;

import com.example.MusicApp.models.User;
import com.example.MusicApp.models.UserInfo;

import java.util.List;

public interface UserInfoService {
    UserInfo saveUserInfo(UserInfo userInfo);
    UserInfo getUserInfoById(Integer userinfo_id);
    void deleteUserInfo(UserInfo userInfo);
    List<UserInfo> listOfUserInfos();
    User getUserByUserInfo(UserInfo userInfo);

}
