import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class PlaylistService {
  private apiUrl = 'http://localhost:8080/lists';

  constructor(private http: HttpClient) {}

  getPlaylists(token: string): Observable<any> {
    return this.http.get(this.apiUrl, {
      headers: new HttpHeaders({ Authorization: `Bearer ${token}` })
    });
  }

  addPlaylist(playlist: any, token: string): Observable<any> {
    return this.http.post(this.apiUrl, playlist, {
      headers: new HttpHeaders({ Authorization: `Bearer ${token}` })
    });
  }

  getPlaylist(name: string, token: string): Observable<any> {
    return this.http.get(`${this.apiUrl}/${name}`, {
      headers: new HttpHeaders({ Authorization: `Bearer ${token}` })
    });
  }

  deletePlaylist(name: string, token: string): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${name}`, {
      headers: new HttpHeaders({ Authorization: `Bearer ${token}` })
    });
  }
}