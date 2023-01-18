package com.example.MusicApp.repositories;

import com.example.MusicApp.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
}
