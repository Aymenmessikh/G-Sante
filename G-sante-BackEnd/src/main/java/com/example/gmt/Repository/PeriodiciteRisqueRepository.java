package com.example.gmt.Repository;

import com.example.gmt.Enitity.PeriodiciteRisque;
import com.example.gmt.Enitity.Risque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeriodiciteRisqueRepository extends JpaRepository<PeriodiciteRisque,Long> {
    List<PeriodiciteRisque> findAllByRisques(Risque risque);
}
