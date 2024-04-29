package com.example.gmt.Dto;

import com.example.gmt.Enitity.Employe;
import com.example.gmt.Enitity.FichierMedical;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AfficherEmp {
    private Long id;
    private String matricule;
    private String nom;
    private String prenom;
    private String sex;
    private String mail;
    private String tel;
    private String post;
    private String address;
    private String ville;
    private String codePostal;
    private LocalDate date_naissance;
    private Boolean fichierMedical;
    public static AfficherEmp EnitityToDto(Employe employe){
        Boolean isNew;
        FichierMedical fichierMedical= employe.getFichierMedical();
        if (fichierMedical==null){
            isNew=false;
        }
        else isNew=true;
        return AfficherEmp.builder()
                .matricule(employe.getMatricule())
                .post(employe.getPost().getFonction())
                .mail(employe.getMail())
                .sex(employe.getSex())
                .id(employe.getId())
                .tel(employe.getTel())
                .nom(employe.getNom())
                .prenom(employe.getPrenom())
                .address(employe.getAddress())
                .ville(employe.getVille())
                .codePostal(employe.getCodePostal())
                .date_naissance(employe.getDate_naissance())
                .fichierMedical(isNew)
                .build();
    }
}
