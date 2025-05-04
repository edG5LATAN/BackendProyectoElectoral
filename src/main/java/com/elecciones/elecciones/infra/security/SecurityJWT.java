package com.elecciones.elecciones.infra.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.elecciones.elecciones.domain.model.Usuario;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class SecurityJWT {


    public String tokenService(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256("apikey");
            return JWT.create()
                    .withIssuer("electionSchool")
                    .withClaim("id",usuario.getIdUsuario())
                    .withSubject(usuario.getCorreo())
                    .withExpiresAt(finalizarToken())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException(exception.toString());
            // Invalid Signing configuration / Couldn't convert Claims.
        }
    }

    public String getSubject(String token){
        DecodedJWT verifier = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256("apikey");
             verifier = JWT.require(algorithm)
                    // specify any specific claim validations
                    .withIssuer("electionSchool")
                    // reusable verifier instance
                    .build()
                     .verify(token);

        } catch (JWTVerificationException exception){
            throw new RuntimeException("error "+exception.getMessage());
            // Invalid signature/claims
        }
        if(verifier.getSubject().isEmpty()){
            return "subject is blank repeat againt";
        }
        return verifier.getSubject();
    }

    private Instant finalizarToken(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-06:00"));
    }
}
