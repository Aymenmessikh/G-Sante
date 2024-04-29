package com.example.gmt.Dto;

import com.example.gmt.Enitity.Risque;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AfficherAllRisque {
    private Long id;
    private String risque;
    private String description;
//    private List<PeriodiciteRisqueDto> periodiciteRisqueDtos;
    public static AfficherAllRisque EntityToDto(Risque risque){
        return AfficherAllRisque.builder()
                .risque(risque.getRisque())
                .id(risque.getId())
                .description(risque.getDescription())
                .build();
    }
}
