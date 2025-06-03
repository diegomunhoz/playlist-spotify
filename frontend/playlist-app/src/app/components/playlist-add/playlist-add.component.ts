import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PlaylistService } from '../../services/playlist.service';

@Component({
  selector: 'app-playlist-add',
  templateUrl: './playlist-add.component.html'
})
export class PlaylistAddComponent {
  nombre = '';
  descripcion = '';
  token: string = '';

  constructor(private playlistService: PlaylistService, private router: Router) {}

  add() {
    this.token = localStorage.getItem('jwt') || '';
    this.playlistService.addPlaylist(
      { nombre: this.nombre, descripcion: this.descripcion, canciones: [] },
      this.token
    ).subscribe(() => {
      this.router.navigate(['/playlists']);
    });
  }
}