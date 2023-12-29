package com.example.myrh_app.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgentDTO {

    private int id;
    private String password;
    private String address;
    private String email;
    private String phoneNumber;

}
