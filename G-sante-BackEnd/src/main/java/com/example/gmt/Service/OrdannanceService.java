package com.example.gmt.Service;

import com.example.gmt.Dto.OrdananceDto;
import com.example.gmt.Repository.OrdananceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class OrdannanceService {
    private final OrdananceRepository ordananceRepository;
    public OrdananceDto getOrdannanceById(Long id){
        return OrdananceDto.DtoFromEntity(ordananceRepository.findOrdananaceByIdOrdanance(id));
    }
}
