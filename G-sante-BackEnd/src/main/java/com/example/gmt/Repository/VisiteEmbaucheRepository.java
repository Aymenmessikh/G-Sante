package com.example.gmt.Repository;

import com.example.gmt.Enitity.Employe;
import com.example.gmt.Enitity.VisiteEmbauche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisiteEmbaucheRepository extends JpaRepository<VisiteEmbauche,Long> {
    public VisiteEmbauche findVisiteEmbaucheById(Long id);

    VisiteEmbauche findVisiteEmbaucheByEmploye(Employe employe);
}

