package com.example.gmt.Enitity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class MaladieChronique {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idMalladieChronique")
    private Long id;
    @Column(nullable = false,unique = true)
    private String malladieChronique;
    @Lob
    private String description;
    @OneToMany(mappedBy = "maladieChronique",cascade =CascadeType.REMOVE)
    private List<PeriodiciteMaladieChronique> periodiciteMaladieChroniques;
}
