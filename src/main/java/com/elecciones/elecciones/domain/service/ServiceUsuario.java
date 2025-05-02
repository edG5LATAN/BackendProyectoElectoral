package com.elecciones.elecciones.domain.service;

import com.elecciones.elecciones.domain.dto.usuario.DtoUsuario;
import com.elecciones.elecciones.domain.model.Usuario;
import com.elecciones.elecciones.domain.repository.RepositoryUsuario;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceUsuario {

    private final RepositoryUsuario repositoryUsuario;

    public ResponseEntity<?> mostrar() {
        var usuarios= repositoryUsuario.findAll();
        return ResponseEntity.ok(usuarios);
    }

    public ResponseEntity<?> borrar(Long id) {
        var usuario= repositoryUsuario.findById(id);
        if(usuario.isPresent()){
            repositoryUsuario.delete(usuario.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> unidad(Long id) {
        var usuario= repositoryUsuario.findById(id);
        if(usuario.isPresent()){
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.notFound().build();
    }
}
