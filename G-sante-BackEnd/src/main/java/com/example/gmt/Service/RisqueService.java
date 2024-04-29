package com.example.gmt.Service;

import com.example.gmt.Dto.*;
import com.example.gmt.Enitity.ControleMedical;
import com.example.gmt.Enitity.PeriodiciteRisque;
import com.example.gmt.Enitity.Risque;
import com.example.gmt.Repository.AnalyseRepository;
import com.example.gmt.Repository.PeriodiciteRisqueRepository;
import com.example.gmt.Repository.RisqueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class RisqueService {
    @Autowired
    private final RisqueRepository risqueRepository;
    @Autowired
    private final AnalyseRepository analyseRepository;
    @Autowired
    private final PeriodiciteRisqueRepository periodiciteRisqueRepository;
    public RisqueDto save(RisqueDto risqueDto) {
        Risque risque = risqueRepository.save(EntityFromDto(risqueDto));
        List<PeriodiciteRisque> periodiciteRisques = risqueDto.getPeriodiciteRisqueDtos().stream()
                .map(dto -> {
                    PeriodiciteRisque entity = DtoToEntity(dto);
                    entity.setRisques(risque);
                    return entity;
                })
                .collect(Collectors.toList());
        periodiciteRisques = periodiciteRisqueRepository.saveAll(periodiciteRisques);
        return risqueDto;
    }
    public List<AfficherAllRisque> gatAllRisque(){
        List<Risque> risques=risqueRepository.findAll();

        List<AfficherAllRisque> afficherAllRisques=risques
                .stream().map(this::EntityToDto)
                .collect(Collectors.toList());
        return afficherAllRisques;
    }
    public void delete(Long id){
        risqueRepository.deleteById(id);
    }

    public AfficherRisqueById getRisqueById(Long id) {
        Risque risque=risqueRepository.findRisqueById(id);
        AfficherRisqueById risque1=AfficherRisqueById.EntityToDto(risque);
        List<PeriodiciteRisqueDto> periodiciteRisqueDtos=risque.getPeriodiciteRisque().stream()
                .map(this::DtoFromEntity).collect(Collectors.toList());
        risque1.setPeriodiciteRisqueDtos(periodiciteRisqueDtos);
        return risque1;
    }

    public RisqueDto modifier(RisqueDto risqueDto, Long id) {
        Risque risque=risqueRepository.findRisqueById(id);
        risque.setRisque(risqueDto.getRisque());
        risque.setDescription(risqueDto.getDescription());
      //  List<ControleMedical> analyses = risqueDto.getIdAnalyse().stream()
              //  .map(idAnalyse -> analyseRepository.findControleMedicalByIdControle(id))
                //.collect(Collectors.toList());
       // risque.setAnalyses(analyses);
         risqueRepository.save(risque);
         return risqueDto;
    }
    public Risque EntityFromDto(RisqueDto risqueDto){
//        List<Long> idControleMedicales = risqueDto.getPeriodiciteRisqueDtos().stream()
//                .map(periodiciteRisque -> periodiciteRisque.getIdControleMedicale()).collect(Collectors.toList());
//        List<PeriodiciteRisque> periodiciteRisques=risqueDto.getPeriodiciteRisqueDtos()
//                .stream().map(periodiciteRisqueDto -> DtoToEnity(periodiciteRisqueDto)).collect(Collectors.toList());
        return Risque.builder()
                .risque(risqueDto.getRisque())
//                .periodiciteRisque(periodiciteRisques)
                .description(risqueDto.getDescription())
                .build();
    }
    public PeriodiciteRisque DtoToEntity(PeriodiciteRisqueDto periodiciteRisqueDto){
        ControleMedical controleMedicals=analyseRepository
                .findControleMedicalByControle(periodiciteRisqueDto.getControleMedicale());
        return PeriodiciteRisque.builder()
                .periodicite(periodiciteRisqueDto.getPeriodicite())
                .controleMedical(controleMedicals)
                .build();
    }
    public PeriodiciteRisqueDto DtoFromEntity(PeriodiciteRisque periodiciteRisque){
        return PeriodiciteRisqueDto.builder()
                .idPeriodicite(periodiciteRisque.getIdPeriodicite())
                .periodicite(periodiciteRisque.getPeriodicite())
                .afficherControlleMedicale(AfficherControlleMedicale.DtoFromEntity(periodiciteRisque.getControleMedical()))
                .build();
    }
    public AfficherAllRisque EntityToDto(Risque risque){
//        List<PeriodiciteRisque> periodiciteRisques=risque.getPeriodiciteRisque();
//       List<PeriodiciteRisqueDto> periodiciteRisqueDtos= periodiciteRisques.stream()
//               .map(this::DtoFromEntity).collect(Collectors.toList());
        return AfficherAllRisque.builder()
                .risque(risque.getRisque())
                .id(risque.getId())
//                .periodiciteRisqueDtos(periodiciteRisqueDtos)
                .description(risque.getDescription())
                .build();
    }
}
