package com.example.gmt.Controller;

import com.example.gmt.Dto.*;
import com.example.gmt.Service.ConsultationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cons")
@RequiredArgsConstructor
public class ConsultationController {
    @Autowired
    private final ConsultationService consultationService;
    @PostMapping("/save/{code}")
    public ResponseEntity<ConsultationDto> save(@RequestBody ConsultationDto consultationDto, @PathVariable String code){
        ConsultationDto consultationDto1=consultationService.save(consultationDto,code);
        return new ResponseEntity<>(consultationDto1, HttpStatus.CREATED);
    }
    @GetMapping("/getAllConsultation")
    public ResponseEntity<List<AfficherAllConultation>> gatAllConsultation(){
        List<AfficherAllConultation> consultations=consultationService.getAllConsultation();
        return new ResponseEntity<>(consultations, HttpStatus.OK);
    }
    @GetMapping("/getAllIntervention")
    public ResponseEntity<List<AfficherAllIntervention>> gatAllIntervention(){
        List<AfficherAllIntervention> consultations=consultationService.getAllIntervention();
        return new ResponseEntity<>(consultations, HttpStatus.OK);
    }
    @GetMapping("/getConsultationById/{id}")
    public ResponseEntity<AfficherConsulationById> gatConsultationById(@PathVariable Long id){
        AfficherConsulationById consultation=consultationService.getConsultationById(id);
        return new ResponseEntity<>(consultation, HttpStatus.OK);

    }
    @GetMapping("/getInterventionById/{id}")
    public ResponseEntity<AfficherInterventionById> gatInterventionById(@PathVariable Long id){
        AfficherInterventionById consultation=consultationService.getInterventionById(id);
        return new ResponseEntity<>(consultation, HttpStatus.OK);
    }
    @GetMapping("/getConsultationbyCodeEmp/{code}")
    public ResponseEntity<List<AfficherAllConultation>> getConsultationByEmploye(@PathVariable("code") String code){
        List<AfficherAllConultation> consultations=consultationService.getConsultationByEmployer(code);
        return new ResponseEntity<>(consultations,HttpStatus.OK);
    }
    @GetMapping("/getIntreventionbyCodeEmp/{code}")
    public ResponseEntity<List<AfficherAllIntervention>> getInterventionByEmploye(@PathVariable("code") String code){
        List<AfficherAllIntervention> consultations=consultationService.getInterventionByEmployer(code);
        return new ResponseEntity<>(consultations,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDossier(@PathVariable("id") Long id){
        consultationService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
