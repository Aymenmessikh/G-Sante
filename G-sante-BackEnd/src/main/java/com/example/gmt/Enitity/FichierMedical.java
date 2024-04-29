package com.example.gmt.Enitity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class FichierMedical {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Allergie_Medical",
            joinColumns = {
                    @JoinColumn(name = "id_allergie")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "id_fichierMed")
            }
    )
    private List<Allergie> allergier;
    private String groupSanguin;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "MaladieChronique_Medical",
            joinColumns = {
                    @JoinColumn(name = "id_malladieChronique")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "id_fichierMed")
            }
    )
    private List<MaladieChronique> maladie_chroniques;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Vaccins_Medical",
            joinColumns = {
                    @JoinColumn(name = "id_vaccin")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "id_fichierMed")
            }
    )
    private List<Vaccins> vaccins;
    private String notes;
    private int taille;
    private int poid;
    private LocalDate dateProchaineVisit;
    private LocalDate datederniereVisit;
    private Boolean ajouterVisit;
//    @Version()
//    private Long version;
    private LocalDate date_Creation;
    @OneToMany(mappedBy = "fichierMedical")
    @JsonIgnore
    private List<Vissite> visites;
    @OneToOne
    @JoinColumn(name = "idVisiteEmbauche")
    @JsonIgnore
    private VisiteEmbauche visiteEmbauche;
    @OneToOne
    @JoinColumn(name = "id_Employer")
    @JsonIgnore
    private Employe employe;
    @OneToMany(mappedBy = "fichierMedical",fetch = FetchType.EAGER)
    private List<Consultation> consultations;
    @OneToMany(cascade = CascadeType.REMOVE)
    private List<PeriodiciteFicheMedical> periodiciteFicheMedicals;
}
