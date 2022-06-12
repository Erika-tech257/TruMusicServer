package com.example.MusicApp.repositories;

import com.example.MusicApp.models.User;
import com.example.MusicApp.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    User findByUserInfo(UserInfo userInfo);
}
