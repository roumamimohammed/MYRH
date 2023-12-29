// app-routing.module.ts
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OffreEmploiComponent } from './offre-emploi/offre-emploi.component';
import { SocieteComponent } from './societe/societe.component';
import { CreateOffreComponent } from './create-offre/create-offre.component';
import { LoginComponent } from './login/login.component';
import { AgentComponent } from "./agent/agent.component";
import { EmailComponent } from "./email/email.component";

const routes: Routes = [
  { path: 'offres', component: OffreEmploiComponent },
  { path: 'inscription-societe', component: SocieteComponent },
  { path: 'create-offre', component: CreateOffreComponent },
  { path: 'login', component: LoginComponent },
  { path: 'create-offre/:id', component: CreateOffreComponent }, // Définissez-le une seule fois ici
  { path: 'agent', component: AgentComponent },
  { path: '', redirectTo: '/offres', pathMatch: 'full' },
  { path: 'email', component: EmailComponent },
  // Redirection par défaut vers la page d'offres
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
