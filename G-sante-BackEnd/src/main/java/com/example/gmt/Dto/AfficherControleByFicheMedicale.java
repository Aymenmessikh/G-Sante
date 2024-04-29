package com.example.gmt.Dto;

import com.example.gmt.Enitity.PeriodiciteFicheMedical;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AfficherControleByFicheMedicale {
    private Long id;
    private String typeControle;
    private String controle;
    private Long periodicte;
    private ResultatsControleMedicaleDto resultatsControleMedicaleDto;
    public static AfficherControleByFicheMedicale DtoFromEntity(PeriodiciteFicheMedical periodiciteFicheMedical){
        return AfficherControleByFicheMedicale.builder()
                .controle(periodiciteFicheMedical.getControleMedical().getControle())
                .id(periodiciteFicheMedical.getControleMedical().getIdControle())
                .periodicte(periodiciteFicheMedical.getPeriodicite())
                .typeControle(periodiciteFicheMedical.getControleMedical().getTypeControle())
                .resultatsControleMedicaleDto(new ResultatsControleMedicaleDto())
                .build();
    }
}
