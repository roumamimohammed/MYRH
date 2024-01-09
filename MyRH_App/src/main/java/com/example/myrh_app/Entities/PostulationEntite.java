package com.example.myrh_app.Entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostulationEntite {
    @EmbeddedId
    private PostulationId id;
    @MapsId("offreId")
    @JoinColumn(name = "offre_id")
    @ManyToOne
    private OffreEmploiEntite offre;

    @MapsId("chercheurId")
    @JoinColumn(name = "chercheur_id")
    @ManyToOne
    private ChercheurEmploiEntite chercheur;
}








