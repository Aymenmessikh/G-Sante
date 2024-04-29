package com.example.gmt.Service;

import com.example.gmt.Dto.AfficherAllPost;
import com.example.gmt.Dto.AfficherPost;
import com.example.gmt.Dto.PostDto;
import com.example.gmt.Enitity.ControleMedical;
import com.example.gmt.Enitity.Post;
import com.example.gmt.Enitity.Risque;
import com.example.gmt.Repository.AnalyseRepository;
import com.example.gmt.Repository.PostRepository;
import com.example.gmt.Repository.RisqueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.gmt.Dto.AfficherPost.EntityToPostDto;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    @Autowired
    private final PostRepository postRepository;
    @Autowired
    private final AnalyseRepository analyseRepository;
    @Autowired
    private final RisqueRepository risqueRepository;

    public PostDto save(PostDto postDto){
        Optional<Post> post=this.postRepository.findByFonction(postDto.getFonction());
        if (!post.isPresent()){
         postRepository.save(EntityFromDto(postDto));
        return postDto;
        }else
        return postDto;
    }
   public List<AfficherAllPost> getAllPost(){
        return postRepository.findAll().stream().map(AfficherAllPost::EntityToDto).collect(Collectors.toList());
   }
   public AfficherPost getPostById(Long id){
        Post post=postRepository.findPostByIdPost(id);
        AfficherPost afficherPost=EntityToPostDto(post);
        return afficherPost;

   }
    public void delete(Long id){
        postRepository.deleteById(id);
    }
    public Post EntityFromDto(PostDto postDto){
        List<Risque> risques = postDto.getIdRisque().stream()
                .map(id -> risqueRepository.findRisqueById(id))
                .collect(Collectors.toList());
        List<ControleMedical> analyses = postDto.getIdAnalyse().stream()
                .map(id -> analyseRepository.findControleMedicalByIdControle(id))
                .collect(Collectors.toList());
        return Post.builder()
                .fonction(postDto.getFonction())
                .directrion(postDto.getDirection())
                .department(postDto.getDepartment())
                .risques(risques)
                .codePost(GenereCodePost(postDto))
                .build();
    }
    public String GenereCodePost(PostDto post){
        String A= post.getDirection().substring(0,2);
        String B=post.getDepartment().substring(0,2);
        String C=post.getFonction().substring(0,2);
        String Matricule=""+A+""+B+""+C;
        return Matricule.toUpperCase();
    }

    public PostDto modifier(PostDto post, Long id) {
        Post post1=postRepository.findPostByIdPost(id);
        post1.setDepartment(post.getDepartment());
        post1.setFonction(post.getFonction());
        post1.setDirectrion(post.getDirection());
        post1.setCodePost(GenereCodePost(post));
        List<Risque> risques = post.getIdRisque().stream()
                .map(idRisque -> risqueRepository.findRisqueById(id))
                .collect(Collectors.toList());
        List<ControleMedical> analyses = post.getIdAnalyse().stream()
                .map(idAnalyse -> analyseRepository.findControleMedicalByIdControle(id))
                .collect(Collectors.toList());
        post1.setRisques(risques);
        post1.setCodePost(GenereCodePost(post));
        postRepository.save(post1);
        return post;
    }
}
