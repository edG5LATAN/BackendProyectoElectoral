package com.elecciones.elecciones.domain.service;

import com.elecciones.elecciones.domain.dto.partido.DtoPartido;
import com.elecciones.elecciones.domain.model.Partido;
import com.elecciones.elecciones.domain.repository.RepositoryPartido;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ServicePartido {

    private final RepositoryPartido repositoryPartido;

    public ResponseEntity mostrar() {
        var partido= repositoryPartido.findAll();
        return ResponseEntity.ok(partido);
    }

    public ResponseEntity borrar(Long id) {
        var partido= repositoryPartido.getReferenceById(id);
        if(partido!=null){
            repositoryPartido.delete(partido);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity unidad(Long id) {
        var partido= repositoryPartido.getReferenceById(id);
        if(partido!=null){
            return ResponseEntity.ok(partido);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity crear(@Valid DtoPartido dtoPartido) {
        var partido= repositoryPartido.save(new Partido(dtoPartido));
        return ResponseEntity.ok(partido);
    }
}
