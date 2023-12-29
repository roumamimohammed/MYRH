import { Component, OnInit } from '@angular/core';
import { OffreEmploiService } from './offre-emploi.service';
import { NgxPaginationModule } from 'ngx-pagination';

@Component({
  selector: 'app-offre-emploi',
  templateUrl: 'offre-emploi.component.html',
  styleUrls: ['offre-emploi.component.css'],
})
export class OffreEmploiComponent implements OnInit {
  offres: any[] = [];
  searchTitle: string = '';
  offreData: any = {};
  itemsPerPage: number = 10; // Number of items per page
  currentPage: number = 1; // Current page
  totalItems: number = 0; // Total number of items

  constructor(private offreEmploiService: OffreEmploiService) {}

  ngOnInit(): void {
    this.loadOffres();
  }

  loadOffres(): void {
    this.offreEmploiService.getAllOffres().subscribe(
      (data: any) => {
        this.totalItems = data.length;
        this.offres = data;
      },
      (error: any) => {
        console.error('Error fetching offres:', error);
      }
    );
  }

  searchByTitle(): void {
    if (this.searchTitle.trim() !== '') {
      this.offreEmploiService.searchOffresByTitre(this.searchTitle).subscribe(
        (data: any) => {
          this.totalItems = data.length;
          this.offres = data;
        },
        (error: any) => {
          console.error('Error searching offres:', error);
        }
      );
    } else {
      // If the search field is empty, reload all offres
      this.loadOffres();
    }
  }



  pageChanged(event: any): void {
    this.currentPage = event;
  }

  postuler(offreId: number, chercheurId: number): void {
        this.offreEmploiService.postuler(offreId, chercheurId).subscribe(
            () => {
                console.log('Postulation successful');
            },
            (error: any) => {
                console.error('Error during postulation:', error);
            }
        );}
    submitIncreation(): void {
        this.offreEmploiService.createOffre(this.offreData).subscribe(
            () => {
                console.log('Inscription successful');
                // Ajoutez ici le code pour gérer la réponse après l'inscription
            },
            (error: any) => {
                console.error('Error during inscription:', error);
                // Ajoutez ici le code pour gérer les erreurs d'inscription
            }
        );
    }
}
