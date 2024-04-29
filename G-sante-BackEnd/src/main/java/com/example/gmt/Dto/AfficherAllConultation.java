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
public class AfficherAllConultation {
    private Long idConsultation;
    private LocalDate dateConsultation;
    private Long ordanance;
    private Long maladier;
    private String resultats;
    private String codeEmployer;
    private String typeConsultations;
    public static AfficherAllConultation DtoFromEntityOrdannanceMaladie(Consultation consultation){
        return AfficherAllConultation.builder()
                .typeConsultations(consultation.getTypeConsultations().toString())
                .resultats(consultation.getResultats())
                .codeEmployer(consultation.getEmploye().getMatricule())
                .dateConsultation(consultation.getDateConsultation())
                .idConsultation(consultation.getIdConsultation())
                .maladier(consultation.getMaladie().getIdMaladie())
                .ordanance(consultation.getOrdananace().getIdOrdanance())
                .build();
    }
    public static AfficherAllConultation DtoFromEntity(Consultation consultation){
        return AfficherAllConultation.builder()
                .typeConsultations(consultation.getTypeConsultations().toString())
                .resultats(consultation.getResultats())
                .codeEmployer(consultation.getEmploye().getMatricule())
                .dateConsultation(consultation.getDateConsultation())
                .idConsultation(consultation.getIdConsultation())
                .build();
    }

    public static AfficherAllConultation DtoFromEntityOrdannance(Consultation consultation){
        return AfficherAllConultation.builder()
                .typeConsultations(consultation.getTypeConsultations().toString())
                .resultats(consultation.getResultats())
                .codeEmployer(consultation.getEmploye().getMatricule())
                .dateConsultation(consultation.getDateConsultation())
                .idConsultation(consultation.getIdConsultation())
                .ordanance(consultation.getOrdananace().getIdOrdanance())
                .build();
    }

    public static AfficherAllConultation DtoFromEntityMaladie(Consultation consultation){
        return AfficherAllConultation.builder()
                .typeConsultations(consultation.getTypeConsultations().toString())
                .resultats(consultation.getResultats())
                .codeEmployer(consultation.getEmploye().getMatricule())
                .dateConsultation(consultation.getDateConsultation())
                .idConsultation(consultation.getIdConsultation())
                .maladier(consultation.getMaladie().getIdMaladie())
                .build();
    }
}
