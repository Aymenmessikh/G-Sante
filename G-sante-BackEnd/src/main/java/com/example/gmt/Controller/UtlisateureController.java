package com.example.gmt.Controller;

import com.example.gmt.Dto.UserDto;
import com.example.gmt.Service.UtilisateureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UtlisateureController {
    private final UtilisateureService utilisateureService;
    @GetMapping("get")
    public ResponseEntity<UserDto> getUserByToken(@RequestParam String token){
        UserDto userDto=utilisateureService.getUserByEmail(token);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
