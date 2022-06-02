package com.example.MusicApp.services;

import com.example.MusicApp.models.UserInfo;

public interface UserInfoService {
    UserInfo saveUserInfo(UserInfo userInfo);
    void addUserInfoToUser(UserInfo userInfo);
}
