package com.example.gmt.Enitity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class VisiteEmbauche {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate dateVisite;
    @Lob
    private String description;
    private String resultats;
    @Lob
    private String diagnostic;
    private Long temperature;
    private Long pressionArterielle;
    private Long frequenceCardiaque;
    private Long frequenceRespiratoire;
    private Long glycemie;
    private Long testVisuel;
    @OneToOne
    @JoinColumn(name = "idFichierMedical")
    @JsonIgnore
    private FichierMedical fichierMedical;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idEmploye")
    private Employe employe;
    private String typeVisite;
}
