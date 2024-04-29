package com.example.gmt.Controller;

import com.example.gmt.Enitity.Vaccins;
import com.example.gmt.Service.VacssinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacssin")
@RequiredArgsConstructor
public class VaccssinController {
    private final VacssinService vacssinService;
    @PostMapping("/save")
    public ResponseEntity<Vaccins> save(@RequestBody Vaccins vaccins){
        Vaccins vaccins1=vacssinService.save(vaccins);
        return new ResponseEntity<>(vaccins1, HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Vaccins>> getAll(){
        List<Vaccins> vaccins=vacssinService.getAll();
        return new ResponseEntity<>(vaccins,HttpStatus.OK);
    }
    @PutMapping("modifier/{id}")
    public ResponseEntity<Vaccins> Modifier(@PathVariable Long id,@RequestBody Vaccins vaccins1){
         Vaccins vaccins=vacssinService.modifier(vaccins1,id);
        return new ResponseEntity<>(vaccins,HttpStatus.OK);
    }
    @GetMapping("/getVaccinById/{id}")
    public ResponseEntity<Vaccins> getVaccinById(@PathVariable Long id){
        Vaccins vaccins=vacssinService.getVaccinById(id);
        return new ResponseEntity<>(vaccins,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        vacssinService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
