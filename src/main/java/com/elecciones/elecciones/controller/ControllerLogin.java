package com.elecciones.elecciones.controller;


import com.elecciones.elecciones.domain.dto.login.DtoLogin;
import com.elecciones.elecciones.domain.model.Usuario;
import com.elecciones.elecciones.infra.security.SecurityJWT;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/loguearse")
@RequiredArgsConstructor
public class ControllerLogin {

    private final AuthenticationManager authenticationManager;
    private final SecurityJWT securityJWT;

    @GetMapping("/login")
    public ResponseEntity login(@RequestBody @Valid DtoLogin dtoLogin){
        Authentication autToken= new UsernamePasswordAuthenticationToken(dtoLogin.correo(),dtoLogin.password());
        var usuario=authenticationManager.authenticate(autToken);
        var token= securityJWT.tokenService((Usuario) usuario.getPrincipal());
       return ResponseEntity.ok(token);
    }

}
