package com.example.gmt.Repository;
import com.example.gmt.Enitity.MaladieChronique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MalladieChroniqueRepository extends JpaRepository<MaladieChronique,Long> {
    MaladieChronique findMaladieChroniqueById(Long id);
    List<MaladieChronique> findAllByIdIn(List<Long> id);
}
