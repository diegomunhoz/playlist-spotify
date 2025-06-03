package br.com.playlist.playlist_api.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class SpotifyService {
    private final RestTemplate restTemplate = new RestTemplate();
    private String token = "SEU_TOKEN_SPOTIFY"; // Substitua pelo token real

    public List<String> getGenres() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Map> response = restTemplate.exchange(
                "https://api.spotify.com/v1/recommendations/available-genre-seeds",
                HttpMethod.GET, entity, Map.class
        );
        return (List<String>) response.getBody().get("genres");
    }
}