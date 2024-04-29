package com.example.gmt.Dto;

import com.example.gmt.Enitity.Vissite;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AfficherVisiteByEmploye {
    private Long id;
    private LocalDate date_Visite;
    private String description;
    private String resultats;
    private String diagnostic;
    private Long temperature;
    private Long pressionArterielle;
    private Long frequenceCardiaque;
    private Long frequenceRespiratoire;
    private int poids;
    private int taille;
    private Long glycemie;
    private Long testVisuel;
    private String typeVisite;
    public static AfficherVisiteByEmploye DtoFromEntity(Vissite vissite){
        return AfficherVisiteByEmploye.builder()
                .date_Visite(vissite.getDate_Visite())
                .id(vissite.getId())
                .resultats(vissite.getResultats())
                .diagnostic(vissite.getDiagnostic())
                .description(vissite.getDescription())
                .temperature(vissite.getTemperature())
                .pressionArterielle(vissite.getPressionArterielle())
                .frequenceRespiratoire(vissite.getFrequenceRespiratoire())
                .frequenceCardiaque(vissite.getFrequenceCardiaque())
                .poids(vissite.getPoids())
                .taille(vissite.getTaille())
                .testVisuel(vissite.getTestVisuel())
                .glycemie(vissite.getGlycemie())
                .typeVisite(vissite.getTypeVisite())
                .build();
    }
}
