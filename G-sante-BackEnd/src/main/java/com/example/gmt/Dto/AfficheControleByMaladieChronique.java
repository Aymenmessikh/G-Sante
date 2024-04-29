package com.example.gmt.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AfficheControleByMaladieChronique {
    private String maladieChronique;
    private Long id;
    private String typeControle;
    private String controle;
    private Long periodicte;
}
