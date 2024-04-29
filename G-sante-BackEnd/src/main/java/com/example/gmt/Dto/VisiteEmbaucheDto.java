package com.example.gmt.Dto;

import com.example.gmt.Enitity.VisiteEmbauche;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VisiteEmbaucheDto {
    private Long id;
    private LocalDate date_Visite;
    private AfficherEmp employe;
    private String description;
    private String resultats;
    private String diagnostic;
    private String typeVisite;
    private Long temperature;
    private Long pressionArterielle;
    private Long frequenceCardiaque;
    private Long frequenceRespiratoire;
    private Long glycemie;
    private Long testVisuel;
    private List<ResultatsControleMedicaleDto> resultatsControleMedicaleDto;
    public static VisiteEmbaucheDto DtoFromEntity(VisiteEmbauche vissite){
            return VisiteEmbaucheDto.builder()
                    .date_Visite(vissite.getDateVisite())
                    .id(vissite.getId())
                    .employe(AfficherEmp.EnitityToDto(vissite.getEmploye()))
                    .resultats(vissite.getResultats())
                    .diagnostic(vissite.getDiagnostic())
                    .description(vissite.getDescription())
                    .typeVisite(vissite.getTypeVisite())
                    .temperature(vissite.getTemperature())
                    .frequenceRespiratoire(vissite.getFrequenceRespiratoire())
                    .frequenceCardiaque(vissite.getFrequenceCardiaque())
                    .glycemie(vissite.getGlycemie())
                    .testVisuel(vissite.getTestVisuel())
                    .pressionArterielle(vissite.getPressionArterielle())
                    .build();
    }
    public static VisiteEmbauche DtoToEntity(VisiteEmbaucheDto vissite){
            return VisiteEmbauche.builder()
                    .dateVisite(vissite.getDate_Visite())
                    .resultats(vissite.getResultats())
                    .diagnostic(vissite.getDiagnostic())
                    .description(vissite.getDescription())
                    .typeVisite(vissite.getTypeVisite())
                    .temperature(vissite.getTemperature())
                    .frequenceRespiratoire(vissite.getFrequenceRespiratoire())
                    .frequenceCardiaque(vissite.getFrequenceCardiaque())
                    .glycemie(vissite.getGlycemie())
                    .testVisuel(vissite.getTestVisuel())
                    .pressionArterielle(vissite.getPressionArterielle())
                    .build();
    }
}
