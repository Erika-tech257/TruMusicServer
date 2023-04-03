package com.example.MusicApp.controllers;

import com.example.MusicApp.models.Artist;
import com.example.MusicApp.services.ArtistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/TruMusic")
public class ArtistController {

    Logger logger = LoggerFactory.getLogger(ArtistController.class);
    private final ArtistService artistService;

    /**
     * Return artist that user searches for
     * @param id
     * @return
     */

    @GetMapping("/artist/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public Artist getArtist(@PathVariable("id") Integer id) {
        return artistService.getArtistById(id);
    }
}