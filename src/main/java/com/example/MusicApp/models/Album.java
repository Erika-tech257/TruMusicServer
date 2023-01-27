package com.example.MusicApp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Album")
@Getter
@Setter
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}, ignoreUnknown = true)
public class Album implements Serializable {

    public Album() {
    }

    public Album(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

//    public Album(Integer id, String title, String releaseDate, String album_img, Artist artist, List<Track> tracks) {
//        this.id = id;
//        this.title = title;
//        this.releaseDate = releaseDate;
//        this.album_img = album_img;
//        this.artist = artist;
//        this.tracks = tracks;
//    }

    @Id
    @Column(name = "AlbumId")
    private Integer id;

    @Column(name = "AlbumTitle")
    private String title;

    @Column(name = "ReleaseDate")
    private String releaseDate;

    @Column(name = "AlbumImg")
    private String album_img;

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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getAlbum_img() {
        return album_img;
    }

    public void setAlbum_img(String album_img) {
        this.album_img = album_img;
    }

//    @ManyToOne
//    @JoinColumn(name = "ArtistId")
//    private Artist artist;
//
//    public Artist getArtist() {
//        return artist;
//    }
//
//    public void setArtist(Artist artist) {
//        this.artist = artist;
//    }
//
//    @OneToMany
//    @JoinColumn(name = "TrackID")
//    private List<Track> tracks;
//
//    public List<Track> getTracks() {
//        return tracks;
//    }
//
//    public void setTracks(List<Track> tracks) {
//        this.tracks = tracks;
//    }
//
//    @Override
//    public String toString() {
//        return "Album{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", releaseDate='" + releaseDate + '\'' +
//                ", album_img='" + album_img + '\'' +
//                ", artist=" + artist +
//                ", tracks=" + tracks +
//                '}';
//    }
}
