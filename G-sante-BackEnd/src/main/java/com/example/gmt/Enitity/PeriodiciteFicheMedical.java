package com.example.gmt.Enitity;

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
public class PeriodiciteFicheMedical {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Long idPeriodicite;
        private Long periodicite;
        @ManyToOne
        @JoinColumn(name = "idFicheMedical")
        private FichierMedical fichierMedical;
        @ManyToOne
        @JoinColumn(name = "idControleMedicale")
        private ControleMedical controleMedical;

}
