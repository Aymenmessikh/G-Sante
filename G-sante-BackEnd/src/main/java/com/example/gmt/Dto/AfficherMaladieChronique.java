package com.example.gmt.Dto;

import com.example.gmt.Enitity.MaladieChronique;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AfficherMaladieChronique {
    private Long id;
    private String malladieChronique;
    private String description;
    public static AfficherMaladieChronique EntityToDto(MaladieChronique maladieChronique){
        return AfficherMaladieChronique.builder()
                .description(maladieChronique.getDescription())
                .id(maladieChronique.getId())
                .malladieChronique(maladieChronique.getMalladieChronique())
                .build();
    }
}
