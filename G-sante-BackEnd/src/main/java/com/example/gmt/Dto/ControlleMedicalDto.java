package com.example.gmt.Dto;

import com.example.gmt.Enitity.ControleMedical;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ControlleMedicalDto {
    private String description;
    private String controle;
    private String typeControle;
    public static ControleMedical DtoToEntity(ControlleMedicalDto controlleMedicalDto){
        return ControleMedical.builder()
                .controle(controlleMedicalDto.getControle())
                .typeControle(controlleMedicalDto.getTypeControle())
                .description(controlleMedicalDto.getDescription())
                .build();
    }
}
