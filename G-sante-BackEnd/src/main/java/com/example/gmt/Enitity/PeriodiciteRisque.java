package com.example.gmt.Enitity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PeriodiciteRisque {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idPeriodicite;
    private Long periodicite;
    @ManyToOne
    @JoinColumn(name = "idRisque")
    @JsonIgnore
    private Risque risques;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idControleMedical")
    private ControleMedical controleMedical;
}
