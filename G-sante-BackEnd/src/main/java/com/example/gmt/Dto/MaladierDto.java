package com.example.gmt.Dto;

import com.example.gmt.Enitity.Maladie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MaladierDto {
    private Long idMaladie;
    private String Description;
    private Boolean isExiste;
    private LocalDate dateDebutMaldier;
    private int nombreJours;
    public static Maladie DtoToEnrity(MaladierDto maladierDto){
        return Maladie.builder()
                .dateDebutMaldier(maladierDto.getDateDebutMaldier())
                .nombreJours(maladierDto.getNombreJours())
                .description(maladierDto.getDescription())
                .build();
    }

    public static MaladierDto DtoFromEnrity(Maladie maladie) {
        return MaladierDto.builder()
                .dateDebutMaldier(maladie.getDateDebutMaldier())
                .nombreJours(maladie.getNombreJours())
                .Description(maladie.getDescription())
                .idMaladie(maladie.getIdMaladie())
                .build();
    }
}
