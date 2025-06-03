import { Component, OnInit } from '@angular/core';
import { PlaylistService } from '../../services/playlist.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-playlist-list',
  templateUrl: './playlist-list.component.html'
})
export class PlaylistListComponent implements OnInit {
  playlists: any[] = [];
  token: string = '';

  constructor(private playlistService: PlaylistService, private router: Router) {}

  ngOnInit() {
    this.token = localStorage.getItem('jwt') || '';
    this.playlistService.getPlaylists(this.token).subscribe(data => {
      this.playlists = data;
    });
  }

  viewDetail(nombre: string) {
    this.router.navigate(['/playlists', nombre]);
  }

  addPlaylist() {
    this.router.navigate(['/add']);
  }
}