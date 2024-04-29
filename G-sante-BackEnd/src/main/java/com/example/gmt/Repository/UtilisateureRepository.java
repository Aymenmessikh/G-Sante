package com.example.gmt.Repository;

import com.example.gmt.Enitity.Utilisateure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateureRepository extends JpaRepository<Utilisateure,Long> {
    Utilisateure findUitlisateureByEmail(String email);

    Optional<Utilisateure> findByEmail(String email);
}
