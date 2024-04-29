package com.example.gmt.Controller;

import com.example.gmt.Dto.AfficherAllPost;
import com.example.gmt.Dto.AfficherPost;
import com.example.gmt.Dto.PostDto;
import com.example.gmt.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
@RequiredArgsConstructor
public class PostController {
    @Autowired
    private final PostService postService;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostDto> save(@RequestBody PostDto post) {
        PostDto post1 = postService.save(post);
        return new ResponseEntity<>(post1, HttpStatus.CREATED);
    }
    @PutMapping(value = "/modifier/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostDto> modifier(@RequestBody PostDto post ,@PathVariable Long id) {
        PostDto post1 = postService.modifier(post,id);
        return new ResponseEntity<>(post1, HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<AfficherAllPost>> getAll() {
        List<AfficherAllPost> posts = postService.getAllPost();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
    @GetMapping("/getPostById/{id}")
    public ResponseEntity<AfficherPost> getPostById(@PathVariable Long id) {
        AfficherPost post = postService.getPostById(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        postService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
