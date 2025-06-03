import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent {
  username = '';
  password = '';
  error = '';

  constructor(private authService: AuthService, private router: Router) {}

  login() {
    this.authService.login(this.username, this.password).subscribe({
      next: (token) => {
        localStorage.setItem('jwt', token);
        this.router.navigate(['/playlists']);
      },
      error: () => {
        this.error = 'Login inválido';
      }
    });
  }
}