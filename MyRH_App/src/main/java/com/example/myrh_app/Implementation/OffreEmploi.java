package com.example.myrh_app.Implementation;

import com.example.myrh_app.DTO.OffreEmploiDTO;
import com.example.myrh_app.Entities.OffreEmploiEntite;
import com.example.myrh_app.Repositories.OffreEmploiRepository;
import com.example.myrh_app.Services.OffreEmploiService;
import com.example.myrh_app.Mappers.OffreEmploiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.myrh_app.Enum.Status.*;

@Service
@Transactional
public class OffreEmploi implements OffreEmploiService {
    private final   OffreEmploiRepository offreEmploiRepository;
    @Autowired
    public OffreEmploi(OffreEmploiRepository offreEmploiRepository) {
        this.offreEmploiRepository = offreEmploiRepository;
    }
    @Override
    public List<OffreEmploiDTO> getAllOffresEmploi() {
        List<OffreEmploiEntite> offresEmploi = offreEmploiRepository.findAllByStatut(Accepter);
        return offresEmploi.stream()
                .map(OffreEmploiMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    public List<OffreEmploiDTO> geEnAttendOffresEmploi() {
        List<OffreEmploiEntite> offresEmploi = offreEmploiRepository.findAllByStatut(EnAttend);
        return offresEmploi.stream()
                .map(OffreEmploiMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public List<OffreEmploiDTO> getOffresEmploiByTitre(String titre) {
        List<OffreEmploiEntite> offresEmploi = offreEmploiRepository.findByTitreContainingIgnoreCase(titre);
        return offresEmploi.stream()
                .map(OffreEmploiMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OffreEmploiDTO createOffreEmploi(OffreEmploiDTO offreEmploiDTO) {
            offreEmploiDTO.setStatut(EnAttend);
            OffreEmploiEntite offreEmploiEntite = OffreEmploiMapper.INSTANCE.toEntity(offreEmploiDTO);

            OffreEmploiEntite savedOffreEmploiEntite = offreEmploiRepository.save(offreEmploiEntite);

            return OffreEmploiMapper.INSTANCE.toDto(savedOffreEmploiEntite);
    }

    @Override
    public OffreEmploiDTO accepterOffreEmploi(int offreEmploiId) {
        int offresEmploi = offreEmploiRepository.updateStatut(offreEmploiId,Accepter);
        return OffreEmploiMapper.INSTANCE.toDtoint(offresEmploi);

    }

 @Override
public OffreEmploiDTO refuserOffreEmploi(int offreEmploiId) {
     int offresEmploi = offreEmploiRepository.updateStatut(offreEmploiId,Refuser);
     return OffreEmploiMapper.INSTANCE.toDtoint(offresEmploi);
 }
}
