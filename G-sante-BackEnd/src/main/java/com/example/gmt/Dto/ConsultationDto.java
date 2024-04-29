package com.example.gmt.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsultationDto {
    private Long idConsultation;
    private LocalDate dateConsultation;
    private String description;
    private String resultats;
    private String diagnostic;
    private OrdananceDto ordananceDto;
    private MaladierDto maladierDto;
    private String codeEmployer;
    private String typeConsultations;
    private LieuDto lieuDto;
}
