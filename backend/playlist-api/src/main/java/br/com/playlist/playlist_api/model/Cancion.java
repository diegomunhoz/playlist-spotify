package br.com.playlist.playlist_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Cancion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String artista;
    private String album;
    private String anno;
    private String genero;

}