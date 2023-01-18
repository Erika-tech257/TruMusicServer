package com.example.MusicApp.repositories;

import com.example.MusicApp.dto.UserInfoDto;
import com.example.MusicApp.models.User;
import com.example.MusicApp.models.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    User findUserInfoByUser(UserInfo userInfo);
    UserInfo findByFirstname(String firstname);

    /**
     * Based on the userInfo id
     * @param user_id
     * @return
     */
    @Query( value = "SELECT * FROM user_info ui WHERE ui.user_user_id = :user_id", nativeQuery = true)
    UserInfo getUserInfoByUserId(@Param("user_id") Integer user_id);

}
