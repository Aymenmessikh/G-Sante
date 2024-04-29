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
public class ResultatsControleMedicaleDto {
    private Long id;
    private String laboratoire;
    private String resultats;
    private LocalDate dateSortieResultats;
    private Long idControleMedicale;
}
