package com.example.gmt.Controller;

import com.example.gmt.Dto.AfficherEmp;
import com.example.gmt.Dto.EmployeDto;
import com.example.gmt.Dto.ModifierEmploye;
import com.example.gmt.Service.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Emp")
@RequiredArgsConstructor
public class EmployerController {
    @Autowired
    private final EmployerService employerService;
    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeDto> saveEmployer(@RequestBody EmployeDto employe){
        EmployeDto employe1=employerService.Save(employe);
        return new ResponseEntity<>(employe1, HttpStatus.CREATED);
    }
    @PutMapping("/update/{code}")
    public ResponseEntity<ModifierEmploye> ModifierEmployer(@RequestBody ModifierEmploye employer, @PathVariable("code") String code){
        ModifierEmploye employer1=employerService.Modifier(employer,code);
        return new ResponseEntity<>(employer1, HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<AfficherEmp>> gatAllEmployer(){
        List<AfficherEmp> employers=employerService.getAllEmloyer();
        return new ResponseEntity<>(employers, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> gatAllEmployer(@PathVariable("id") Long id){
        employerService.deleteEmployer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/getbyCode/{code}")
    public ResponseEntity<AfficherEmp> gatEmployeBycode(@PathVariable("code") String code){
        AfficherEmp employer=employerService.getEmpByCode(code);
        return new ResponseEntity<>(employer,HttpStatus.OK);
    }
}
