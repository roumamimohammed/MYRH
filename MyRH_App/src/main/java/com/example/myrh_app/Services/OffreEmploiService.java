package com.example.myrh_app.Services;

import com.example.myrh_app.DTO.OffreEmploiDTO;
import com.example.myrh_app.Entities.OffreEmploiEntite;

import java.util.List;

public interface OffreEmploiService {
 /*   OffreEmploiDTO getOffreEmploiById(int id);
    OffreEmploiDTO updateOffreEmploi(int id, OffreEmploiDTO offreEmploiDTO);
    void deleteOffreEmploi(int id);*/
 List<OffreEmploiDTO> getAllOffresEmploi();
 List<OffreEmploiDTO> getOffresEmploiByTitre(String titre);
 OffreEmploiDTO createOffreEmploi(OffreEmploiDTO offreEmploiDTO);
 OffreEmploiDTO accepterOffreEmploi(int offreEmploiId);

 OffreEmploiDTO refuserOffreEmploi(int offreEmploiId);
}
