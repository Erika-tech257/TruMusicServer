package com.example.MusicApp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest {

    private String username;
    private String password;


}
