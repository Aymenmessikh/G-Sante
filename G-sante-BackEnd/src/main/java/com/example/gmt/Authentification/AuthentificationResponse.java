package com.example.gmt.Authentification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthentificationResponse {
    private String token;
    private String role;
    private String nom;
    private String prenom;
}
