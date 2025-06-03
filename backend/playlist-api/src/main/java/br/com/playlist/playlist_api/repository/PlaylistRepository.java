package br.com.playlist.playlist_api.repository;

import br.com.playlist.playlist_api.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, String> {}