package com.example.gmt.Repository;

import com.example.gmt.Enitity.Maladie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaladieRepository extends JpaRepository<Maladie,Long> {
    Maladie findMaladieByIdMaladie(Long id);
}
