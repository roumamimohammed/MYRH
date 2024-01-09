package com.example.myrh_app.Controllers;

import com.example.myrh_app.DTO.OffreEmploiDTO;
import com.example.myrh_app.Implementation.OffreEmploi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/offres-emploi")
public class OffreEmploiController {

    private final OffreEmploi offreEmploiService;

    @Autowired
    public OffreEmploiController(OffreEmploi offreEmploiService) {
        this.offreEmploiService = offreEmploiService;
    }

    @GetMapping
    public ResponseEntity<List<OffreEmploiDTO>> getAllOffresEmploi() {
        List<OffreEmploiDTO> offresEmploi = offreEmploiService.getAllOffresEmploi();
        return new ResponseEntity<>(offresEmploi, HttpStatus.OK);
    }
    @GetMapping("/recherche")
    public List<OffreEmploiDTO> getOffresEmploiByTitre(@RequestParam String titre) {
        return offreEmploiService.getOffresEmploiByTitre(titre);
    }
    @PostMapping("/update-statutA/{offreEmploiId}")
    public ResponseEntity<Void> updateStatutA(@PathVariable int offreEmploiId) {
        offreEmploiService.accepterOffreEmploi(offreEmploiId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/update-statutR/{offreEmploiId}")
    public ResponseEntity<Void> updateStatutR(@PathVariable int offreEmploiId) {
        offreEmploiService.refuserOffreEmploi(offreEmploiId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/creer")
    public ResponseEntity<OffreEmploiDTO> createOffreEmploi(@RequestBody OffreEmploiDTO offreEmploiDTO) {
        OffreEmploiDTO createdOffreEmploi = offreEmploiService.createOffreEmploi(offreEmploiDTO);
        return new ResponseEntity<>(createdOffreEmploi, HttpStatus.CREATED);
    }

    @GetMapping("/agent")
    public ResponseEntity<List<OffreEmploiDTO>> getEnAttendOffresEmploi() {
        List<OffreEmploiDTO> offresEmploi = offreEmploiService.geEnAttendOffresEmploi();
        return new ResponseEntity<>(offresEmploi, HttpStatus.OK);
    }
    
}
