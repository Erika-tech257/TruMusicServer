package com.example.MusicApp.controllers;

import com.example.MusicApp.mapper.CustomMapper;
import com.example.MusicApp.models.UserInfo;
import com.example.MusicApp.dto.UserInfoDto;
import com.example.MusicApp.repositories.UserInfoRepository;
import com.example.MusicApp.services.UserInfoService;
import com.example.MusicApp.services.impl.UserInfoServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("/TruMusic")
public class UserInfoController {

    private final UserInfoService userInfoService;
    private final UserInfoServiceImpl userInfoServiceImpl;
    private final CustomMapper customMapper;
    private final UserInfoRepository userInfoRepository;

    @Autowired
    public UserInfoController(UserInfoService userInfoService, UserInfoServiceImpl userInfoServiceImpl, CustomMapper customMapper,
                              UserInfoRepository userInfoRepository) {
        this.userInfoService = userInfoService;
        this.userInfoServiceImpl = userInfoServiceImpl;
        this.customMapper = customMapper;
        this.userInfoRepository = userInfoRepository;
    }

    @PostMapping(path = "userInfo/save", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<UserInfo> saveUserInfo(@RequestBody UserInfo userInfo) {
        return new ResponseEntity<>(userInfoService.saveUserInfo(userInfo), HttpStatus.CREATED);
    }

    @GetMapping(path = "userInfo/{userId}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public Optional <UserInfoDto> getUserInfo(@PathVariable("userId") Integer user_id) {
        return userInfoServiceImpl.getUserInfoByUserId(user_id);
    }

    @PostMapping(path = "/userInfo/addToUser", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<UserInfo> addUserInfoToUser(@RequestBody UserInfoToUser userInfoToUser) {
        userInfoService.addUserInfoToUser(userInfoToUser.getFirstname(), userInfoToUser.getId());
        return ResponseEntity.ok().build();
    }
}
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    class UserInfoToUser {
        private String firstname;
        private Integer id;
    }
