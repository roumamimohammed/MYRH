package com.example.myrh_app.Repositories;

import com.example.myrh_app.Entities.SocieteEntite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SocieteRepository extends JpaRepository<SocieteEntite, Integer> {
    Optional<SocieteEntite> findByCodeValidation(String codeValidation);

    Optional<SocieteEntite> findByEmailAndPassword(String email, String password);

    Optional<SocieteEntite> findById(int id);
    Optional<SocieteEntite> findByEmailAndPasswordAndCodeValidation(String email, String password, String codeValidation);
}
