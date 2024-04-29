package com.example.gmt.Enitity;

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
public class Employe implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String matricule;

    private String nom;
    private String prenom;
    private String sex;
    private String mail;
    private String tel;
    @ManyToOne()
    @JoinColumn(name = "post_id",nullable = false)
    private Post post;
    private String address;
    private String ville;
    private String codePostal;
    private LocalDate date_naissance;
    @OneToOne(cascade = CascadeType.REMOVE /*orphanRemoval = true*/)
    @JoinColumn(name = "idFichierMedical")
    private FichierMedical fichierMedical;
    @OneToMany(mappedBy = "employe",cascade = CascadeType.REMOVE)
    private List<Vissite> vissites;
    @OneToMany(mappedBy = "employe",cascade = CascadeType.REMOVE)
    private List<Consultation> consultations;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="idVisiteEmbouche")
    private VisiteEmbauche visiteEmbauche;
}
