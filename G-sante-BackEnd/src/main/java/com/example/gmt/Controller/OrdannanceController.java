package com.example.gmt.Controller;

import com.example.gmt.Dto.OrdananceDto;
import com.example.gmt.Service.OrdannanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ordannance")
public class OrdannanceController {
    private final OrdannanceService ordannanceService;
    @GetMapping("/getById/{id}")
    public ResponseEntity<OrdananceDto> getMaladieById(@PathVariable Long id){
        OrdananceDto ordananceDto =ordannanceService.getOrdannanceById(id);
        return new ResponseEntity<>(ordananceDto, HttpStatus.OK);
    }
}
