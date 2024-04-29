package com.example.gmt.Repository;

import com.example.gmt.Enitity.Allergie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AllergieRepository extends JpaRepository<Allergie,Long> {
    Allergie findAllergieById(Long id);
}
