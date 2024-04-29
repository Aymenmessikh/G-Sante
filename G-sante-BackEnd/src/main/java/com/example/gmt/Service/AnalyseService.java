package com.example.gmt.Service;

import com.example.gmt.Dto.*;
import com.example.gmt.Enitity.*;
import com.example.gmt.Repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class AnalyseService {
    @Autowired
    private final AnalyseRepository analyseRepository;
    @Autowired
    private final EmployerRespository employerRespository;
    @Autowired
    private final PostRepository postRepository;
    @Autowired
    private final RisqueRepository risqueRepository;
    @Autowired
    private final PeriodiciteRisqueRepository periodiciteRisqueRepository;
    @Autowired
    private final  PeriodicteMaladieChroniqueRepository periodicteMaladieChroniqueRepository;
    @Autowired
    private final MalladieChroniqueRepository malladieChroniqueRepository;

    public ControlleMedicalDto save(ControlleMedicalDto controlleMedicalDto){
            analyseRepository.save(ControlleMedicalDto.DtoToEntity(controlleMedicalDto));
        return controlleMedicalDto;
    }
    public ControlleMedicalDto Modifier(ControlleMedicalDto controlleMedicalDto, Long id){
        ControleMedical controleMedical =analyseRepository.findControleMedicalByIdControle(id);
        controleMedical.setControle(controleMedical.getControle());
        controleMedical.setTypeControle(controleMedical.getTypeControle());
        controleMedical.setDescription(controlleMedicalDto.getDescription());
        analyseRepository.save(controleMedical);
        return controlleMedicalDto;
    }
    public List<AfficherControlleMedicale> getAllAnalyse(){
        return analyseRepository.findAll().stream().map(AfficherControlleMedicale::DtoFromEntity).collect(Collectors.toList());
    }
    public void delete(Long id){
        analyseRepository.deleteById(id);
    }
    public AfficherControlleMedicale getAnalyseBYId(Long id){
        ControleMedical controleMedical =analyseRepository.findControleMedicalByIdControle(id);
        return AfficherControlleMedicale.DtoFromEntity(controleMedical);
    }
    public List<AfficherControleByRisque> getAnalyseBYRisque(String code){
        Employe employe = employerRespository.findEmployeByMatricule(code);
        Post post = postRepository.findPostByEmployes(employe);
        List<Risque> risques = risqueRepository.findAllByPosts(post);

        List<PeriodiciteRisque> periodiciteRisqueList = risques.stream()
                .flatMap(risque -> periodiciteRisqueRepository.findAllByRisques(risque).stream())
                .collect(Collectors.toList());

        return periodiciteRisqueList.stream().map(this::DtoFromEntity).collect(Collectors.toList());
    }
    public AfficherControleByRisque DtoFromEntity(PeriodiciteRisque periodiciteRisque){
        return AfficherControleByRisque.builder()
                .risque(periodiciteRisque.getRisques().getRisque())
                .idPeriodicite(periodiciteRisque.getIdPeriodicite())
                .typeControle(periodiciteRisque.getControleMedical().getTypeControle())
                .periodicte(periodiciteRisque.getPeriodicite())
                .controle(periodiciteRisque.getControleMedical().getControle())
                .build();
    }
    public List<AfficheControleByMaladieChronique> getAnalyseByMaladiesChronique(List<Long> ids) {
        List<MaladieChronique> maladiesChroniques = malladieChroniqueRepository.findAllByIdIn(ids);
        List<AfficheControleByMaladieChronique> result = new ArrayList<>();

        for (MaladieChronique maladieChronique : maladiesChroniques) {
            List<PeriodiciteMaladieChronique> periodiciteMaladieChroniques = periodicteMaladieChroniqueRepository
                    .findAllByMaladieChronique(maladieChronique);
            result.addAll(periodiciteMaladieChroniques.stream().map(this::EntityToDto).collect(Collectors.toList()));
        }

        return result;
    }

    public AfficheControleByMaladieChronique EntityToDto(PeriodiciteMaladieChronique periodiciteMaladieChronique){
        return AfficheControleByMaladieChronique.builder()
                .maladieChronique(periodiciteMaladieChronique.getMaladieChronique().getMalladieChronique())
                .controle(periodiciteMaladieChronique.getControleMedical().getControle())
                .typeControle(periodiciteMaladieChronique.getControleMedical().getTypeControle())
                .id(periodiciteMaladieChronique.getIdPeriodicite())
                .periodicte(periodiciteMaladieChronique.getPeriodicite())
                .build();
    }
}
