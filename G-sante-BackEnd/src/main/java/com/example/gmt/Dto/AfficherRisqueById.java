package com.example.gmt.Dto;

import com.example.gmt.Enitity.Risque;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AfficherRisqueById {
    private Long id;
    private String risque;
    private String description;
    private List<PeriodiciteRisqueDto> periodiciteRisqueDtos;
    public static AfficherRisqueById EntityToDto(Risque risque){
        return AfficherRisqueById.builder()
                .risque(risque.getRisque())
                .id(risque.getId())
                .description(risque.getDescription())
                .build();
    }
}
