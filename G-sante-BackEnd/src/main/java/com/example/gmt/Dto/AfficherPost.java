package com.example.gmt.Dto;

import com.example.gmt.Enitity.ControleMedical;
import com.example.gmt.Enitity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AfficherPost {
    private Long idPost;
    private String codePost;
    private String department;
    private String direction;
    private String fonction;
    private List<RisqueDto> risques;
    private List<ControleMedical> analyses;
    public static AfficherPost EntityToPostDto(Post post){
        return AfficherPost.builder()
                .idPost(post.getIdPost())
                .codePost(post.getCodePost())
                .department(post.getDepartment())
                .direction(post.getDirectrion())
                .fonction(post.getFonction())
               // .analyses(post.getAnalyses())
                .risques(post.getRisques().stream().map(risque -> RisqueDto.RisqueDtoFtomRisque(risque)).collect(Collectors.toList()))
                .build();
    }
}
