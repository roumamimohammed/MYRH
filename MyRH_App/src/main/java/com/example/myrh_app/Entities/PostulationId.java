package com.example.myrh_app.Entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostulationId implements Serializable {
    private int offreId;
    private int chercheurId;

}


