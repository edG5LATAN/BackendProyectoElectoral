package com.elecciones.elecciones.controller;


import com.elecciones.elecciones.domain.dto.login.DtoLogin;
import com.elecciones.elecciones.domain.model.Usuario;
import com.elecciones.elecciones.infra.security.SecurityJWT;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/loguearse")
@RequiredArgsConstructor
public class ControllerLogin {

    private final AuthenticationManager authenticationManager;
    private final SecurityJWT securityJWT;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid DtoLogin dtoLogin, HttpServletResponse response){
        Authentication autToken= new UsernamePasswordAuthenticationToken(dtoLogin.correo(),dtoLogin.password());
        var usuario=authenticationManager.authenticate(autToken);
        var token= securityJWT.tokenService((Usuario) usuario.getPrincipal());

        Cookie cookie=new Cookie("JWT",token);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(1800);

        response.addCookie(cookie);

       return ResponseEntity.ok(token);
    }

    @PostMapping("/logout")
    public ResponseEntity logout(HttpServletResponse response){
        Cookie cookie=new Cookie("JWT","");
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(0);

        response.addCookie(cookie);

        return ResponseEntity.ok("logout true");

    }

}
