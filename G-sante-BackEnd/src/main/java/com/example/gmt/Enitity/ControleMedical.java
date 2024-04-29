package com.example.gmt.Enitity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Builder
public class ControleMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idControle;
    @Column(unique = true,nullable = false)
    private String controle;
    private String typeControle;
    @Lob
    private String description;
    @OneToMany(mappedBy = "controleMedical")
    @JsonIgnore
    private List<PeriodiciteRisque> periodiciteRisque;
    @OneToMany(mappedBy = "controleMedical")
    @JsonIgnore
    private List<PeriodiciteFicheMedical> periodiciteFicheMedicals;
    @OneToMany(mappedBy = "controleMedical")
    @JsonIgnore
    private List<PeriodiciteMaladieChronique> periodiciteMaladieChroniques;
    @OneToMany(mappedBy = "controleMedical")
    @JsonIgnore
    private List<ResultatControlleMedicale> resultatControlleMedicales;
}
