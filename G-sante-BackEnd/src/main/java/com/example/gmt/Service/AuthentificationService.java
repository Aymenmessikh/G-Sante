package com.example.gmt.Service;

import com.example.gmt.Authentification.AuthentificationRequest;
import com.example.gmt.Authentification.AuthentificationResponse;
import com.example.gmt.Authentification.RegistreRequest;
import com.example.gmt.Enitity.Roles;
import com.example.gmt.Enitity.Utilisateure;
import com.example.gmt.Exeption.EntityNotFoundExeption;
import com.example.gmt.Exeption.ErrorCode;
import com.example.gmt.Repository.RoleRepository;
import com.example.gmt.Repository.UtilisateureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthentificationService {
    private final UtilisateureRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthentificationResponse register(RegistreRequest request) {
        if (repository.findUitlisateureByEmail(request.getEmail())!=null){
            throw new EntityNotFoundExeption("Utilisatuere existe dija", ErrorCode.UTILISATEURE_NOT_VALID);
        }
        if (roleRepository.findRolesByName(request.getRole())==null){
            throw new EntityNotFoundExeption("Role null", ErrorCode.UTILISATEURE_NOT_VALID);
        }
        var user = Utilisateure.builder()
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .Nome(request.getNom())
                .Prenom(request.getPrenom())
                .roles(roleRepository.findRolesByName(request.getRole()))
                .enabled(true)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthentificationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthentificationResponse authenticate(AuthentificationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthentificationResponse.builder()
                .token(jwtToken)
                .role(user.getRoles().getName())
                .nom(user.getNome())
                .prenom(user.getPrenom())
                .build();
    }
    @Bean
    public Utilisateure crateAdminUser(){
        if (repository.findUitlisateureByEmail("aymen@gmail.com")==null){
            Roles role = roleRepository.findRolesByName("Informaticien");
            if (role == null) {
                throw new EntityNotFoundExeption("Role not found", ErrorCode.UTILISATEURE_NOT_VALID);
            }

            Utilisateure user = Utilisateure.builder()
                    .email("aymen@gmail.com")
                    .password(passwordEncoder.encode("123456789"))
                    .roles(role) // Reattach the fetched role entity
                    .Prenom("Aymen")
                    .Nome("Messikh")
                    .build();

            return repository.save(user);
        }
        else
            return null;
    }

}
