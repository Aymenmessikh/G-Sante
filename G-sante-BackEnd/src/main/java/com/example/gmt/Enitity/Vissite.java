package com.example.gmt.Enitity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Vissite implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate date_Visite;
    @Lob
    private String description;
    private String resultats;
    @Lob
    private String diagnostic;
    private Long temperature;
    private Long pressionArterielle;
    private Long frequenceCardiaque;
    private Long frequenceRespiratoire;
    private int poids;
    private int taille;
    private Long glycemie;
    private Long testVisuel;
    @ManyToOne
    @JoinColumn(name = "idFichierMedical")
    @JsonIgnore
    private FichierMedical fichierMedical;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idEmploye")
    private Employe employe;
    private String typeVisite;
    @OneToMany(mappedBy = "vissite",cascade =CascadeType.REMOVE)
    private List<ResultatControlleMedicale> resultatControlleMedicales;

}
