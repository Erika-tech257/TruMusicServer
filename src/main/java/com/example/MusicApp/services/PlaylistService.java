package com.example.MusicApp.services;

import com.example.MusicApp.models.PlayList;

import java.util.List;
    /*
    All methods used to manage users playlist's and implement these
    methods into Playlist Service
     */

    public interface PlaylistService {
        PlayList savePlaylist(PlayList playList);
        PlayList getPlayList(String title);
        List<PlayList> getAllPlaylists();
    }

