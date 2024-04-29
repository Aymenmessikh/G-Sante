package com.example.gmt.Dto;
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
public class VisiteDto {
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
    private List<ResultatsControleMedicaleDto> resultatsControleMedicaleDto;
}
