package com.example.gmt.Service;

import com.example.gmt.Enitity.Allergie;
import com.example.gmt.Repository.AllergieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AllergieService {
    private final AllergieRepository allergieRepository;
    public Allergie save(Allergie allergie){
        return allergieRepository.save(allergie);
    }
    public List<Allergie> getAll(){
        return allergieRepository.findAll();
    }
    public void  delete(Long id){
         allergieRepository.deleteById(id);
    }

    public Allergie getAllergieById(Long id) {
        return this.allergieRepository.findAllergieById(id);
    }
    public Allergie modifier(Allergie allergie, Long id) {
        Allergie allergie1=this.allergieRepository.findAllergieById(id);
        allergie1.setAllergie(allergie.getAllergie());
        allergie1.setDescription(allergie.getDescription());
        return this.allergieRepository.save(allergie1);
    }
}