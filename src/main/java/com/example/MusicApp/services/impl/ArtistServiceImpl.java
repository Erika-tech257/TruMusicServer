package com.example.MusicApp.services.impl;

import com.example.MusicApp.models.Artist;
import com.example.MusicApp.repositories.ArtistRepository;
import com.example.MusicApp.services.ArtistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@RequiredArgsConstructor
@Slf4j
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;
    private final WebClient webClient;


    @Override
    public Artist getArtistById(Integer id) {
        return webClient
                .get()
                .uri("/artist/" + id)
                .header("X-RapidAPI-Key", "7e5a0303c8mshef9b3740265dcdcp13d713jsn012f72621fcc")
                .header( "X-RapidAPI-Host", "deezerdevs-deezer.p.rapidapi.com")
                .retrieve()
                .bodyToMono(Artist.class)
                .block();
    }
}
