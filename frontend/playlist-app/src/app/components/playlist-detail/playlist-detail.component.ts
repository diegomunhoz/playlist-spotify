import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PlaylistService } from '../../services/playlist.service';

@Component({
  selector: 'app-playlist-detail',
  templateUrl: './playlist-detail.component.html'
})
export class PlaylistDetailComponent implements OnInit {
  playlist: any;
  token: string = '';

  constructor(
    private route: ActivatedRoute,
    private playlistService: PlaylistService,
    private router: Router
  ) {}

  ngOnInit() {
    this.token = localStorage.getItem('jwt') || '';
    const name = this.route.snapshot.paramMap.get('nombre') || '';
    this.playlistService.getPlaylist(name, this.token).subscribe(data => {
      this.playlist = data;
    });
  }

  deletePlaylist() {
    if (confirm('Deseja remover esta playlist?')) {
      this.playlistService.deletePlaylist(this.playlist.nombre, this.token).subscribe(() => {
        this.router.navigate(['/playlists']);
      });
    }
  }
}