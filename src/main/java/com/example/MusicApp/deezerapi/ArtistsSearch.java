package com.example.MusicApp.deezerapi;

import com.example.MusicApp.models.Artist;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.util.*;

public class ArtistsSearch {

    /**
     * may want to use a for loop instead
     * @param id
     */

    public void search(String id) {
//        APIClientService.get("https://www.deezer.com/artist/" + id);
        int count;
        Artist artist = new Artist();
        List<Artist> artistList = new ArrayList<>();
        for (int i = 0; i <id.length(); i++) {
//            System.out.println(id[i]);
        }
    }

//    public void artSearch() throws IOException {
//
//        Artist artist = new Artist();
//        artist.setId(1);
//        artist.setName("Beatles");
//        artist.setArtist_img("picture");
//
//        //create object mapper class object
//        ObjectMapper mapper = new ObjectMapper();
//        //to print string in json format
//        mapper.enable(SerializationFeature.INDENT_OUTPUT);
//        //convert object into string
//        String artJson = mapper.writeValueAsString(artist);
//        //print json string
//        System.out.println(artJson);
//
//        //convert json string into artist object
//        Artist art = mapper.readValue(artJson.getBytes(), Artist.class);
//        //print values from art object
//        System.out.println(art.getId());
//        System.out.println(art.getName());
//        System.out.println(art.getArtist_img());
//
//
//    }

}
