package com.example.gmt.Authentification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistreRequest{
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String role;
}
