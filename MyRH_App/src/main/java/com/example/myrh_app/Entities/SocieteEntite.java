package com.example.myrh_app.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SocieteEntite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String password;
    private String address;
    private String email;
    private String phoneNumber;
    private String codeValidation;
    private LocalDateTime codeValidationExpiration;
    private String image;
    @OneToMany(mappedBy = "societe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OffreEmploiEntite> offresEmploi;
}

