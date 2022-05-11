package com.example.MusicApp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "Artist")
@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}, ignoreUnknown = true)
public class Artist implements Serializable {

   public Artist() {
   }

   public Artist(Integer id, String name) {
      this.id = id;
      this.name = name;
   }

//   public Artist(Integer id, String name, String artist_img, List<Album> albums, List<Track> tracks) {
//      this.id = id;
//      this.name = name;
//      this.artist_img = artist_img;
//      this.albums = albums;
//      this.tracks = tracks;
//   }

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ArtistId")
   private Integer id;

   @Column
   private String name;

   @Column(name = "ArtistImg")
   private String artist_img;

//   @OneToMany(mappedBy = "Artist")
//   @JsonIgnore
//   private List<Album> albums;
//
//   public List<Album> getAlbums() {
//      return albums;
//   }
//
//   public void setAlbums(List<Album> albums) {
//      this.albums = albums;
//   }
//
//   @OneToMany
//   @JsonIgnore
//   private List<Track>tracks;
//
//   public List<Track> getTracks() {
//      return tracks;
//   }
//
//   public void setTracks(List<Track> tracks) {
//      this.tracks = tracks;
//   }

//   @Override
//   public String toString() {
//      return "Artist{" +
//              "id=" + id +
//              ", name='" + name + '\'' +
//              ", artist_img='" + artist_img + '\'' +
//              ", albums=" + albums +
//              ", tracks=" + tracks +
//              '}';
//   }
}
