package com.elecciones.elecciones.infra.security;


import com.elecciones.elecciones.domain.repository.RepositoryUsuario;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
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
        Cookie[] cookies= request.getCookies();
        String token=null;
        if(cookies!=null){
            for (Cookie cookie:cookies){
                if("JWT".equals(cookie.getName())){
                    token=cookie.getValue();
                    break;
                }
            }
        }

        if(token!=null){
            try {
                var subject=  securityJWT.getSubject(token);
                if(subject!=null){
                   var usuario= repositoryUsuario.findByCorreo(subject);
                   var autenticar= new UsernamePasswordAuthenticationToken(usuario,null,usuario.getAuthorities());
                   SecurityContextHolder.getContext().setAuthentication(autenticar);
                }
            }catch (Exception e){
                System.out.println(e.toString());
            }

        }

        filterChain.doFilter(request,response);
    }
}
