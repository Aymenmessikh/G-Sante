package com.example.gmt.Configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers(GET,"/Emp/**").hasAnyAuthority("MedecinChef","Medecin","Gestionnaire","Informaticien")
                .requestMatchers(POST,"/Emp/**").hasAnyAuthority("Gestionnaire","Informaticien")
                .requestMatchers(PUT,"/Emp/**").hasAnyAuthority("Gestionnaire","Informaticien")
                .requestMatchers(DELETE,"/Emp/**").hasAnyAuthority("Gestionnaire","Informaticien")

                .requestMatchers(GET,"/post/**").hasAnyAuthority("MedecinChef","Medecin","Gestionnaire","Informaticien")
                .requestMatchers(POST,"/post/**").hasAnyAuthority("Gestionnaire","Informaticien")
                .requestMatchers(PUT,"/post/**").hasAnyAuthority("Gestionnaire","Informaticien")
                .requestMatchers(DELETE,"/post/**").hasAnyAuthority("Gestionnaire","Informaticien")

                .requestMatchers(GET,"/risque/**").hasAnyAuthority("MedecinChef","Medecin","Gestionnaire","Informaticien")
                .requestMatchers(POST,"/risque/**").hasAnyAuthority("Gestionnaire","Informaticien")
                .requestMatchers(PUT,"/risque/**").hasAnyAuthority("Gestionnaire","Informaticien")
                .requestMatchers(DELETE,"/risque/**").hasAnyAuthority("Gestionnaire","Informaticien")

                .requestMatchers(GET,"/allergie/**").hasAnyAuthority("MedecinChef","Medecin","Informaticien")
                .requestMatchers(POST,"/allergie/**").hasAnyAuthority("MedecinChef","Informaticien")
                .requestMatchers(PUT,"/allergie/**").hasAnyAuthority("MedecinChef","Informaticien")
                .requestMatchers(DELETE,"/allergie/**").hasAnyAuthority("MedecinChef","Informaticien")

                .requestMatchers(GET,"/mChron/**").hasAnyAuthority("MedecinChef","Medecin","Informaticien")
                .requestMatchers(POST,"/mChron/**").hasAnyAuthority("MedecinChef","Informaticien")
                .requestMatchers(PUT,"/mChron/**").hasAnyAuthority("MedecinChef","Informaticien")
                .requestMatchers(DELETE,"/mChron/**").hasAnyAuthority("MedecinChef","Informaticien")

                .requestMatchers(GET,"/vacssin/**").hasAnyAuthority("MedecinChef","Medecin","Informaticien")
                .requestMatchers(POST,"/vacssin/**").hasAnyAuthority("MedecinChef","Informaticien")
                .requestMatchers(PUT,"/vacssin/**").hasAnyAuthority("MedecinChef","Informaticien")
                .requestMatchers(DELETE,"/vacssin/**").hasAnyAuthority("MedecinChef","Informaticien")

                .requestMatchers(GET,"/analyse/**").hasAnyAuthority("MedecinChef","Medecin","Gestionnaire","Informaticien")
                .requestMatchers(POST,"/analyse/**").hasAnyAuthority("MedecinChef","Informaticien")
                .requestMatchers(PUT,"/analyse/**").hasAnyAuthority("MedecinChef","Informaticien")
                .requestMatchers(DELETE,"/analyse/**").hasAnyAuthority("MedecinChef","Informaticien")

                .requestMatchers(GET,"/cons/**").hasAnyAuthority("MedecinChef","Medecin","Informaticien")
                .requestMatchers(POST,"/cons/**").hasAnyAuthority("MedecinChef","Medecin","Informaticien")
                .requestMatchers(PUT,"/cons/**").hasAnyAuthority("MedecinChef","Medecin","Informaticien")
                .requestMatchers(DELETE,"/cons/**").hasAnyAuthority("MedecinChef","Medecin","Informaticien")

                .requestMatchers(GET,"/Dossier/**").hasAnyAuthority("MedecinChef","Medecin","Informaticien")
                .requestMatchers(POST,"/Dossier/**").hasAnyAuthority("MedecinChef","Medecin","Informaticien")
                .requestMatchers(PUT,"/Dossier/**").hasAnyAuthority("MedecinChef","Medecin","Informaticien")
                .requestMatchers(DELETE,"/Dossier/**").hasAnyAuthority("MedecinChef","Medecin","Informaticien")

                .requestMatchers(GET, "/visite/**").hasAnyAuthority("MedecinChef","Medecin","Informaticien")
                .requestMatchers(POST, "/visite/**").hasAnyAuthority("MedecinChef","Medecin","Informaticien")
                .requestMatchers(PUT, "/visite/**").hasAnyAuthority("MedecinChef","Medecin","Informaticien")
                .requestMatchers(DELETE, "/visite/**").hasAnyAuthority("MedecinChef","Medecin","Informaticien")

                .requestMatchers(GET, "/visiteEmbauche/**").hasAnyAuthority("MedecinChef","Medecin","Informaticien")
                .requestMatchers(POST, "/visiteEmbauche/**").hasAnyAuthority("MedecinChef","Medecin","Informaticien")
                .requestMatchers(PUT, "/visiteEmbauche/**").hasAnyAuthority("MedecinChef","Medecin","Informaticien")
                .requestMatchers(DELETE, "/visiteEmbauche/**").hasAnyAuthority("MedecinChef","Medecin","Informaticien")

                .requestMatchers(GET, "/user/**").hasAnyAuthority("MedecinChef","Medecin","Informaticien","Gestionnaire")

                .requestMatchers("/auth/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
