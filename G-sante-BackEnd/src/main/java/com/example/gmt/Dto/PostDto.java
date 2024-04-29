package com.example.gmt.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {
    private Long idPost;
    private String codePost;
    private String direction;
    private String fonction;
    private String department;
    private List<Long> idRisque;
    private List<Long> idAnalyse;
}
