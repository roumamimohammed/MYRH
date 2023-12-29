package com.example.myrh_app.Entities;

import com.example.myrh_app.Enum.Status;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class OffreEmploiEntite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titre;
    private String description;
    private String profilRecherche;
    private String ville;
    private String niveauEtude;
    private Double salaire;
    private Status statut;
    @ManyToMany
    @JoinTable(
            name = "Postulation",
            joinColumns = @JoinColumn(name = "offre_id"),
            inverseJoinColumns = @JoinColumn(name = "chercheur_id")
    )
    private List<ChercheurEmploiEntite> chercheurEmploiEntiteList;
    @ManyToOne
    @JoinColumn(name = "societe_id", nullable = false)
    private SocieteEntite societe;

}

