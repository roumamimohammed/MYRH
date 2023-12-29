import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SocieteService {
  private apiUrl = 'http://localhost:8080/api/Societe';

  constructor(private http: HttpClient) {}

  createSociete(societeData: any): Observable<any> {
    const url = `${this.apiUrl}/creer`;
    return this.http.post(url, societeData);
  }

}
