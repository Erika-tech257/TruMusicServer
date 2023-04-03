package com.example.MusicApp.dto;

import lombok.Data;

@Data
public class DataDto {
    private String title;
    private String preview;
    private Object artist;
    private Object album;
    private String type;
}
