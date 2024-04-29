package com.example.gmt.Enitity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class ResultatControlleMedicale {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String Laboratoire;
    private String Resultats;
    private LocalDate dateSortieResultats;
    @ManyToOne
    @JoinColumn(name = "idVisite")
    private Vissite vissite;
    @ManyToOne
    @JoinColumn(name = "idContoleMedicale")
    private ControleMedical controleMedical;
}
