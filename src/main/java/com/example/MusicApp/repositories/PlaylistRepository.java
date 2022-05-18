package com.example.MusicApp.repositories;

import com.example.MusicApp.models.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<PlayList, Integer> {

    PlayList findByTitle(String title);
}
