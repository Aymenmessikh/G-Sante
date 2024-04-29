package com.example.gmt.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PeriodiciteMaladieChroniqueDto {
    private Long idPeriodicite;
    private Long periodicite;
    private String controleMedicale;
    private AfficherControlleMedicale afficherControlleMedicale;
}
