package br.com.playlist.playlist_api.repository;

import br.com.playlist.playlist_api.model.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancionRepository extends JpaRepository<Cancion, Long> {}