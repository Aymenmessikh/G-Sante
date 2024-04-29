package com.example.gmt.Service;

import com.example.gmt.Dto.MaladierDto;
import com.example.gmt.Repository.MaladieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MaladieService {
    private final MaladieRepository maladieRepository;
    public MaladierDto getMaladieById(Long id){
        return MaladierDto.DtoFromEnrity(maladieRepository.findMaladieByIdMaladie(id));
    }
}
