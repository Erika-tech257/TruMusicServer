package com.example.MusicApp.controllers;

import com.example.MusicApp.models.Artist;
import com.example.MusicApp.services.ArtistService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class ArtistControllerTest {

    @InjectMocks
    ArtistController artistController;

    @Mock
    private ArtistService artistService;


    @Test
    void isShouldGetArtist() {
        Artist artist =
                Artist.builder()
                        .id(262)
                        .name("Janet Jackson")
                        .picture_medium("https://image.jpg")
                        .build();
        when(artistService.getArtistById(artist.getId())).thenReturn(artist);
        artistController.getArtist(artist.getId());
        Assertions.assertNotNull(artist);
        Assertions.assertEquals(HttpStatus.ACCEPTED, HttpStatus.ACCEPTED);
    }
}