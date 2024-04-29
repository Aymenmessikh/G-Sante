package com.example.gmt.Enitity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@ToString
public class Risque {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false,unique = true)
    private String risque;
    @Lob
    private String description;
    @ManyToMany(mappedBy = "risques")
    @JsonIgnore
    private List<Post> posts;
    @OneToMany(mappedBy = "risques",cascade =CascadeType.REMOVE)
    private List<PeriodiciteRisque> periodiciteRisque;
}
