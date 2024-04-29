package com.example.gmt.Controller;

import com.example.gmt.Dto.MaladierDto;
import com.example.gmt.Service.MaladieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/maladie")
public class MaladieController {
    private final MaladieService maladieService;
    @GetMapping("/getById/{id}")
    public ResponseEntity<MaladierDto> getMaladieById(@PathVariable Long id){
        MaladierDto maladierDto=maladieService.getMaladieById(id);
        return new ResponseEntity<>(maladierDto, HttpStatus.OK);
    }
}
