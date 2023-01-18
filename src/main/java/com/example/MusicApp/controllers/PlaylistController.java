package com.example.MusicApp.controllers;

import com.example.MusicApp.models.PlayList;
import com.example.MusicApp.services.PlaylistService;
import com.example.MusicApp.services.impl.PlaylistServiceImpl;
import com.example.MusicApp.services.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.*;

import java.util.List;


@RestController
@RequestMapping("/TruMusic")
public class PlaylistController {

    private final PlaylistService playlistService;
    private final PlaylistServiceImpl playlistImpl;
    private final WebClient createWebClient;

    @Autowired
    public PlaylistController(PlaylistService playlistService, UserService userService, PlaylistServiceImpl playlistImpl, WebClient createWebClient) {
        this.playlistService = playlistService;
        this.playlistImpl = playlistImpl;
        this.createWebClient = createWebClient;
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
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<PlayList> getAllPlaylists() {
        return playlistService.getAllPlaylists();
    }

//
//    @PostMapping(path="/post", consumes= MediaType.APPLICATION_JSON_VALUE,
//            produces=MediaType.APPLICATION_JSON_VALUE)
//    public Mono<PlayList> createPost(@RequestBody PlayList playList) {
//
//        return createWebClient.post()
//                .uri("/posts")
//                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .body(BodyInserters.fromValue(playList))
//                .retrieve()
//                .bodyToMono(PlayList.class);
//    }


}

//    @Getter
//    @Setter
//    @AllArgsConstructor
//    @NoArgsConstructor
//    class PlaylistToUser {
//        private String title;
//        private Integer id;
//    }



