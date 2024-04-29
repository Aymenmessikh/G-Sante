package com.example.gmt.Controller;

import com.example.gmt.Dto.AjouterFichierMedicalDto;
import com.example.gmt.Dto.FichierMedcialDto;
import com.example.gmt.Enitity.FichierMedical;
import com.example.gmt.Service.DossierMedicalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Dossier")
@RequiredArgsConstructor
public class DossierMedicalController {
    @Autowired
    private final DossierMedicalService dossierMedicalService;
    @PostMapping("/save/{code}")
    public ResponseEntity<AjouterFichierMedicalDto> save(@RequestBody AjouterFichierMedicalDto dossierMedical, @PathVariable("code") String code){
        AjouterFichierMedicalDto e=dossierMedicalService.save(dossierMedical,code);
        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }
    @PutMapping("/modifier/{code}")
    public ResponseEntity<FichierMedical> Modifier(@RequestBody FichierMedical dossierMedical, @PathVariable("code") String code){
        FichierMedical dossierMedical1=dossierMedicalService.Modifier(dossierMedical,code);
        return new ResponseEntity<>(dossierMedical1, HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<FichierMedical>> gatAllDossierr(){
        List<FichierMedical> dossierMedicals=dossierMedicalService.getAllDossier();
        return new ResponseEntity<>(dossierMedicals, HttpStatus.OK);
    }
    @GetMapping("/getbyCode/{code}")
    public ResponseEntity<FichierMedcialDto> gatDossierBycode(@PathVariable("code") String code){
        FichierMedcialDto dossierMedical=dossierMedicalService.getDossierByCode(code);
        return new ResponseEntity<>(dossierMedical,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDossier(@PathVariable("id") Long id){
        dossierMedicalService.deleteDossier(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
