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
public class PeriodiciteFicheMedicaleDto {
    private Long idPeriodicite;
    private Long periodicite;
    private Long idControleMedicale;
    private AfficherControlleMedicale afficherControlleMedicale;
    public static PeriodiciteFicheMedicaleDto DtoFromEntiy(PeriodiciteFicheMedical periodiciteFicheMedical){
        return PeriodiciteFicheMedicaleDto.builder()
                .idPeriodicite(periodiciteFicheMedical.getIdPeriodicite())
                .periodicite(periodiciteFicheMedical.getPeriodicite())
                .afficherControlleMedicale(AfficherControlleMedicale.DtoFromEntity(periodiciteFicheMedical.getControleMedical()))
                .build();
    }
}
