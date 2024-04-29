package com.example.gmt.Controller;

import com.example.gmt.Dto.MaladiesChroniquePlusCourant;
import com.example.gmt.Dto.NombreConsultationParMois;
import com.example.gmt.Service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("analytics")
@RequiredArgsConstructor
public class AnalyticsController {
    private final AnalyticsService analyticsService;
    @GetMapping("/getNombreConsultationParMois")
    public ResponseEntity<List<NombreConsultationParMois>> getAllConsulattionParMois(){
        List<NombreConsultationParMois> nombreConsultationParMois=analyticsService.finsAllConsultationParMois();
        return new ResponseEntity<>(nombreConsultationParMois, HttpStatus.OK);
    }
    @GetMapping("/getMaladieChroniquePlusCourant")
    public ResponseEntity<List<MaladiesChroniquePlusCourant>> getMaladiesPlusCourant(){
        List<MaladiesChroniquePlusCourant> maladiesChroniquePlusCourants =analyticsService.getMaladiesChroniquePlusCourant();
        return new ResponseEntity<>(maladiesChroniquePlusCourants, HttpStatus.OK);
    }
}
