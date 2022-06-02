package com.example.MusicApp.controllers;

import com.example.MusicApp.models.PlayList;
import com.example.MusicApp.services.PlaylistService;
import com.example.MusicApp.services.PlaylistServiceImpl;
import com.example.MusicApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.MediaType.*;

import java.util.List;

@RestController
@RequestMapping("/TruMusic")
public class PlaylistController {

    private final PlaylistService playlistService;
    @Autowired
    private final PlaylistServiceImpl playlistImpl;

    public PlaylistController(PlaylistService playlistService, UserService userService, PlaylistServiceImpl playlistImpl) {
        this.playlistService = playlistService;
        this.playlistImpl = playlistImpl;
    }

    @PostMapping(path = "/playlist/save", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<PlayList> savePlaylist(@RequestBody PlayList playList) {
        return new ResponseEntity<>(playlistService.savePlaylist(playList), HttpStatus.CREATED);
    }

//    @PostMapping(path = "/playlist/addPlayToUser")
//    @ResponseStatus(value = HttpStatus.CREATED)
//    public ResponseEntity<PlayList> addPlayListToUser(@RequestBody PlaylistToUser playlistToUser){
//        playlistService.addPlaylistToUser(playlistToUser.getTitle(), playlistToUser.getId());
//        return ResponseEntity.ok().build();
//    }

    @GetMapping(path = "/playlist/{title}", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<PlayList> getPlayList(@PathVariable("title") String title) {
        return new ResponseEntity<>(playlistService.getPlayList(title), HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/playlists", produces = APPLICATION_JSON_VALUE)
    public List<PlayList> getAllPlaylists() {
        return playlistService.getAllPlaylists();
    }

}

//    @Getter
//    @Setter
//    @AllArgsConstructor
//    @NoArgsConstructor
//    class PlaylistToUser {
//        private String title;
//        private Integer id;
//    }



