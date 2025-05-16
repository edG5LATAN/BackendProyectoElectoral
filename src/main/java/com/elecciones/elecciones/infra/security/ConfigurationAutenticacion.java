package com.elecciones.elecciones.infra.security;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ConfigurationAutenticacion {

    private final FilterConfiguration filterConfiguration;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(crs->crs.disable())
                .sessionManagement(sess->sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(ht->ht.requestMatchers("/v1/loguearse/login",
                                "/v1/alumno/mostrar","/v1/alumno/crear","/v1/loguearse/logout")
                        .permitAll()
//                        .requestMatchers("/v1/alumno/borrar/**","/v1/partido/crear","/v1/partido/borrar/**",
//                                "/v1/partido/unidad","/v1/alumno/borrar/**","/v1/alumno/borrar/**")
//                        .hasRole("ADMIN")
                        .anyRequest()
                        .authenticated()
                )
                .addFilterBefore(filterConfiguration, UsernamePasswordAuthenticationFilter.class)
                .cors(cors->cors.configurationSource(corsConfigurationSource()))
                .build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration= new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:5173/"));
        configuration.setAllowedMethods(List.of("GET","POST","DELETE","PUT"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(List.of("Authorization","Content-Type"));
        UrlBasedCorsConfigurationSource source= new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",configuration);
        return source;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
