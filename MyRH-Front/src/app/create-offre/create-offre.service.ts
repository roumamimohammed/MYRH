import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CreateOffreService {
  private apiUrl = 'http://localhost:8080/api/offres-emploi';
  private apiUrl1 = 'http://localhost:8080/api/Societe';
  constructor(private http: HttpClient) {}
  createOffre(OffreData: any): Observable<any> {
    const url = `${this.apiUrl}/creer`;
    return this.http.post(url, OffreData);
  }
  getSocieteById(id: number): Observable<any> {
    const url = `${this.apiUrl1}/${id}`;
    return this.http.get(url);
  }
}
