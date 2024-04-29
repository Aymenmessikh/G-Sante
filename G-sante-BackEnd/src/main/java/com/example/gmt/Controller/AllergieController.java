package com.example.gmt.Controller;

import com.example.gmt.Enitity.Allergie;
import com.example.gmt.Service.AllergieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/allergie")
public class AllergieController {
    private final AllergieService allergieService;
    @PostMapping("/save")
    public ResponseEntity<Allergie> save(@RequestBody Allergie allergie){
        Allergie allergie1=allergieService.save(allergie);
        return new ResponseEntity<>(allergie1, HttpStatus.CREATED);
    }
    @PutMapping("/modifier/{id}")
    public ResponseEntity<Allergie> modifier(@RequestBody Allergie allergie,@PathVariable Long id){
        Allergie allergie1=allergieService.modifier(allergie,id);
        return new ResponseEntity<>(allergie1, HttpStatus.CREATED);
    }
    @GetMapping("getAll")
    public ResponseEntity<List<Allergie>> getAll(){
        List<Allergie> allergies=allergieService.getAll();
        return new ResponseEntity<>(allergies,HttpStatus.OK);
    }
    @GetMapping("getAllergieById/{id}")
    public ResponseEntity<Allergie> getAllergieById(@PathVariable Long id){
        Allergie allergies=allergieService.getAllergieById(id);
        return new ResponseEntity<>(allergies,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        allergieService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
