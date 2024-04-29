package com.example.gmt.Dto;

import com.example.gmt.Enitity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AjouterFichierMedicalDto {
    private String groupSanguin;
    private List<Long> idMaladieCchroniques;
    private List<Long> idVaccins;
    private String notes;
    private int taille;
    private int poid;
    private LocalDate date_Creation;
    private List<PeriodiciteMaladieChroniqueDto> periodiciteMaladieChroniqueDtos;
    public static FichierMedical EntityFromDto(AjouterFichierMedicalDto ajouterFichierMedicalDto){
        return FichierMedical.builder()
                .date_Creation(ajouterFichierMedicalDto.getDate_Creation())
                .groupSanguin(ajouterFichierMedicalDto.getGroupSanguin())
                .notes(ajouterFichierMedicalDto.getNotes())
                .poid(ajouterFichierMedicalDto.getPoid())
                .taille(ajouterFichierMedicalDto.getTaille())
                .build();
    }
}
