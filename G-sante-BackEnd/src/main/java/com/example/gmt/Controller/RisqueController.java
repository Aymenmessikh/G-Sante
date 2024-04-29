package com.example.gmt.Controller;

import com.example.gmt.Dto.AfficherAllRisque;
import com.example.gmt.Dto.AfficherRisqueById;
import com.example.gmt.Dto.RisqueDto;
import com.example.gmt.Service.RisqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("risque")
public class RisqueController {
        @Autowired
        private final RisqueService risqueService;

        @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<RisqueDto> save(@RequestBody RisqueDto risqueDto) {
            RisqueDto risqueDto1 = risqueService.save(risqueDto);
            return new ResponseEntity<>(risqueDto1, HttpStatus.CREATED);
        }
        @PutMapping(value = "/modifier/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<RisqueDto> modifier(@RequestBody RisqueDto risqueDto,@PathVariable Long id) {
            RisqueDto risqueDto1 = risqueService.modifier(risqueDto,id);
            return new ResponseEntity<>(risqueDto1, HttpStatus.CREATED);
        }

        @GetMapping("/getAll")
        public ResponseEntity<List<AfficherAllRisque>> getAll() {
            List<AfficherAllRisque> risques =risqueService.gatAllRisque();
            return new ResponseEntity<>(risques, HttpStatus.OK);
        }
        @GetMapping("/getRisqueById/{id}")
        public ResponseEntity<AfficherRisqueById> getRisqueById(@PathVariable Long id) {
           AfficherRisqueById risques =risqueService.getRisqueById(id);
            return new ResponseEntity<>(risques, HttpStatus.OK);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
            risqueService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
}
