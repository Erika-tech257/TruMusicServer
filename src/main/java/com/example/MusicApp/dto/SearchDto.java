package com.example.MusicApp.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;


@Data
public class SearchDto{
    private Collection<DataDto> data = new ArrayList<>();

    //
//    public List<DataDto> returnData(){
//        for (int i = 0; i <data.size(); i++) {
//            data
//        }
//    }
}
