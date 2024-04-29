package com.example.gmt.Service;

import com.example.gmt.Dto.*;
import com.example.gmt.Enitity.*;
import com.example.gmt.Repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class VissiterService {
    @Autowired
    private final VissiteRepository vissiteRepository;
    @Autowired
    private final EmployerRespository employerRespository;
    @Autowired
    private final DossierMedicalRepository dossierMedicalRepository;
    @Autowired
    private final PostRepository postRepository;
    @Autowired
    private final RisqueRepository risqueRepository;
    @Autowired
    private final AnalyseRepository analyseRepository;
    @Autowired
    private final VisiteEmbaucheRepository visiteEmbaucheRepository;
    @Autowired
    private final ResultatControlleMedicaleRepository resultatControlleMedicaleRepository;
    @Autowired
    private final PeriodiciteFicheMedicaleRepository periodiciteFicheMedicaleRepository;
    @Autowired
    private ModelMapper modelMapper;
    private VisiteDto VisitetoDto(Vissite vissite) {
       VisiteDto visiteDto=new VisiteDto();
       return visiteDto=modelMapper.map(vissite,VisiteDto.class);
    }
    public VisiteDto save(VisiteDto vissite,String code){
            Employe employe = employerRespository.findEmployeByMatricule(code);
            FichierMedical dossierMedical = dossierMedicalRepository.findFichierMedicalByEmploye(employe);

            Vissite vissite1= EntityFromDto(vissite);
            vissite1.setEmploye(employe);
            dossierMedical.setTaille(vissite.getTaille());
            dossierMedical.setPoid(vissite.getPoids() );
            vissite1.setFichierMedical(dossierMedical);
            vissite1.setTypeVisite("Vissite Periodique");
            vissiteRepository.save(vissite1);
            dossierMedicalRepository.save(dossierMedical);
          if (!vissite.getResultatsControleMedicaleDto().isEmpty()){
              List<ResultatControlleMedicale> resultatControlleMedicales=vissite.getResultatsControleMedicaleDto()
                      .stream().map(dto->{
                          ResultatControlleMedicale resultatControlleMedicale1=EnityFromDto(dto);
                          resultatControlleMedicale1.setVissite(vissite1);
                          return resultatControlleMedicale1;
                      }).collect(Collectors.toList());
              resultatControlleMedicaleRepository.saveAll(resultatControlleMedicales);
          }
           // dossierMedical.setDatederniereVisit(vissite1.getDate_Visite());
           // dossierMedical.setDateProchaineVisit(vissite1.getDate_Visite().plusMonths(employer.getPost().getPeriodicite()));
        return vissite;
    }
    public List<AfficherControleByFicheMedicale> appele(String code) {
        Employe employe = employerRespository.findEmployeByMatricule(code);
        FichierMedical fichierMedical=dossierMedicalRepository.findFichierMedicalByEmploye(employe);
        List<PeriodiciteFicheMedical> periodiciteFicheMedical=periodiciteFicheMedicaleRepository.findAllByFichierMedical(fichierMedical);
        List<AfficherControleByFicheMedicale> afficherControleByFicheMedicale=periodiciteFicheMedical
                .stream().map(AfficherControleByFicheMedicale::DtoFromEntity).collect(Collectors.toList());

        return afficherControleByFicheMedicale;
    }

    public VisiteDto Modifier(VisiteDto vissite,Long id){
        Vissite vissite1=vissiteRepository.findVissiteById(id);
        vissite1.setDescription(vissite.getDescription());
        vissite1.setDiagnostic(vissite.getDiagnostic());
        vissite1.setResultats(vissite.getResultats());
        vissite1.setTaille(vissite.getTaille());
        vissite1.setPoids(vissite.getPoids());
        vissite1.setTemperature(vissite.getTemperature());
        vissite1.setTestVisuel(vissite.getTestVisuel());
        vissite1.setFrequenceCardiaque(vissite.getFrequenceCardiaque());
        vissite1.setFrequenceRespiratoire(vissite.getFrequenceRespiratoire());
        vissite1.setGlycemie(vissite.getGlycemie());
        vissite1.setPressionArterielle(vissite.getPressionArterielle());
        vissite1.setDate_Visite(vissite.getDate_Visite());
         vissiteRepository.save(vissite1);
        return vissite;
    }
    public List<AfficherVisite> getAllVissite() {
        return vissiteRepository.findAll().stream()
                .map(AfficherVisite::DtoFromEntity).collect(Collectors.toList());
    }
    public List<AfficherVisiteByEmploye> getVissitebyEmloyer(String code){
        Employe employe =employerRespository.findEmployeByMatricule(code);
        List<AfficherVisiteByEmploye> vissites=vissiteRepository.findAllVissiteByEmploye(employe).stream()
                .map(AfficherVisiteByEmploye::DtoFromEntity).collect(Collectors.toList());
        VisiteEmbauche visiteEmbauche=visiteEmbaucheRepository.findVisiteEmbaucheByEmploye(employe);
        AfficherVisiteByEmploye afficherVisiteByEmploye=VisiteEmbaucheToVisite(visiteEmbauche);
        Stack<AfficherVisiteByEmploye> visitesByEmploue=new Stack<>();
        visitesByEmploue.add(afficherVisiteByEmploye);
        visitesByEmploue.addAll(vissites);
        return  visitesByEmploue;
    }
    public void deleteVissite(Long id){
        vissiteRepository.deleteById(id);
    }
    public AfficherVisiteByEmploye getVisiteById(Long id){
        return AfficherVisiteByEmploye.DtoFromEntity(this.vissiteRepository.findVissiteById(id));
    }
    public Vissite EntityFromDto(VisiteDto visiteDto){
        return Vissite.builder()
                .diagnostic(visiteDto.getDiagnostic())
                .resultats(visiteDto.getResultats())
                .description(visiteDto.getDescription())
                .date_Visite(visiteDto.getDate_Visite())
                .temperature(visiteDto.getTemperature())
                .pressionArterielle(visiteDto.getPressionArterielle())
                .frequenceRespiratoire(visiteDto.getFrequenceRespiratoire())
                .frequenceCardiaque(visiteDto.getFrequenceCardiaque())
                .poids(visiteDto.getPoids())
                .taille(visiteDto.getTaille())
                .testVisuel(visiteDto.getTestVisuel())
                .glycemie(visiteDto.getGlycemie())
                .build();
    }
    public ResultatControlleMedicale EnityFromDto(ResultatsControleMedicaleDto resultatsControleMedicaleDto){
        ControleMedical controlleMedicale=analyseRepository.findControleMedicalByIdControle(resultatsControleMedicaleDto.getIdControleMedicale());
        return ResultatControlleMedicale.builder()
                .controleMedical(controlleMedicale)
                .Resultats(resultatsControleMedicaleDto.getResultats())
                .Laboratoire(resultatsControleMedicaleDto.getLaboratoire())
                .dateSortieResultats(resultatsControleMedicaleDto.getDateSortieResultats())
                .build();
    }
    public ControlleMedicalDto EntityToDto(ControleMedical controleMedical){
        return ControlleMedicalDto.builder()
               // .nomAnalyse(controleMedical.getNomAnalyse())
                .description(controleMedical.getDescription())
                .build();
    }
    public AfficherVisiteByEmploye VisiteEmbaucheToVisite(VisiteEmbauche visiteEmbauche){
        return AfficherVisiteByEmploye.builder()
                .date_Visite(visiteEmbauche.getDateVisite())
                .typeVisite(visiteEmbauche.getTypeVisite())
                .id(visiteEmbauche.getId())
                .resultats(visiteEmbauche.getResultats())
                .diagnostic(visiteEmbauche.getDiagnostic())
                .description(visiteEmbauche.getDescription())
                .build();
    }

    public AfficherControlleMedicale getAnnalyseById(Long id) {
        ControleMedical controleMedical=analyseRepository.findControleMedicalByIdControle(id);
        return AfficherControlleMedicale.DtoFromEntity(controleMedical);
    }
}
