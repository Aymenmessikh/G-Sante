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
public class AfficherAllIntervention {
    private Long idConsultation;
    private LocalDate dateConsultation;
    private Long ordanance;
    private Long maladier;
    private String lieu;
    private String resultats;
    private String codeEmployer;
    private String typeConsultations;

    public static AfficherAllIntervention DtoFromEntityIntervention(Consultation consultation){
        return AfficherAllIntervention.builder()
                .typeConsultations(consultation.getTypeConsultations().toString())
                .resultats(consultation.getResultats())
                .codeEmployer(consultation.getEmploye().getMatricule())
                .dateConsultation(consultation.getDateConsultation())
                .idConsultation(consultation.getIdConsultation())
                .lieu(consultation.getLieu().getLieu())
                .build();
    }
    public static AfficherAllIntervention DtoFromEntityInterventionMaladie(Consultation consultation){
        return AfficherAllIntervention.builder()
                .typeConsultations(consultation.getTypeConsultations().toString())
                .resultats(consultation.getResultats())
                .codeEmployer(consultation.getEmploye().getMatricule())
                .dateConsultation(consultation.getDateConsultation())
                .idConsultation(consultation.getIdConsultation())
                .maladier(consultation.getMaladie().getIdMaladie())
                .lieu(consultation.getLieu().getLieu())
                .build();
    }
    public static AfficherAllIntervention DtoFromEntityInterventionOrdnnance(Consultation consultation){
        return AfficherAllIntervention.builder()
                .typeConsultations(consultation.getTypeConsultations().toString())
                .resultats(consultation.getResultats())
                .codeEmployer(consultation.getEmploye().getMatricule())
                .dateConsultation(consultation.getDateConsultation())
                .idConsultation(consultation.getIdConsultation())
                .ordanance(consultation.getOrdananace().getIdOrdanance())
                .lieu(consultation.getLieu().getLieu())
                .build();
    }
    public static AfficherAllIntervention DtoFromEntityInterventionOrdnnanceMaladie(Consultation consultation){
        return AfficherAllIntervention.builder()
                .typeConsultations(consultation.getTypeConsultations().toString())
                .resultats(consultation.getResultats())
                .codeEmployer(consultation.getEmploye().getMatricule())
                .dateConsultation(consultation.getDateConsultation())
                .idConsultation(consultation.getIdConsultation())
                .ordanance(consultation.getOrdananace().getIdOrdanance())
                .maladier(consultation.getMaladie().getIdMaladie())
                .lieu(consultation.getLieu().getLieu())
                .build();
    }
}
