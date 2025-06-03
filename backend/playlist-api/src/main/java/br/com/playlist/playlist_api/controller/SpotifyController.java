package br.com.playlist.playlist_api.controller;

import br.com.playlist.playlist_api.service.SpotifyAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/spotify")
public class SpotifyController {

    @Autowired
    private SpotifyAuthService spotifyAuthService;

    @GetMapping("/genres")
    public ResponseEntity<String> getGenres() {
        String token = spotifyAuthService.getAccessToken();
        String url = "https://api.spotify.com/v1/recommendations/available-genre-seeds";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<Void> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);

        return ResponseEntity.ok(response.getBody());
    }
}