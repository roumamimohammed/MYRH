package com.example.myrh_app.Implementation;

import com.example.myrh_app.DTO.PostulationDTO;
import com.example.myrh_app.Entities.ChercheurEmploiEntite;
import com.example.myrh_app.Entities.OffreEmploiEntite;
import com.example.myrh_app.Entities.PostulationEntite;
import com.example.myrh_app.Entities.PostulationId;
import com.example.myrh_app.Repositories.ChercheurEmploiRepository;
import com.example.myrh_app.Repositories.OffreEmploiRepository;
import com.example.myrh_app.Repositories.PostulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Postulation {

    private final PostulationRepository postulationRepository;
    private final OffreEmploiRepository offreEmploiRepository;
    private final ChercheurEmploiRepository chercheurEmploiRepository;

    @Autowired
    public Postulation(PostulationRepository postulationRepository,
                              OffreEmploiRepository offreEmploiRepository,
                              ChercheurEmploiRepository chercheurEmploiRepository) {
        this.postulationRepository = postulationRepository;
        this.offreEmploiRepository = offreEmploiRepository;
        this.chercheurEmploiRepository = chercheurEmploiRepository;
    }

    public void addPostulation(PostulationDTO postulationDTO) {
        OffreEmploiEntite offreEmploi = offreEmploiRepository.findById(postulationDTO.getOffre().getId())
                .orElseThrow(() -> new IllegalArgumentException("Offre not found"));

        ChercheurEmploiEntite chercheurEmploi = chercheurEmploiRepository.findById(postulationDTO.getChercheur().getId())
                .orElseThrow(() -> new IllegalArgumentException("Chercheur not found"));

        PostulationId postulationId = new PostulationId(offreEmploi.getId(), chercheurEmploi.getId());
        PostulationEntite postulationEntite = new PostulationEntite(postulationId, offreEmploi, chercheurEmploi);

        postulationRepository.save(postulationEntite);
    }
}
