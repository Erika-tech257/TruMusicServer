package com.example.MusicApp.deezerapi;

import com.example.MusicApp.dto.SearchDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Service
public class SearchDeezer {

private final WebClient webClient;
private SearchDto searchDto;
private final ObjectMapper mapper;

    public SearchDto searchArtistByName(String q) throws IOException {


        return webClient
                .get()
                .uri("/search?" + q)
                .header("X-RapidAPI-Key", "7e5a0303c8mshef9b3740265dcdcp13d713jsn012f72621fcc")
                .header( "X-RapidAPI-Host", "deezerdevs-deezer.p.rapidapi.com")
                .retrieve()
                .bodyToMono(SearchDto.class)
                .block();
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
