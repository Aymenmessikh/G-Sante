package com.example.gmt.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Month;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NombreConsultationParMois {
    private Month moisDeConsultation;
    private Long nombreDeConsultation;
}

