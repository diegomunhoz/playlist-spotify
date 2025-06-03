package br.com.playlist.playlist_api.controller;

import br.com.playlist.playlist_api.model.Playlist;
import br.com.playlist.playlist_api.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/lists")
public class PlaylistController {

    @Autowired
    private PlaylistRepository playlistRepo;

    @PostMapping
    public ResponseEntity<?> addPlaylist(@RequestBody Playlist playlist) {
        if (playlist.getNombre() == null || playlist.getNombre().isEmpty())
            return ResponseEntity.badRequest().body("Nome inválido");
        playlistRepo.save(playlist);
        return ResponseEntity.created(URI.create("/lists/" + playlist.getNombre())).body(playlist);
    }

    @GetMapping
    public List<Playlist> getAll() {
        return playlistRepo.findAll();
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<?> getOne(@PathVariable String nombre) {
        return playlistRepo.findById(nombre)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{nombre}")
    public ResponseEntity<?> delete(@PathVariable String nombre) {
        if (!playlistRepo.existsById(nombre))
            return ResponseEntity.notFound().build();
        playlistRepo.deleteById(nombre);
        return ResponseEntity.noContent().build();
    }
}