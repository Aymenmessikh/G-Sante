package com.example.gmt.Repository;

import com.example.gmt.Enitity.MaladieChronique;
import com.example.gmt.Enitity.PeriodiciteMaladieChronique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeriodicteMaladieChroniqueRepository extends JpaRepository<PeriodiciteMaladieChronique,Long> {
    List<PeriodiciteMaladieChronique> findAllByMaladieChronique(MaladieChronique maladieChronique);
    List<PeriodiciteMaladieChronique> findAllByMaladieChroniqueIn(List<MaladieChronique> maladieChronique);
}
