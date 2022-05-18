package com.example.MusicApp.services;

import com.example.MusicApp.models.PlayList;
import com.example.MusicApp.repositories.PlaylistRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;

    @Autowired
    public PlaylistServiceImpl(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public PlayList savePlaylist(PlayList playList) {
        log.info("Saving {} playlist to the DB", playList.getUser());
        return playlistRepository.save(playList);
    }

    @Override
    public PlayList getPlayList(String title) {
        log.info("Get {} playlist", title);
        return playlistRepository.findByTitle(title);
    }

    @Override
    public List<PlayList> getAllPlaylists() {
        log.info("Get all playlists");
        return playlistRepository.findAll();
    }
}
