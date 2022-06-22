package com.example.MusicApp.controllers;

import com.example.MusicApp.models.UserInfo;
import com.example.MusicApp.services.UserInfoService;
import com.example.MusicApp.services.impl.UserInfoServiceImpl;
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


    @Autowired
    public UserInfoController(UserInfoService userInfoService, UserInfoServiceImpl userInfoServiceImpl) {
        this.userInfoService = userInfoService;
        this.userInfoServiceImpl = userInfoServiceImpl;
    }

    @PostMapping(path = "userInfo/save", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<UserInfo> saveUserInfo(@RequestBody UserInfo userInfo) {
        return new ResponseEntity<>(userInfoService.saveUserInfo(userInfo), HttpStatus.CREATED);
    }

    @GetMapping(path = "/userInfo/{userInfoId}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Optional<UserInfo> getUserInfoById(@PathVariable("userInfoId") Integer userInfoId) {
            return userInfoService.getUserInfoById(userInfoId);
    }


}
