package com.example.myrh_app.DTO;

import com.example.myrh_app.Entities.ChercheurEmploiEntite;
import com.example.myrh_app.Entities.OffreEmploiEntite;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostulationDTO {
    private OffreEmploiDTO offre;
    private ChercheurEmploiDTO chercheur;
}
