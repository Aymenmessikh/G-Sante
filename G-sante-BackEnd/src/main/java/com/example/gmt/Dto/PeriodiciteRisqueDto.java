package com.example.gmt.Dto;

import com.example.gmt.Enitity.PeriodiciteRisque;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PeriodiciteRisqueDto {
    private Long idPeriodicite;
    private Long periodicite;
    private String controleMedicale;
    private AfficherControlleMedicale afficherControlleMedicale;
    public static PeriodiciteRisqueDto DtoFromEntity(PeriodiciteRisque periodiciteRisque){
        return PeriodiciteRisqueDto.builder()
                .idPeriodicite(periodiciteRisque.getIdPeriodicite())
                .periodicite(periodiciteRisque.getPeriodicite())
                .afficherControlleMedicale(AfficherControlleMedicale.DtoFromEntity(periodiciteRisque.getControleMedical()))
                .build();
    }
}
