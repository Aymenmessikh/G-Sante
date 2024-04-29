package com.example.gmt.Service;

import com.example.gmt.Dto.MaladiesChroniquePlusCourant;
import com.example.gmt.Dto.NombreConsultationParMois;
import com.example.gmt.Repository.ConsultationRepository;
import com.example.gmt.Repository.DossierMedicalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnalyticsService {

    private final ConsultationRepository consultationRepository;
    private final DossierMedicalRepository dossierMedicalRepository;

    public List<NombreConsultationParMois> finsAllConsultationParMois() {
        List<Object[]> results = consultationRepository.findAllConsultationParMois();

        List<NombreConsultationParMois> consultationsParMois = results.stream()
                .map(result -> new NombreConsultationParMois(Month.of((int) result[0]), (Long) result[1]))
                .sorted(Comparator.comparingInt(result -> result.getMoisDeConsultation().getValue()))
                .collect(Collectors.toList());

        return consultationsParMois;
    }
    public List<MaladiesChroniquePlusCourant> getMaladiesChroniquePlusCourant(){
        List<Object[]> results = dossierMedicalRepository.getMaladiesChroniquePlusCourant();
        List<MaladiesChroniquePlusCourant> dtos = new ArrayList<>();
        for (Object[] result : results) {
            MaladiesChroniquePlusCourant dto = new MaladiesChroniquePlusCourant();
            dto.setMaladiesChronique((String) result[0]);
            dto.setNombreMaladies((Long) result[1]);
            dtos.add(dto);
        }
        return dtos;

    }
}

