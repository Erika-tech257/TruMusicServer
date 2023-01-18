package com.example.MusicApp.repositories;

import com.example.MusicApp.models.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Integer> {
}
