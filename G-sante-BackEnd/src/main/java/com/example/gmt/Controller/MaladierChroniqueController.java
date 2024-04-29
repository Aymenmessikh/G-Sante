package com.example.gmt.Controller;

import com.example.gmt.Dto.AfficherMaladieChrniqueById;
import com.example.gmt.Dto.AfficherMaladieChronique;
import com.example.gmt.Dto.MaladieChroniqueDto;
import com.example.gmt.Enitity.MaladieChronique;
import com.example.gmt.Service.MaladierChroniqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/mChron")
public class MaladierChroniqueController {
    private final MaladierChroniqueService maladierChroniqueService;
    @PostMapping("/save")
    public ResponseEntity<MaladieChroniqueDto> save(@RequestBody MaladieChroniqueDto maladieChronique){
        MaladieChroniqueDto maladieChronique1=maladierChroniqueService.save(maladieChronique);
        return new ResponseEntity<>(maladieChronique1, HttpStatus.CREATED);
    }
    @PutMapping("/modifier/{id}")
    public ResponseEntity<MaladieChronique> modifier(@RequestBody MaladieChronique maladieChronique,@PathVariable Long id){
        MaladieChronique maladieChronique1=maladierChroniqueService.modifier(maladieChronique,id);
        return new ResponseEntity<>(maladieChronique1, HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<AfficherMaladieChronique>> getAll(){
        List<AfficherMaladieChronique> maladieChroniques=maladierChroniqueService.getAll();
        return new ResponseEntity<>(maladieChroniques,HttpStatus.OK);
    }
    @GetMapping("/getMaladieChroniqyeById/{id}")
    public ResponseEntity<AfficherMaladieChrniqueById> getMaladieChroniqyeById(@PathVariable Long id){
        AfficherMaladieChrniqueById maladieChroniques=maladierChroniqueService.getMaladieChroniqyeById(id);
        return new ResponseEntity<>(maladieChroniques,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        maladierChroniqueService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
