package com.example.MusicApp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "PlayList")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}, ignoreUnknown = true)
public class PlayList implements Serializable {

    public PlayList() {
    }

    public PlayList(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public PlayList(Integer id, String title, String description, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.user = user;
    }

    public PlayList(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PlaylistID")
    private Integer id;

    @Column(name = "PlaylistName")
    private String title;

    @Column
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //many playlist to one user
    @ManyToOne(cascade = CascadeType.ALL)
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToMany
    List<Track> trackList;

    public List<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Track> tracks) {
        this.trackList = tracks;
    }

    @Override
    public String toString() {
        return "PlayList{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
