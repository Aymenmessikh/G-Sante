package com.example.gmt.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AfficherControleByRisque {
    private String risque;
    private Long idPeriodicite;
    private String typeControle;
    private String controle;
    private Long periodicte;
}
