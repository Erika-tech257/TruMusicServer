package com.example.MusicApp.mapper;

import com.example.MusicApp.models.Role;
import com.example.MusicApp.models.User;
import com.example.MusicApp.models.UserInfo;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface CustomMapper {

    @Insert("insert into role(name) values( #{name} )")
//    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "roleId", before = false, resultType = Integer.class)
    @Options(useGeneratedKeys = true, keyProperty = "roleId")
    void insert(Role role);

//    @Select("select roleId, name from role where roleId = #{roleId}")
//    Role findById(int role);

    @Select("select * from role")
    List<Role> findAll();

    @Select("select * from user")
    List<User> findAllUsers();

//  @Select("SELECT * FROM user_info ui WHERE ui.user_user_id = #{user_id}")
//   List <UserInfo> getUserInfoByUserId();

}
