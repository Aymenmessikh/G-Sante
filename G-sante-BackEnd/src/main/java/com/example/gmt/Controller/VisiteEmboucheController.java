package com.example.gmt.Controller;

import com.example.gmt.Dto.VisiteEmbaucheDto;
import com.example.gmt.Service.VisiteEmbaucheService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("visiteEmbauche")
public class VisiteEmboucheController {
    @Autowired
    private final VisiteEmbaucheService visiteEmbaucheService;

    @PostMapping("/save/{code}")
    public ResponseEntity<VisiteEmbaucheDto> save(@RequestBody VisiteEmbaucheDto visIteEmbaucheDto, @PathVariable String code){
        VisiteEmbaucheDto visiteEmbaucheDto1 =this.visiteEmbaucheService.save(visIteEmbaucheDto,code);
        return new ResponseEntity<>(visiteEmbaucheDto1, HttpStatus.CREATED);
    }

    @PutMapping("/modifier/{idVisite}")
    public ResponseEntity<VisiteEmbaucheDto> modifier(@RequestBody VisiteEmbaucheDto visIteEmbaucheDto,@PathVariable Long idVisite){
        VisiteEmbaucheDto visiteEmbaucheDto1 =this.visiteEmbaucheService.modifier(visIteEmbaucheDto,idVisite);
        return new ResponseEntity<>(visiteEmbaucheDto1, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<VisiteEmbaucheDto>> getAll(){
        List<VisiteEmbaucheDto> visiteEmbaucheDtos=this.visiteEmbaucheService.getAllVisteEmbauche();
        return new ResponseEntity<>(visiteEmbaucheDtos,HttpStatus.OK);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<VisiteEmbaucheDto> getById(@PathVariable Long id){
        VisiteEmbaucheDto visiteEmbaucheDto=this.visiteEmbaucheService.getVisiteById(id);
        return new ResponseEntity<>(visiteEmbaucheDto,HttpStatus.OK);
    }

    @GetMapping("/getByEmploye/{id}")
    public ResponseEntity<VisiteEmbaucheDto> getByEmpolye(@PathVariable Long id){
        VisiteEmbaucheDto visiteEmbaucheDto=this.visiteEmbaucheService.getVisiteByEmploye(id);
        return new ResponseEntity<>(visiteEmbaucheDto,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.visiteEmbaucheService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
