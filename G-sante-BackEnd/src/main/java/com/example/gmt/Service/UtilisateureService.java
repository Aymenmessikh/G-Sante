package com.example.gmt.Service;

import com.example.gmt.Dto.UserDto;
import com.example.gmt.Enitity.Utilisateure;
import com.example.gmt.Repository.RoleRepository;
import com.example.gmt.Repository.UtilisateureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UtilisateureService {
    private final UtilisateureRepository utilisateureRepository;
    private final JwtService jwtService;
    public UserDto getUserByEmail(String token){
        var email=jwtService.extractUsername(token);
        Utilisateure utilisateure=utilisateureRepository.findUitlisateureByEmail(email);
        UserDto userDto=new UserDto();
        userDto.setRole(utilisateure.getRoles().getName());
        userDto.setEmail(utilisateure.getEmail());
        userDto.setId(utilisateure.getId());
        userDto.setNome(utilisateure.getNome());
        userDto.setPrenom(utilisateure.getPrenom());
       return userDto;
    }
}
