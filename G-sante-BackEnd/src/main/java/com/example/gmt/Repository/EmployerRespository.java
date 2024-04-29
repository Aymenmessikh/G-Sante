package com.example.gmt.Repository;

import com.example.gmt.Enitity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployerRespository extends JpaRepository<Employe,Long> {
    Employe findEmployeByMatricule(String matricule);
    @Query("SELECT MAX(id) FROM Employe")
    Long findMaxId();
    @Query("SELECT COUNT(id) FROM Employe")
    Long nombreEmployer();

    Employe findEmployeById(Long id);
}
