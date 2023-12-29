package com.example.myrh_app.Implementation;

import com.example.myrh_app.DTO.SocieteDTO;
import com.example.myrh_app.Entities.SocieteEntite;
import com.example.myrh_app.Mappers.SocieteMapper;
import com.example.myrh_app.Repositories.SocieteRepository;
import com.example.myrh_app.Services.SocieteService;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
public class Societe implements SocieteService {

    @Autowired
    private SocieteRepository societeRepository;

    @Autowired
    private Email emailService;

    private final int CODE_VALIDATION_LENGTH = 6;
    private final int CODE_VALIDATION_EXPIRATION_MINUTES = 3;

    @Override
    public SocieteDTO createSociete(SocieteDTO societeDTO) {
        SocieteEntite societeEntite = SocieteMapper.INSTANCE.toEntity(societeDTO);
        String codeValidation = genererCodeValidation();

        societeEntite.setCodeValidation(codeValidation);
        societeEntite.setCodeValidationExpiration(LocalDateTime.now().plusMinutes(CODE_VALIDATION_EXPIRATION_MINUTES));

        SocieteEntite societeEntiteSaved = societeRepository.save(societeEntite);

        sendValidationCodeByEmail(societeEntiteSaved.getEmail(), codeValidation);

        return SocieteMapper.INSTANCE.toDto(societeEntiteSaved);
    }

    @Override
    public Optional<SocieteDTO> getSocieteById(int id) {
        Optional<SocieteEntite> societeEntiteOptional = societeRepository.findById(id);

        return societeEntiteOptional.map(SocieteMapper.INSTANCE::toDto);
    }


    public String genererCodeValidation() {
        return RandomStringUtils.randomAlphanumeric(CODE_VALIDATION_LENGTH);
    }

    public boolean verifierCodeValidation(String codeValidation) {
        Optional<SocieteEntite> societeEntiteOptional = societeRepository.findByCodeValidation(codeValidation);

        if (societeEntiteOptional.isPresent()) {
            LocalDateTime expirationTime = societeEntiteOptional.get().getCodeValidationExpiration();
            return LocalDateTime.now().isBefore(expirationTime);
        }

        return false;
    }
    public Optional<SocieteDTO> getSocieteByEmailAndPasswordAndCodeValidation(String email, String password, String codeValidation) {
        Optional<SocieteEntite> societeEntiteOptional = societeRepository.findByEmailAndPasswordAndCodeValidation(email, password, codeValidation);
        if (societeEntiteOptional.isPresent()) {
            SocieteEntite societeEntite = societeEntiteOptional.get();
            LocalDateTime expirationTime = societeEntite.getCodeValidationExpiration();
            if (LocalDateTime.now().isBefore(expirationTime) && societeEntite.getCodeValidation().equals(codeValidation)) {
                societeEntite.setCodeValidationExpiration(societeEntite.getCodeValidationExpiration().plusMonths(1));
                societeRepository.save(societeEntite);
                return societeEntiteOptional.map(SocieteMapper.INSTANCE::toDto);
            } else {
                return null;
            }
        }
        return null;
    }

    private void sendValidationCodeByEmail(String emailAddress, String codeValidation) {
        String subject = "Validation Code for Your Registration";
        String message = "Your validation code is: " + codeValidation;

        emailService.sendEmail(emailAddress, subject, message);
    }
    public boolean loginSociete(String email, String password, String codeValidation) {
        Optional<SocieteEntite> societeEntiteOptional = societeRepository.findByEmailAndPassword(email, password);

        if (societeEntiteOptional.isPresent()) {
            SocieteEntite societeEntite = societeEntiteOptional.get();
            LocalDateTime expirationTime = societeEntite.getCodeValidationExpiration();
            if (LocalDateTime.now().isBefore(expirationTime) && societeEntite.getCodeValidation().equals(codeValidation)) {
                societeEntite.setCodeValidationExpiration(societeEntite.getCodeValidationExpiration().plusMonths(1));
                societeRepository.save(societeEntite);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
