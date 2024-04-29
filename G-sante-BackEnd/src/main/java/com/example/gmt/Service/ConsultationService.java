package com.example.gmt.Service;

import com.example.gmt.Dto.*;
import com.example.gmt.Enitity.*;
import com.example.gmt.Repository.ConsultationRepository;
import com.example.gmt.Repository.DossierMedicalRepository;
import com.example.gmt.Repository.EmployerRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ConsultationService {
    @Autowired
    private final ConsultationRepository consultationRepository;
    @Autowired
    private final EmployerRespository employerRespository;
    @Autowired
    private final DossierMedicalRepository dossierMedicalRepository;
    public ConsultationDto save(ConsultationDto consultationDto,String code){
        if (consultationDto.getTypeConsultations()=="Intervention"){
            if(consultationDto.getLieuDto()!=null){
                Employe employe =employerRespository.findEmployeByMatricule(code);
                FichierMedical fichierMedical=dossierMedicalRepository.findFichierMedicalByEmploye(employe);
                Consultation consultation=EntityFromDto(consultationDto);
                consultation.setFichierMedical(fichierMedical);
                consultation.setEmploye(employe);
                consultation.setTypeConsultations(TypeConsultation.Intervention);
                consultation.setLieu(LieuDto.DtoToEntity(consultationDto.getLieuDto()));
                if (consultationDto.getOrdananceDto().getIsExiste()==true) {
                    Ordananace ordananace = OrdananceDto.DtoToEntity(consultationDto.getOrdananceDto());
                    consultation.setOrdananace(ordananace);
                }
                if (consultationDto.getMaladierDto().getIsExiste()==true){
                    Maladie maladie=MaladierDto.DtoToEnrity(consultationDto.getMaladierDto());
                    consultation.setMaladie(maladie);
                }
                consultationRepository.save(consultation);
                return consultationDto;
            }
            else return consultationDto;
        }
        else {
            Employe employe =employerRespository.findEmployeByMatricule(code);
            FichierMedical fichierMedical=dossierMedicalRepository.findFichierMedicalByEmploye(employe);
            Consultation consultation=EntityFromDto(consultationDto);
            consultation.setFichierMedical(fichierMedical);
            consultation.setEmploye(employe);
            consultation.setTypeConsultations(TypeConsultation.Consultation);
            if (consultationDto.getOrdananceDto().getIsExiste()==true) {
                consultationDto.getOrdananceDto().setDateCerationOrdanance(consultationDto.getDateConsultation());
                Ordananace ordananace = OrdananceDto.DtoToEntity(consultationDto.getOrdananceDto());
                consultation.setOrdananace(ordananace);
            }
            if (consultationDto.getMaladierDto().getIsExiste()==true){
            Maladie maladie=MaladierDto.DtoToEnrity(consultationDto.getMaladierDto());
                consultation.setMaladie(maladie);
            }
            consultationRepository.save(consultation);
        return consultationDto;
        }
    }
    public List<AfficherAllConultation> getAllConsultation(){
        List<Consultation> consultations=consultationRepository
                .findAllByTypeConsultations(TypeConsultation.Consultation);

        List<Consultation> consultations1=consultations.stream().
                filter(consultation -> consultation.getOrdananace()==null && consultation.getMaladie()==null)
                .collect(Collectors.toList());
        List<AfficherAllConultation> allConultations= consultations1.stream()
                .map(AfficherAllConultation::DtoFromEntity).collect(Collectors.toList());
        List<Consultation> consultations2=consultations.stream().
                filter(consultation -> consultation.getOrdananace()==null && consultation.getMaladie()!=null)
                .collect(Collectors.toList());
        List<AfficherAllConultation> allConultationsMaladie= consultations2.stream()
                .map(AfficherAllConultation::DtoFromEntityMaladie).collect(Collectors.toList());
        List<Consultation> consultations3=consultations.stream().
                filter(consultation -> consultation.getOrdananace()!=null && consultation.getMaladie()==null)
                .collect(Collectors.toList());
        List<AfficherAllConultation> allConultationsOrdannance= consultations3.stream()
                .map(AfficherAllConultation::DtoFromEntityOrdannance).collect(Collectors.toList());
        List<Consultation> consultations4=consultations.stream().
                filter(consultation -> consultation.getOrdananace()!=null && consultation.getMaladie()!=null)
                .collect(Collectors.toList());
        List<AfficherAllConultation> allConultationsMaladieOrdnnance= consultations4.stream()
                .map(AfficherAllConultation::DtoFromEntityOrdannanceMaladie).collect(Collectors.toList());
        allConultations.addAll(allConultationsMaladie);
        allConultations.addAll(allConultationsMaladieOrdnnance);
        allConultations.addAll(allConultationsOrdannance);



        return allConultations;
    }
    public List<AfficherAllIntervention> getAllIntervention(){
        List<Consultation> consultations=consultationRepository
                .findAllByTypeConsultations(TypeConsultation.Intervention);
        List<Consultation> consultations1=consultations.stream().
                filter(consultation -> consultation.getOrdananace()==null && consultation.getMaladie()==null)
                .collect(Collectors.toList());
       List<AfficherAllIntervention> allIntervention= consultations1.stream()
               .map(AfficherAllIntervention::DtoFromEntityIntervention).collect(Collectors.toList());
        List<Consultation> consultations2=consultations.stream().
                filter(consultation -> consultation.getOrdananace()==null && consultation.getMaladie()!=null)
                .collect(Collectors.toList());
        List<AfficherAllIntervention> allInterventionMaladie= consultations2.stream()
                .map(AfficherAllIntervention::DtoFromEntityInterventionMaladie).collect(Collectors.toList());
        List<Consultation> consultations3=consultations.stream().
                filter(consultation -> consultation.getOrdananace()!=null && consultation.getMaladie()==null)
                .collect(Collectors.toList());
        List<AfficherAllIntervention> allInterventionOrdannance= consultations3.stream()
                .map(AfficherAllIntervention::DtoFromEntityInterventionOrdnnance).collect(Collectors.toList());
        List<Consultation> consultations4=consultations.stream().
                filter(consultation -> consultation.getOrdananace()!=null && consultation.getMaladie()!=null)
                .collect(Collectors.toList());
        List<AfficherAllIntervention> allInterventionMaladieOrdnnance= consultations4.stream()
                .map(AfficherAllIntervention::DtoFromEntityInterventionOrdnnanceMaladie).collect(Collectors.toList());
        allIntervention.addAll(allInterventionMaladie);
        allIntervention.addAll(allInterventionMaladieOrdnnance);
        allIntervention.addAll(allInterventionOrdannance);
       return allIntervention;
    }
    public AfficherConsulationById getConsultationById(Long id){
        return AfficherConsulationById.DtoFromEntity(consultationRepository.findConsultationByIdConsultation(id));
    }
    public AfficherInterventionById getInterventionById(Long id){
        return AfficherInterventionById.DtoFromEntity(consultationRepository.findConsultationByIdConsultation(id));
    }
    public List<AfficherAllConultation> getConsultationByEmployer(String code){
        Employe employe =employerRespository.findEmployeByMatricule(code);
        return consultationRepository.findAllByEmployeAndTypeConsultations(employe,TypeConsultation.Consultation)
                .stream().map(AfficherAllConultation::DtoFromEntity).collect(Collectors.toList());
    }
    public List<AfficherAllIntervention> getInterventionByEmployer(String code){
        Employe employe =employerRespository.findEmployeByMatricule(code);
        return consultationRepository.findAllByEmployeAndTypeConsultations(employe,TypeConsultation.Intervention)
                .stream().map(AfficherAllIntervention::DtoFromEntityIntervention).collect(Collectors.toList());
    }
    public Consultation EntityFromDto(ConsultationDto consultationDto){
        return Consultation.builder()
                .Diagnostic(consultationDto.getDiagnostic())
                .Resultats(consultationDto.getResultats())
                .decription(consultationDto.getDescription())
                .dateConsultation(consultationDto.getDateConsultation())
                .build();
    }
    public AfficherConsultation EntityToDto(Consultation consultation){
        return AfficherConsultation.builder()
                .idConsultation(consultation.getIdConsultation())
                .dateConsultation(consultation.getDateConsultation())
                .decription(consultation.getDecription())
                .resultats(consultation.getResultats())
                .diagnostic(consultation.getDiagnostic())
                .employe(consultation.getEmploye())
                .typeConsultations(consultation.getTypeConsultations())
                .build();
    }
    public void delete(Long id){
        consultationRepository.deleteById(id);
    }
}
