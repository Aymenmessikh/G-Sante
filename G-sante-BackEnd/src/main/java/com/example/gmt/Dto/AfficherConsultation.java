package com.example.gmt.Dto;

import com.example.gmt.Enitity.Employe;
import com.example.gmt.Enitity.TypeConsultation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AfficherConsultation {
    private Long idConsultation;
    private LocalDate dateConsultation;
    private String decription;
    private String resultats;
    private String diagnostic;
    private Employe employe;
    private TypeConsultation typeConsultations;
}
