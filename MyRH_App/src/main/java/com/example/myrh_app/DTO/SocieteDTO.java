package com.example.myrh_app.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SocieteDTO {
    private int id;
    private String password;
    private String address;
    private String email;
    private String codeValidation;
    private String phoneNumber;
    private String image;
}
