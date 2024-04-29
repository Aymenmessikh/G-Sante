package com.example.gmt.Service;

import com.example.gmt.Dto.*;
import com.example.gmt.Enitity.*;
import com.example.gmt.Exeption.EntityNotFoundExeption;
import com.example.gmt.Exeption.ErrorCode;
import com.example.gmt.Repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.gmt.Dto.AjouterFichierMedicalDto.EntityFromDto;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class DossierMedicalService {
    @Autowired
    private final DossierMedicalRepository dossierMedicalRepository;
    private final EmployerRespository employerRespository;
    private final AllergieRepository allergieRepository;
    private final MalladieChroniqueRepository malladieChroniqueRepository;
    private final VaccinsRepositpry vaccinsRepositpry;
    private final AnalyseRepository analyseRepository;
    @Autowired
    private final PeriodicteMaladieChroniqueRepository periodicteMaladieChroniqueRepository;
    @Autowired
    private final PeriodiciteFicheMedicaleRepository periodiciteFicheMedicaleRepository;
    public AjouterFichierMedicalDto save(AjouterFichierMedicalDto ajouterFichierMedicalDto,String code){
        Employe employe =employerRespository.findEmployeByMatricule(code);
        FichierMedical fichierMedical=EntityFromDto(ajouterFichierMedicalDto);
        List<Vaccins> vaccins=ajouterFichierMedicalDto.getIdVaccins().stream().
                map(id  ->vaccinsRepositpry.findVaccinsById(id))
                .collect(Collectors.toList());
        List<MaladieChronique> maladieChroniques=ajouterFichierMedicalDto.getIdMaladieCchroniques().stream().
                map(id  ->malladieChroniqueRepository.findMaladieChroniqueById(id))
                .collect(Collectors.toList());
        if (employe.getFichierMedical() == null) {
            fichierMedical.setEmploye(employe);
            fichierMedical.setMaladie_chroniques(maladieChroniques);
            fichierMedical.setVaccins(vaccins);
            if (ajouterFichierMedicalDto.getPeriodiciteMaladieChroniqueDtos() != null) {
                List<PeriodiciteFicheMedical> periodiciteFicheMedicals = ajouterFichierMedicalDto
                        .getPeriodiciteMaladieChroniqueDtos().stream()
                        .map(this::DtoToEntity)
                        .collect(Collectors.toList());
                fichierMedical.setPeriodiciteFicheMedicals(periodiciteFicheMedicals);
            FichierMedical fichierMedical1=  dossierMedicalRepository.save(fichierMedical);
            employe.setFichierMedical(fichierMedical1);
            employerRespository.save(employe);
                for (PeriodiciteFicheMedical periodiciteFicheMedical : periodiciteFicheMedicals) {
                    periodiciteFicheMedical.setFichierMedical(fichierMedical1);
                    periodiciteFicheMedicaleRepository.save(periodiciteFicheMedical);
                }
            }

        }
        else {
            throw new EntityNotFoundExeption("Employer Possede Dossier", ErrorCode.EMPLOYER_POSSED_DOSSIER);
        }
        return ajouterFichierMedicalDto;
    }

    private PeriodiciteFicheMedical DtoToEntity(PeriodiciteMaladieChroniqueDto dto) {
        ControleMedical controleMedical=analyseRepository.findControleMedicalByControle(dto.getControleMedicale());
        return PeriodiciteFicheMedical.builder()
                .periodicite(dto.getPeriodicite())
                .controleMedical(controleMedical)
                .build();
    }

    public FichierMedical Modifier(FichierMedical dossierMedical, String code){
        Employe employe=employerRespository.findEmployeByMatricule(code);
        FichierMedical dossierMedical1=dossierMedicalRepository.findFichierMedicalByEmploye(employe);
        dossierMedical1.setGroupSanguin(dossierMedical.getGroupSanguin());
        dossierMedical1.setAllergier(dossierMedical.getAllergier());
        dossierMedical1.setVaccins(dossierMedical.getVaccins());
        dossierMedical1.setMaladie_chroniques(dossierMedical.getMaladie_chroniques());
        dossierMedical1.setNotes(dossierMedical.getNotes());
        dossierMedical1.setPoid(dossierMedical.getPoid());
        dossierMedical1.setTaille(dossierMedical.getTaille());
        return dossierMedicalRepository.save(dossierMedical1);
    }
    public List<FichierMedical> getAllDossier(){
        return dossierMedicalRepository.findAll();
    }
    public FichierMedcialDto getDossierByCode(String code){
        Long id=employerRespository.findEmployeByMatricule(code).getFichierMedical().getId();
        FichierMedical dossierMedical=dossierMedicalRepository.findDossier_MedicalById(id);
//        if (LocalDate.now().isEqual(dossierMedical.getDateProchaineVisit())){
//            dossierMedical.setAjouterVisit(true);
//        }
//        else dossierMedical.setAjouterVisit(false);
       // dossierMedicalRepository.save(dossierMedical);

        return EnitiyToDto(dossierMedical);
    }
    public void deleteDossier(Long id){
        dossierMedicalRepository.deleteById(id);
    }
    public  FichierMedcialDto EnitiyToDto(FichierMedical fichierMedical){
        List<PeriodiciteMaladieChronique> periodiciteMaladieChronique=
                periodicteMaladieChroniqueRepository.findAllByMaladieChroniqueIn(fichierMedical.getMaladie_chroniques());
        List<AfficheControleByMaladieChronique> afficheControleByMaladieChronique=periodiciteMaladieChronique
                .stream().map(this::EntityToDtoo).collect(Collectors.toList());
        return FichierMedcialDto.builder()
                .id(fichierMedical.getId())
                .vaccins(fichierMedical.getVaccins())
                .groupSanguin(fichierMedical.getGroupSanguin())
                .notes(fichierMedical.getNotes())
                .poid(fichierMedical.getPoid())
                .taille(fichierMedical.getTaille())
                .date_Creation(fichierMedical.getDate_Creation())
                .maladie_chroniques(afficheControleByMaladieChronique)
                .afficherControleByFicheMedicales(fichierMedical.getPeriodiciteFicheMedicals().stream()
                        .map(AfficherControleByFicheMedicale::DtoFromEntity).collect(Collectors.toList()))
                .build();
    }
    public AfficheControleByMaladieChronique EntityToDtoo(PeriodiciteMaladieChronique periodiciteMaladieChronique){
        return AfficheControleByMaladieChronique.builder()
                .maladieChronique(periodiciteMaladieChronique.getMaladieChronique().getMalladieChronique())
                .controle(periodiciteMaladieChronique.getControleMedical().getControle())
                .typeControle(periodiciteMaladieChronique.getControleMedical().getTypeControle())
                .id(periodiciteMaladieChronique.getIdPeriodicite())
                .periodicte(periodiciteMaladieChronique.getPeriodicite())
                .build();
    }
}
