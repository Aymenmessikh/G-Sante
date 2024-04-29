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
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idPost;
    @Column(nullable = false,updatable = false,unique = true)
    private String codePost;
    private String department;
    private String directrion;
    @Column(nullable = false,unique = true)
    private String fonction;
    @OneToMany(mappedBy = "post")
    @JsonIgnore
    private List<Employe> employes;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Risque_Post",
            joinColumns ={
                    @JoinColumn(name = "postId")
    },
            inverseJoinColumns = {
                    @JoinColumn(name = "risqueId")
            }
    )
    private List<Risque> risques;
}
