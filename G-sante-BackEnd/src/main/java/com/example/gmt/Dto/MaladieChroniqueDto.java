package com.example.gmt.Dto;

import com.example.gmt.Enitity.MaladieChronique;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MaladieChroniqueDto {
    private String malladieChronique;
    private String description;
    private List<PeriodiciteMaladieChroniqueDto> periodiciteMaladieChroniqueDtos;
}
