package com.example.gmt.Controller;

import com.example.gmt.Dto.*;
import com.example.gmt.Enitity.PeriodiciteRisque;
import com.example.gmt.Service.AnalyseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("analyse")
public class AnalyseController {
    @Autowired
    private final AnalyseService analyseService;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ControlleMedicalDto> save(@RequestBody ControlleMedicalDto controlleMedicalDto) {
        ControlleMedicalDto controlleMedicalDto1 = analyseService.save(controlleMedicalDto);
        return new ResponseEntity<>(controlleMedicalDto1, HttpStatus.CREATED);
    }
    @PutMapping(value = "/modifier/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ControlleMedicalDto> Modifier(@RequestBody ControlleMedicalDto controlleMedicalDto, @PathVariable Long id) {
        ControlleMedicalDto controlleMedicalDto1 = analyseService.Modifier(controlleMedicalDto,id);
        return new ResponseEntity<>(controlleMedicalDto1, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AfficherControlleMedicale>> getAll() {
        List<AfficherControlleMedicale> analyses = analyseService.getAllAnalyse();
        return new ResponseEntity<>(analyses, HttpStatus.OK);
    }
    @GetMapping("/getAnalyseByRisque/{code}")
    public ResponseEntity<List<AfficherControleByRisque>> getAnalyseByRisque(@PathVariable String code) {
        List<AfficherControleByRisque> analyses = analyseService.getAnalyseBYRisque(code);
        return new ResponseEntity<>(analyses, HttpStatus.OK);
    }
    @GetMapping("/getAnalyseByMaladieChronique/{id}")
    public ResponseEntity<List<AfficheControleByMaladieChronique>> getAnalyseByRisque(@PathVariable List<Long> id) {
        List<AfficheControleByMaladieChronique> analyses = analyseService.getAnalyseByMaladiesChronique(id);
        return new ResponseEntity<>(analyses, HttpStatus.OK);
    }
    @GetMapping("/getAnalyseById/{id}")
    public ResponseEntity<AfficherControlleMedicale> getAnalyseByid(@PathVariable Long id) {
        AfficherControlleMedicale analyse = analyseService.getAnalyseBYId(id);
        return new ResponseEntity<>(analyse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        analyseService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
