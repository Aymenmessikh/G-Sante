package com.example.gmt.Repository;

import com.example.gmt.Enitity.Employe;
import com.example.gmt.Enitity.Vissite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VissiteRepository extends JpaRepository<Vissite,Long> {
    Vissite findVissiteById(Long id);


    List<Vissite> findAllVissiteByEmploye(Employe employe);
}
