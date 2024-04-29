package com.example.gmt.Repository;

import com.example.gmt.Enitity.Employe;
import com.example.gmt.Enitity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    Post findPostByIdPost(Long idPost);

    Post findPostByEmployes(Employe employe);

    Optional<Post> findByFonction(String fonction);
}
