package com.example.MusicApp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "Artist")
@Entity
@Builder
@ToString
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}, ignoreUnknown = true)
public class Artist implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ArtistId")
   private Integer id;

   @Column
   private String name;

   @Column(name = "ArtistImg")
   private String artist_img;

   public Artist() {
   }


   public Artist(Integer id, String name) {
      this.id = id;
      this.name = name;
   }

   public Artist(Integer id, String name, String artist_img) {
      this.id = id;
      this.name = name;
      this.artist_img = artist_img;
   }



   //   public Artist(Integer id, String name, String artist_img, List<Album> albums, List<Track> tracks) {
//      this.id = id;
//      this.name = name;
//      this.artist_img = artist_img;
//      this.albums = albums;
//      this.tracks = tracks;
//   }


   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getArtist_img() {
      return artist_img;
   }

   public void setArtist_img(String artist_img) {
      this.artist_img = artist_img;
   }

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
