package com.example.gmt.Controller;

import com.example.gmt.Dto.*;
import com.example.gmt.Service.VissiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visite")
@RequiredArgsConstructor
public class vissiteController {
        @Autowired
        private final VissiterService vissiteService;
        @PostMapping(value = "/save/{code}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<VisiteDto> save(@RequestBody VisiteDto vissite, @PathVariable("code") String code){
            VisiteDto vissite1=vissiteService.save(vissite,code);
            return new ResponseEntity<>(vissite1, HttpStatus.CREATED);
        }
        @PutMapping("/update/{id}")
        public ResponseEntity<VisiteDto> Modifier(@RequestBody VisiteDto vissite,@PathVariable("id") Long id_Employer){
            VisiteDto vissite1=vissiteService.Modifier(vissite,id_Employer);
            return new ResponseEntity<>(vissite1, HttpStatus.CREATED);
        }
        @GetMapping("/getAll")
        public ResponseEntity<List<AfficherVisite>> gatAllEmployer(){
            List<AfficherVisite> vissites=vissiteService.getAllVissite();
            return new ResponseEntity<>(vissites, HttpStatus.OK);
        }
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> deleteVisite(@PathVariable("id") Long id){
            vissiteService.deleteVissite(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        @GetMapping(value = "/getByEmp/{code}",produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<AfficherVisiteByEmploye>> getVisitByEmployer(@PathVariable("code") String code){
            List<AfficherVisiteByEmploye> vissites=vissiteService.getVissitebyEmloyer(code);
            return new ResponseEntity<>(vissites,HttpStatus.OK);
        }
        @GetMapping(value = "/get/{code}",produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<AfficherControleByFicheMedicale>> getAnalyseByEmployer(@PathVariable("code") String code){
           List<AfficherControleByFicheMedicale> analyseMedicals=vissiteService.appele(code);
            return new ResponseEntity<>(analyseMedicals,HttpStatus.OK);
        }
        @GetMapping(value = "/getAnalyseById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<AfficherControlleMedicale> getAnalyseById(@PathVariable("id") Long id){
           AfficherControlleMedicale analyseMedicals=vissiteService.getAnnalyseById(id);
            return new ResponseEntity<>(analyseMedicals,HttpStatus.OK);
        }
        @GetMapping(value = "getVisiteById/{id}")
        public ResponseEntity<AfficherVisiteByEmploye> getVisitById(@PathVariable Long id){
            AfficherVisiteByEmploye visite=vissiteService.getVisiteById(id);
            return new ResponseEntity<>(visite,HttpStatus.OK);
        }
}
