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
@Builder
@Entity
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idConsultation;
    private LocalDate dateConsultation;
    private String decription;
    private String Resultats;
    private String Diagnostic;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idFichierMedical")
    private FichierMedical fichierMedical;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmlploye")
    private Employe employe;
    private TypeConsultation typeConsultations;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idMaladie")
    private Maladie maladie;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idOrdanance")
    private Ordananace ordananace;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idLieu")
    private Lieu lieu;
}
