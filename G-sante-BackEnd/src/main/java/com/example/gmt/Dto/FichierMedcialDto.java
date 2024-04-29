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
public class FichierMedcialDto {
    private Long id;
    private LocalDate date_Creation;
    private String groupSanguin;
    private List<Vaccins> vaccins;
    private String notes;
    private int taille;
    private int poid;
    private List<AfficheControleByMaladieChronique> maladie_chroniques;
    private List<AfficherControleByFicheMedicale> afficherControleByFicheMedicales;

}
