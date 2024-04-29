package com.example.gmt.Dto;

import com.example.gmt.Enitity.Lieu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LieuDto {
    private String lieu;
    private Long idLieu;
    public static Lieu DtoToEntity(LieuDto lieuDto){
        return Lieu.builder()
                .lieu(lieuDto.getLieu())
                .build();
    }
    public static LieuDto DtoFromEntity(Lieu lieux){
        return LieuDto.builder()
                .lieu(lieux.getLieu())
                .idLieu(lieux.getIdLieu())
                .build();
    }
}
