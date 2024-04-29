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
public class AfficherControlleMedicale {
    private Long idControle;
    private String description;
    private String controle;
    private String typeControle;
    public static AfficherControlleMedicale DtoFromEntity(ControleMedical controleMedical) {
        if (controleMedical == null) {
            return null;
        }

        return AfficherControlleMedicale.builder()
                .idControle(controleMedical.getIdControle())
                .controle(controleMedical.getControle())
                .typeControle(controleMedical.getTypeControle())
                .description(controleMedical.getDescription())
                // Other mappings here
                .build();
    }
}
