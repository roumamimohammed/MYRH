import { Component } from '@angular/core';
import { SocieteService } from './societe.service';

@Component({
  selector: 'app-societe',
  templateUrl: 'societe.component.html',
  styleUrls: ['societe.component.css'],
})
export class SocieteComponent {
  societeData: any = {}; // Assurez-vous de lier correctement les champs du formulaire à cet objet

  constructor(private societeService: SocieteService) {}

  submitInscription(): void {
    this.societeService.createSociete(this.societeData).subscribe(
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
