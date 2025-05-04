package com.elecciones.elecciones.infra.security;


import com.elecciones.elecciones.domain.repository.RepositoryUsuario;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class FilterConfiguration extends OncePerRequestFilter {

    private final RepositoryUsuario repositoryUsuario;
    private final SecurityJWT securityJWT;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var autToken= request.getHeader("Authorization");
        if(autToken!=null){
            String token= autToken.replace("Bearer ","");
           var subject=  securityJWT.getSubject(token);
           var usuario= repositoryUsuario.findByCorreo(subject);
           var autenticar= new UsernamePasswordAuthenticationToken(usuario,null,usuario.getAuthorities());
           SecurityContextHolder.getContext().setAuthentication(autenticar);
        }
        filterChain.doFilter(request,response);
    }
}
