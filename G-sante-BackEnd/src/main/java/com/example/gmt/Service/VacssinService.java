package com.example.gmt.Service;

import com.example.gmt.Enitity.Vaccins;
import com.example.gmt.Repository.VaccinsRepositpry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class VacssinService {
    private final VaccinsRepositpry vaccinsRepositpry;
    public Vaccins save(Vaccins vaccins){

        return vaccinsRepositpry.save(vaccins);
    }
    public List<Vaccins> getAll(){
        return vaccinsRepositpry.findAll();
    }
    public void  delete(Long id){
       vaccinsRepositpry.deleteById(id);
    }

    public Vaccins getVaccinById(Long id) {
        return this.vaccinsRepositpry.findVaccinsById(id);
    }

    public Vaccins modifier(Vaccins vaccins ,Long id) {
        Vaccins vaccins1=this.vaccinsRepositpry.findVaccinsById(id);
        vaccins1.setVaccin(vaccins.getVaccin());
        vaccins1.setDescription(vaccins.getDescription());
        return this.vaccinsRepositpry.save(vaccins1);
    }
}
