import { Component, OnInit } from '@angular/core';
import { AgentService } from './agent.service';

@Component({
  selector: 'app-agent',
  templateUrl: './agent.component.html',
  styleUrls: ['./agent.component.css']
})
export class AgentComponent implements OnInit {
  offresEnAttente: any[] = [];

  constructor(private offreEmploiService: AgentService) {}

  ngOnInit() {
    this.getOffresEnAttente();
  }

  getOffresEnAttente() {
    this.offreEmploiService.getEnAttenteOffres().subscribe((data) => {
      this.offresEnAttente = data;
    });
  }

  accepterOffre(offreId: number) {
    this.offreEmploiService.accepterOffre(offreId).subscribe(() => {
      this.getOffresEnAttente();
    });
  }

  refuserOffre(offreId: number) {
    this.offreEmploiService.refuserOffre(offreId).subscribe(() => {
      this.getOffresEnAttente();
    });
  }
}

