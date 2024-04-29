package com.example.gmt.Dto;

import com.example.gmt.Enitity.Consultation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AfficherConsulationById {
    private Long idConsultation;
    private LocalDate dateConsultation;
    private String description;
    private String resultats;
    private String diagnostic;
    private OrdananceDto ordananceDto;
    private MaladierDto maladierDto;
    private Long codeEmployer;
    private String typeConsultations;
    private LieuDto lieuDto;
    public static AfficherConsulationById DtoFromEntity(Consultation consultation){
        return AfficherConsulationById.builder()
                .dateConsultation(consultation.getDateConsultation())
                .diagnostic(consultation.getDiagnostic())
                .description(consultation.getDecription())
                .resultats(consultation.getResultats())
                .typeConsultations(consultation.getTypeConsultations().toString())
                .maladierDto(MaladierDto.DtoFromEnrity(consultation.getMaladie()))
                .ordananceDto(OrdananceDto.DtoFromEntity(consultation.getOrdananace()))
                .build();
    }
}
