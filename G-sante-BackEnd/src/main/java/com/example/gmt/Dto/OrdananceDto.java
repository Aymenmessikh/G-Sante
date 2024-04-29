package com.example.gmt.Dto;

import com.example.gmt.Enitity.Ordananace;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdananceDto {
    private Long idOrdanance;
    private Boolean isExiste;
    private LocalDate dateCerationOrdanance;
    private List<MedicamentDto> medicamentDtos;
    public static Ordananace DtoToEntity(OrdananceDto ordananceDto){
        return Ordananace.builder()
                .dateCerationOrdanance(ordananceDto.getDateCerationOrdanance())
                .medicament(ordananceDto.getMedicamentDtos().stream().map(MedicamentDto::DtoToEntity).collect(Collectors.toList()))
                .build();
    }

    public static OrdananceDto DtoFromEntity(Ordananace ordananace) {
        return OrdananceDto.builder()
                .idOrdanance(ordananace.getIdOrdanance())
                .dateCerationOrdanance(ordananace.getDateCerationOrdanance())
                .medicamentDtos(ordananace.getMedicament().stream().map(MedicamentDto::DtoFromEntity).collect(Collectors.toList()))
                .build();
    }
}
