package com.example.gmt.Repository;

import com.example.gmt.Enitity.ControleMedical;
import com.example.gmt.Enitity.Risque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AnalyseRepository extends JpaRepository<ControleMedical,Long> {
    ControleMedical findControleMedicalByIdControle(Long id);

    ControleMedical findControleMedicalByControle(String controleMedicale);

    //List<ControleMedical> findAllByRisques(Risque risque);
}
