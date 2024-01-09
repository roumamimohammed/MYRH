package com.example.myrh_app.DTO;

import com.example.myrh_app.Entities.SocieteEntite;
import com.example.myrh_app.Enum.Status;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OffreEmploiDTO {
    private int id;

    private String titre;
    private String description;
    private String profilRecherche;
    private String ville;
    private String niveauEtude;
    private Double salaire;
    private Status statut;
    private SocieteDTO societe;

}
