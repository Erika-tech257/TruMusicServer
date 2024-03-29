package com.example.MusicApp.services;

import com.example.MusicApp.models.User;
import com.example.MusicApp.models.UserInfo;

import java.util.List;
import java.util.Optional;

public interface UserInfoService {
    UserInfo saveUserInfo(UserInfo userInfo);
    Optional <UserInfo> getUserInfoById(Integer userinfo_id);
    void deleteUserInfo(UserInfo userInfo);
    void addUserInfoToUser(String firstname, Integer id);
//    List<UserInfo> getAllUserInfo();
}
