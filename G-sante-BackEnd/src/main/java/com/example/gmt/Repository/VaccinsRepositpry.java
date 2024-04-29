package com.example.gmt.Repository;

import com.example.gmt.Enitity.Vaccins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface VaccinsRepositpry extends JpaRepository<Vaccins,Long> {
    Vaccins findVaccinsById(Long id);

}
