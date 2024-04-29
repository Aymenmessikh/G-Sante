package com.example.gmt.Dto;

import com.example.gmt.Enitity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AfficherAllPost {
    private Long idPost;
    private String codePost;
    private String direction;
    private String fonction;
    private String department;
    public static AfficherAllPost EntityToDto(Post post){
        return AfficherAllPost.builder()
                .codePost(post.getCodePost())
                .idPost(post.getIdPost())
                .department(post.getDepartment())
                .direction(post.getDirectrion())
                .fonction(post.getFonction())
                .build();
    }
}
