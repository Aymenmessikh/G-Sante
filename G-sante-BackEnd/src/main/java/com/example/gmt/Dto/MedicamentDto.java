package com.example.gmt.Dto;

import com.example.gmt.Enitity.Medicament;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicamentDto {
    private Long idMedicament;
    private String medicament;
    private String quantite;
    public static  Medicament DtoToEntity(MedicamentDto medicamentDto){
        return Medicament.builder()
                .medicament(medicamentDto.getMedicament())
                .quantite(medicamentDto.getQuantite())
                .build();
    }

    public static MedicamentDto DtoFromEntity(Medicament medicament) {
        return MedicamentDto.builder()
                .quantite(medicament.getQuantite())
                .idMedicament(medicament.getIdMedicament())
                .medicament(medicament.getMedicament())
                .build();
    }
}
