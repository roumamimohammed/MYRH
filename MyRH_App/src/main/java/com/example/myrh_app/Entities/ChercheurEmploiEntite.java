package com.example.myrh_app.Entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChercheurEmploiEntite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String password;
    private String address;
    private String email;
    private String phoneNumber;
    @ManyToMany
    @JoinTable(
            name = "Postulation",
            joinColumns = @JoinColumn(name = "chercheur_id"),
            inverseJoinColumns = @JoinColumn(name = "offre_id")
    )
    private List<OffreEmploiEntite> offreEmploiEntite;


}
