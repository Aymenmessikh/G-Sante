package com.example.gmt.Service;

import com.example.gmt.Dto.VisiteEmbaucheDto;
import com.example.gmt.Enitity.Employe;
import com.example.gmt.Enitity.FichierMedical;
import com.example.gmt.Enitity.VisiteEmbauche;
import com.example.gmt.Repository.DossierMedicalRepository;
import com.example.gmt.Repository.EmployerRespository;
import com.example.gmt.Repository.VisiteEmbaucheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class VisiteEmbaucheService {
    @Autowired
    private final VisiteEmbaucheRepository visiteEmbaucheRepository;
    @Autowired
    private final EmployerRespository employerRespository;
    @Autowired
    private final DossierMedicalRepository dossierMedicalRepository;
    public List<VisiteEmbaucheDto> getAllVisteEmbauche() {
        return visiteEmbaucheRepository.findAll().stream()
                .map(VisiteEmbaucheDto::DtoFromEntity).collect(Collectors.toList());
    }
    public VisiteEmbaucheDto getVisiteById(Long id){
        return VisiteEmbaucheDto.DtoFromEntity(visiteEmbaucheRepository.findVisiteEmbaucheById(id));
    }
    public VisiteEmbaucheDto getVisiteByEmploye(Long id){
        Employe employe=employerRespository.findEmployeById(id);
        return VisiteEmbaucheDto.DtoFromEntity(visiteEmbaucheRepository.findVisiteEmbaucheByEmploye(employe));
    }
    public VisiteEmbaucheDto save(VisiteEmbaucheDto visIteEmbaucheDto, String code){
        Employe employe=employerRespository.findEmployeByMatricule(code);
        FichierMedical fichierMedical=dossierMedicalRepository.findFichierMedicalByEmploye(employe);
        VisiteEmbauche visiteEmbauche= VisiteEmbaucheDto.DtoToEntity(visIteEmbaucheDto);
        visiteEmbauche.setTypeVisite("Visite de Embauche");
        visiteEmbauche.setEmploye(employe);
        visiteEmbauche.setFichierMedical(fichierMedical);
        visiteEmbaucheRepository.save(visiteEmbauche);
        employe.setVisiteEmbauche(visiteEmbauche);
        employerRespository.save(employe);
        return visIteEmbaucheDto;
    }
    public void  delete(Long id){
        visiteEmbaucheRepository.findVisiteEmbaucheById(id);
    }

    public VisiteEmbaucheDto modifier(VisiteEmbaucheDto visIteEmbaucheDto, Long idVisite) {
        VisiteEmbauche visiteEmbauche=visiteEmbaucheRepository.findVisiteEmbaucheById(idVisite);
        visiteEmbauche.setDateVisite(visIteEmbaucheDto.getDate_Visite());
        visiteEmbauche.setDiagnostic(visIteEmbaucheDto.getDiagnostic());
        visiteEmbauche.setDescription(visIteEmbaucheDto.getDescription());
        visiteEmbauche.setResultats(visIteEmbaucheDto.getResultats());
        visiteEmbaucheRepository.save(visiteEmbauche);
        return visIteEmbaucheDto;
    }
}