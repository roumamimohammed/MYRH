import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http'; // Importez HttpClientModule

import { AppComponent } from './app.component';
import { OffreEmploiComponent } from './offre-emploi/offre-emploi.component';
import {FormsModule} from "@angular/forms";
import { SocieteComponent } from './societe/societe.component';
import { CreateOffreComponent } from './create-offre/create-offre.component';
import { LoginComponent } from './login/login.component';
import { AgentComponent } from './agent/agent.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { EmailComponent } from './email/email.component';

@NgModule({
    declarations: [
        AppComponent,
        OffreEmploiComponent,
        SocieteComponent,
        CreateOffreComponent,
        LoginComponent,
        AgentComponent,
        EmailComponent
    ],
    imports: [
      NgxPaginationModule,
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }
