package com.example.gmt.Repository;

import com.example.gmt.Enitity.ResultatControlleMedicale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultatControlleMedicaleRepository extends JpaRepository<ResultatControlleMedicale,Long> {
}
