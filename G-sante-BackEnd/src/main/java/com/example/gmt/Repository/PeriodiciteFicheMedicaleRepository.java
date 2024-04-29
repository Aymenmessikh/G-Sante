package com.example.gmt.Repository;

import com.example.gmt.Enitity.FichierMedical;
import com.example.gmt.Enitity.PeriodiciteFicheMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeriodiciteFicheMedicaleRepository extends JpaRepository<PeriodiciteFicheMedical,Long> {
    List<PeriodiciteFicheMedical> findAllByFichierMedical(FichierMedical fichierMedical);
}
