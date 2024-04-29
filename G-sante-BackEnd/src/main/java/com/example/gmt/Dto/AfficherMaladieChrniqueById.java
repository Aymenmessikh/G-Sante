package com.example.gmt.Dto;

import com.example.gmt.Enitity.MaladieChronique;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AfficherMaladieChrniqueById {
    private Long id;
    private String malladieChronique;
    private String description;
    private List<PeriodiciteMaladieChroniqueDto> periodiciteMaladieChroniqueDtos;
    public static AfficherMaladieChrniqueById EntityToDto(MaladieChronique maladieChronique){
        return AfficherMaladieChrniqueById.builder()
                .description(maladieChronique.getDescription())
                .id(maladieChronique.getId())
                .malladieChronique(maladieChronique.getMalladieChronique())
                .build();
    }
}
