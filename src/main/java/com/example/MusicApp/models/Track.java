package com.example.MusicApp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Tracks")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}, ignoreUnknown = true)
public class Track {

    public Track() {
    }

    public Track(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Track(Integer id, String title, Album album, Artist artist) {
        this.id = id;
        this.title = title;
        this.album = album;
        this.artist = artist;
    }

    @Id
    @Column(name = "Track_Id")
    private Integer id;

    @Column
    private String title;

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

    //many tracks to one album
    @ManyToOne
   Album album;

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    //many tracks to one artist
    @ManyToOne
    Artist artist;

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", album=" + album +
                ", artist=" + artist +
                '}';
    }
}
