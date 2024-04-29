package com.example.gmt.Repository;

import com.example.gmt.Dto.NombreConsultationParMois;
import com.example.gmt.Enitity.Consultation;
import com.example.gmt.Enitity.Employe;
import com.example.gmt.Enitity.TypeConsultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
    List<Consultation> findAllByEmployeAndTypeConsultations(Employe employe,TypeConsultation typeConsultation);

    List<Consultation> findAllByTypeConsultations(TypeConsultation typeConsultation);

    Consultation findConsultationByIdConsultation(Long id);
    @Query("SELECT MONTH(c.dateConsultation) AS moisDeConsultation, COUNT(c.idConsultation) AS nombreDeConsultation FROM Consultation c GROUP BY moisDeConsultation")
    List<Object[]> findAllConsultationParMois();
}
