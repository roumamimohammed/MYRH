package com.example.myrh_app.Controllers;

import com.example.myrh_app.DTO.SocieteDTO;
import com.example.myrh_app.Implementation.Societe;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/Societe")
public class SocieteController {
    private final Societe societeService;

    public SocieteController(Societe societeService) {
        this.societeService = societeService;
    }

    @PostMapping("/creer")
    public ResponseEntity<SocieteDTO> createOffreEmploi(@RequestBody SocieteDTO societeDTO) {
        SocieteDTO createdSociete = societeService.createSociete(societeDTO);
        return new ResponseEntity<>(createdSociete, HttpStatus.CREATED);
    }
    @GetMapping("/{societeId}")
    public ResponseEntity<SocieteDTO> getSocieteDetails(@PathVariable int societeId) {
        Optional<SocieteDTO> societeDTO = societeService.getSocieteById(societeId);

        return societeDTO
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/details")
    public ResponseEntity<SocieteDTO> getSocieteDetailsAfterLogin(@RequestParam int societeId) {
        Optional<SocieteDTO> societeDTO = societeService.getSocieteById(societeId);

        return societeDTO
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/login")
    public ResponseEntity<Integer> loginSociete(@RequestBody SocieteDTO loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        String codeValidation = loginRequest.getCodeValidation();

        Optional<SocieteDTO> societeDTO = societeService.getSocieteByEmailAndPasswordAndCodeValidation(email, password, codeValidation);

        return societeDTO
                .map(dto -> new ResponseEntity<>(dto.getId(), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.UNAUTHORIZED));
    }

}
