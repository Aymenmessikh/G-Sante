package com.example.gmt.Dto;

import com.example.gmt.Enitity.PeriodiciteRisque;
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
public class RisqueDto {
    private String risque;
    private String description;
    private List<PeriodiciteRisqueDto> periodiciteRisqueDtos;
    public static RisqueDto RisqueDtoFtomRisque(Risque risque){
        return RisqueDto.builder()
                .risque(risque.getRisque())
                .description(risque.getDescription())
                .build();
    }
}
