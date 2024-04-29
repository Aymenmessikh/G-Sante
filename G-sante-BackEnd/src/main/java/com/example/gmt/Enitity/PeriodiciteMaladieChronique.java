package com.example.gmt.Enitity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class PeriodiciteMaladieChronique {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idPeriodicite;
    private Long periodicite;
    @ManyToOne
    @JoinColumn(name = "idMaladieChronique")
    private MaladieChronique maladieChronique;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idControleMedical")
    private ControleMedical controleMedical;
}
