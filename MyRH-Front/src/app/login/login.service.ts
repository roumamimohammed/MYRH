import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private apiUrl = 'http://localhost:8080/api/Societe';

  constructor(private http: HttpClient) {}

  loginSociete(loginRequest: any): Observable<any> {
    const url = `${this.apiUrl}/login`;
    return this.http.post(url, loginRequest);
  }
}
