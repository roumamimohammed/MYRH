package com.example.myrh_app.Services;

import com.example.myrh_app.DTO.SocieteDTO;

import java.util.List;
import java.util.Optional;

public interface SocieteService {
   /* SocieteDTO getSocieteById(int id);
    List<SocieteDTO> getAllSocietes();
    SocieteDTO updateSociete(int id, SocieteDTO societeDTO);
    void deleteSociete(int id);*/
   SocieteDTO createSociete(SocieteDTO societeDTO);
   Optional<SocieteDTO> getSocieteById(int id);
}
