import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AgentService {
  private apiUrl = 'http://localhost:8080/api/offres-emploi';

  constructor(private http: HttpClient) {}

  getEnAttenteOffres(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/agent`);
  }

  accepterOffre(offreEmploiId: number): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/update-statutA/${offreEmploiId}`, {});
  }

  refuserOffre(offreEmploiId: number): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/update-statutR/${offreEmploiId}`, {});
  }
}
