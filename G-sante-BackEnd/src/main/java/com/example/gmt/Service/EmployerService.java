package com.example.gmt.Service;

import com.example.gmt.Dto.AfficherEmp;
import com.example.gmt.Dto.EmployeDto;
import com.example.gmt.Dto.ModifierEmploye;
import com.example.gmt.Enitity.Employe;
import com.example.gmt.Repository.DossierMedicalRepository;
import com.example.gmt.Repository.EmployerRespository;
import com.example.gmt.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class EmployerService {
    @Autowired
    private final EmployerRespository employerRespository;
    @Autowired
    private final PostRepository postRepository;
    private final DossierMedicalRepository dossierMedicalRepository;
    public EmployeDto Save(EmployeDto employer){
        employerRespository.save(EnitityFromDto(employer));
        return employer;
    }
    public ModifierEmploye Modifier(ModifierEmploye employeDto, String code){
        Employe employe1 =employerRespository.findEmployeByMatricule(code);
        employe1.setId(employe1.getId());
        employe1.setMail(employeDto.getMail());
        employe1.setAddress(employeDto.getAddress());
        employe1.setPost(postRepository.findPostByIdPost(employeDto.getPost()));
        employe1.setNom(employeDto.getNom());
        employe1.setPrenom(employeDto.getPrenom());
        employe1.setSex(employeDto.getSex());
        employe1.setVille(employeDto.getVille());
        employe1.setTel(employeDto.getTel());
        employe1.setCodePostal(employeDto.getCodePostal());
        employe1.setDate_naissance(employeDto.getDate_naissance());
        employerRespository.save(employe1);
        return employeDto;
    }
    public List<AfficherEmp> getAllEmloyer(){
        List<Employe> employes =employerRespository.findAll();
        for (Employe emp: employes){
            if (emp.getFichierMedical()!=null) {
                Long id = emp.getFichierMedical().getId();
                emp.setFichierMedical(dossierMedicalRepository.findDossier_MedicalById(id));
            }
        }
        return employes.stream().map(AfficherEmp::EnitityToDto).collect(Collectors.toList());
    }
    public void deleteEmployer(Long id){
         employerRespository.deleteById(id);
    }
    public String GenereCode(EmployeDto employer){
        Long maxId=employerRespository.findMaxId();
        if (employerRespository.nombreEmployer()==0){
            String nom=employer.getNom().substring(0,2);
            String Prenom=employer.getPrenom().substring(0,2);
            String Matricule=1+nom+Prenom;
            return Matricule.toUpperCase();
        }
        else {
            String nom = employer.getNom().substring(0, 2);
            String Prenom = employer.getPrenom().substring(0, 2);
            String Matricule = maxId + nom + Prenom;
            return Matricule.toUpperCase();
        }
    }

    public AfficherEmp getEmpByCode(String code) {
        Employe employe = employerRespository.findEmployeByMatricule(code);
        return AfficherEmp.EnitityToDto(employe);
    }
    public Employe EnitityFromDto(EmployeDto employeDto){
        return Employe.builder()
                .matricule(GenereCode(employeDto))
                .post(postRepository.findPostByIdPost(employeDto.getIdPost()))
                .mail(employeDto.getMail())
                .sex(employeDto.getSex())
                .tel(employeDto.getTel())
                .nom(employeDto.getNom())
                .prenom(employeDto.getPrenom())
                .address(employeDto.getAddress())
                .ville(employeDto.getVille())
                .codePostal(employeDto.getCodePostal())
                .date_naissance(employeDto.getDate_naissance())
                .build();
    }
}

