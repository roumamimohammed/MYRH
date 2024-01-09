import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class OffreEmploiService {
  private apiUrl = 'http://localhost:8080/api/offres-emploi'; // Utilisez la même URL pour la liste complète et la recherche

  constructor(private http: HttpClient) {}

  getAllOffres(): Observable<any> {
    return this.http.get(this.apiUrl);
  }

  searchOffresByTitre(titre: string): Observable<any> {
    const url = `${this.apiUrl}/recherche?titre=${titre}`;
    return this.http.get(url);
  }
  postuler(offreId: number, chercheurId: number): Observable<any> {
    const url = `http://localhost:8080/api/postulations/add`;
    const postulationDTO = { offre: { id: offreId }, chercheur: { id: chercheurId } };
    return this.http.post(url, postulationDTO);
  }

  createOffre(OffreData: any): Observable<any> {
    const url = `${this.apiUrl}/creer`;
    return this.http.post(url, OffreData);
  }
}
