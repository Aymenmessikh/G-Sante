package com.example.gmt.Repository;

import com.example.gmt.Dto.MaladiesChroniquePlusCourant;
import com.example.gmt.Enitity.FichierMedical;
import com.example.gmt.Enitity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DossierMedicalRepository extends JpaRepository<FichierMedical,Long> {
    FichierMedical findDossier_MedicalById(Long id);

    FichierMedical findFichierMedicalByEmploye(Employe employe);
    @Query(value = "SELECT m.malladie_chronique AS maladiesChronique, COUNT(m.malladie_chronique) AS nombreMaladies " +
            "FROM fichier_medical AS f " +
            "JOIN maladie_chronique_medical AS mm ON mm.id_malladie_chronique = f.id " +
            "JOIN maladie_chronique AS m ON m.id_malladie_chronique = mm.id_fichier_med " +
            "GROUP BY m.malladie_chronique", nativeQuery = true)
    List<Object[]> getMaladiesChroniquePlusCourant();
    @Query(value = "SELECT m. AS maladiesChronique, COUNT(m.malladie_chronique) AS nombreMaladies " +
            "FROM fichier_medical AS f " +
            "JOIN maladie_chronique_medical AS mm ON mm.id_malladie_chronique = f.id " +
            "JOIN maladie_chronique AS m ON m.id_malladie_chronique = mm.id_fichier_med " +
            "GROUP BY m.malladie_chronique", nativeQuery = true)
    List<Object[]> getControleMedicalePlusCourant();
}
