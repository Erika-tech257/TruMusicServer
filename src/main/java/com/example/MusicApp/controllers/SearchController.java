package com.example.MusicApp.controllers;

import com.example.MusicApp.deezerapi.SearchDeezer;
import com.example.MusicApp.dto.SearchDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/TruMusic")
public class SearchController {

    Logger logger = LoggerFactory.getLogger(SearchController.class);
    private final SearchDeezer searchDeezer;

    @GetMapping("/search/{q}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public SearchDto getArtistInfo(@PathVariable("q") String q) throws IOException {
        return searchDeezer.searchArtistByName(q);
    }

}
