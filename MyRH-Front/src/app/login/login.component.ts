import { Component } from '@angular/core';
import {LoginService} from './login.service'
import {Router} from "@angular/router";
import { AuthService } from '../authentification.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginRequest: any = {};

  constructor(private authService: AuthService,private LoginService: LoginService, private router: Router) {}

  ngOnInit(): void {}

  login(): void {
    this.LoginService.loginSociete(this.loginRequest).subscribe(
      (response: any) => {
        console.log('Login successful', response);

        // Naviguer vers la page des détails de la société avec l'ID
        this.router.navigate(['/create-offre', response]); // Assurez-vous que response.id est défini
      },
      (error: any) => {
        console.error('Login failed:', error);
      }
    );
    this.authService.login();
  }
}
