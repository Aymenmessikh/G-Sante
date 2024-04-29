package com.example.gmt.Repository;

import com.example.gmt.Enitity.Post;
import com.example.gmt.Enitity.Risque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RisqueRepository extends JpaRepository<Risque,Long> {
    Risque findRisqueById(Long id);

    Risque findRisqueByPosts(Post post);

    List<Risque> findAllByPosts(Post post);
}
