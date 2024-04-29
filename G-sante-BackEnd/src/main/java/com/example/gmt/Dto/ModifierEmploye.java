package com.example.gmt.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModifierEmploye {
    private String nom;
    private String prenom;
    private String sex;
    private String mail;
    private String tel;
    private Long post;
    private String address;
    private String ville;
    private String codePostal;
    private LocalDate date_naissance;
}
