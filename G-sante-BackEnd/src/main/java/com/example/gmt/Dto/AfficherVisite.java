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
public class AfficherVisite {
    private Long id;
    private String typeVisite;
    private LocalDate date_Visite;
    private AfficherEmp employe;
    private String resultats;
    public static AfficherVisite DtoFromEntity(Vissite vissite){
        return AfficherVisite.builder()
                .date_Visite(vissite.getDate_Visite())
                .id(vissite.getId())
                .employe(AfficherEmp.EnitityToDto(vissite.getEmploye()))
                .resultats(vissite.getResultats())
                .typeVisite(vissite.getTypeVisite())
                .build();
    }
}
