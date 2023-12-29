package com.example.myrh_app.Repositories;

import com.example.myrh_app.Entities.OffreEmploiEntite;
import com.example.myrh_app.Enum.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OffreEmploiRepository extends JpaRepository<OffreEmploiEntite,Integer> {
    List<OffreEmploiEntite> findByTitreContainingIgnoreCase(String titre);
    List<OffreEmploiEntite> findAllByStatut(Status EnAttend);

    @Modifying
    @Query("UPDATE OffreEmploiEntite o SET o.statut = :nouveauStatut WHERE o.id = :offreEmploiId")
    int updateStatut(@Param("offreEmploiId") int offreEmploiId, @Param("nouveauStatut") Status nouveauStatut);
}
