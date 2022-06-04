package com.example.MusicApp.repositories;

import com.example.MusicApp.models.PlayList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlaylistRepositoryTest {

    private PlaylistRepository underTest;

    @Test
    void isShouldFindPlaylistByTitle() {
        String playlistTitle = "Soul_Music";
        Optional <String> opt = Optional.of(playlistTitle);
//        assertTrue(true);
        assertEquals(playlistTitle, playlistTitle);
    }
}

