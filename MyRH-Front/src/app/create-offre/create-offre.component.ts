import { Component, OnInit } from '@angular/core';
import { CreateOffreService } from './create-offre.service';
import {ActivatedRoute} from "@angular/router";
import { AuthService } from '../authentification.service';

@Component({
  selector: 'app-create-offre',
  templateUrl: './create-offre.component.html',
  styleUrls: ['./create-offre.component.css']
})
export class CreateOffreComponent implements OnInit{
  offres: any[] = [];
  searchTitle: string = '';
  offreData: any = {
    societe: {
      id: null,
    },
  };
  societeId!: number;
  societeDetails: any;

  constructor(public authService: AuthService,private offreEmploiService: CreateOffreService,private route: ActivatedRoute,private CreateOffreService:CreateOffreService) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.societeId = +params.get('id')!;
      this.loadSocieteDetails();
    });
  }
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
  loadSocieteDetails(): void {
    this.CreateOffreService.getSocieteById(this.societeId).subscribe(
      (data: any) => {
        this.societeDetails = data;
      },
      (error: any) => {
        console.error('Error fetching societe details:', error);
      }
    );
  }
}
