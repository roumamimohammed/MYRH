package com.example.myrh_app.DTO;

import com.example.myrh_app.Entities.OffreEmploiEntite;
import com.example.myrh_app.Entities.SocieteEntite;
import com.example.myrh_app.Enum.Status;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChercheurEmploiDTO {
    private int id;
    private String password;
    private String address;
    private String email;
    private String phoneNumber;
    private List<OffreEmploiDTO> offreEmploi;
}
