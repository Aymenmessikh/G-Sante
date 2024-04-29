package com.example.gmt.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaladiesChroniquePlusCourant {
    public String maladiesChronique;
    public Long nombreMaladies;
}
