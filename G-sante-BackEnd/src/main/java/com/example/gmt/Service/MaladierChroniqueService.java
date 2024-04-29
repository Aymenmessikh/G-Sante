package com.example.gmt.Service;

import com.example.gmt.Dto.*;
import com.example.gmt.Enitity.ControleMedical;
import com.example.gmt.Enitity.MaladieChronique;
import com.example.gmt.Enitity.PeriodiciteMaladieChronique;
import com.example.gmt.Repository.AnalyseRepository;
import com.example.gmt.Repository.MalladieChroniqueRepository;
import com.example.gmt.Repository.PeriodicteMaladieChroniqueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MaladierChroniqueService {
    private final MalladieChroniqueRepository malladieChroniqueRepository;
    private final PeriodicteMaladieChroniqueRepository periodicteMaladieChroniqueRepository;
    private final AnalyseRepository analyseRepository;
    public MaladieChroniqueDto save(MaladieChroniqueDto maladieChroniqueDto){
        MaladieChronique maladieChronique=malladieChroniqueRepository.save(EntityFromDto(maladieChroniqueDto));
        List<PeriodiciteMaladieChronique> periodiciteMaladieChroniques=maladieChroniqueDto.getPeriodiciteMaladieChroniqueDtos().stream().map(Dto->{
            PeriodiciteMaladieChronique periodiciteMaladieChronique=EntityFromDto(Dto);
            periodiciteMaladieChronique.setMaladieChronique(maladieChronique);
            return periodiciteMaladieChronique;
        }).collect(Collectors.toList());
        periodicteMaladieChroniqueRepository.saveAll(periodiciteMaladieChroniques);
        return maladieChroniqueDto;
    }
    public List<AfficherMaladieChronique> getAll(){
        return malladieChroniqueRepository.findAll().stream()
                .map(AfficherMaladieChronique::EntityToDto).collect(Collectors.toList());
    }
    public void  delete(Long id){
        malladieChroniqueRepository.deleteById(id);
    }

    public AfficherMaladieChrniqueById getMaladieChroniqyeById(Long id) {
        MaladieChronique maladieChronique=malladieChroniqueRepository.findMaladieChroniqueById(id);
        AfficherMaladieChrniqueById afficherMaladieChrniqueById= AfficherMaladieChrniqueById
                .EntityToDto(maladieChronique);
        afficherMaladieChrniqueById.setPeriodiciteMaladieChroniqueDtos(maladieChronique.getPeriodiciteMaladieChroniques()
                .stream().map(this::DtoFromEntity).collect(Collectors.toList()));
        return afficherMaladieChrniqueById;
    }

    public MaladieChronique modifier(MaladieChronique maladieChronique, Long id) {
        MaladieChronique maladieChronique1=this.malladieChroniqueRepository.findMaladieChroniqueById(id);
        maladieChronique1.setMalladieChronique(maladieChronique.getMalladieChronique());
        maladieChronique1.setDescription(maladieChronique.getDescription());
        return this.malladieChroniqueRepository.save(maladieChronique1);
    }
    public MaladieChronique EntityFromDto(MaladieChroniqueDto maladieChroniqueDto){
        return MaladieChronique.builder()
                .malladieChronique(maladieChroniqueDto.getMalladieChronique())
                .description(maladieChroniqueDto.getDescription())
                .build();
    }
    public PeriodiciteMaladieChronique EntityFromDto(PeriodiciteMaladieChroniqueDto periodiciteMaladieChroniqueDto){
        ControleMedical controleMedical=analyseRepository
                .findControleMedicalByControle(periodiciteMaladieChroniqueDto.getControleMedicale());
        return PeriodiciteMaladieChronique.builder()
                .periodicite(periodiciteMaladieChroniqueDto.getPeriodicite())
                .controleMedical(controleMedical)
                .build();
    }
    public PeriodiciteMaladieChroniqueDto DtoFromEntity(PeriodiciteMaladieChronique periodiciteMaladieChronique){
        return PeriodiciteMaladieChroniqueDto.builder()
                .idPeriodicite(periodiciteMaladieChronique.getIdPeriodicite())
                .periodicite(periodiciteMaladieChronique.getPeriodicite())
                .afficherControlleMedicale(AfficherControlleMedicale
                        .DtoFromEntity(periodiciteMaladieChronique.getControleMedical()))
                .build();
    }
}
