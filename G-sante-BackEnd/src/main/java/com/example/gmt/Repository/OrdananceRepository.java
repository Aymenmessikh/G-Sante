package com.example.gmt.Repository;

import com.example.gmt.Enitity.Ordananace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdananceRepository extends JpaRepository<Ordananace,Long> {
    Ordananace findOrdananaceByIdOrdanance(Long id);
}
