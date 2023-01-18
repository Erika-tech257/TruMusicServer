package com.example.MusicApp.dto;

import lombok.*;
import java.sql.Timestamp;

@Data
public class UserInfoDto {
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private Timestamp lastUpdate;
}
