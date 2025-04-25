package com.elecciones.elecciones.domain.service;

import com.elecciones.elecciones.domain.dto.voto.DtoVoto;
import com.elecciones.elecciones.domain.model.Voto;
import com.elecciones.elecciones.domain.repository.RepositoryAlumno;
import com.elecciones.elecciones.domain.repository.RepositoryPartido;
import com.elecciones.elecciones.domain.repository.RepositoryVoto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ServiceVoto {

    private final RepositoryVoto repositoryVoto;
    private final RepositoryAlumno repositoryAlumno;
    private final RepositoryPartido repositoryPartido;

    public ResponseEntity mostrar() {
        var voto= repositoryVoto.findAll();
        return ResponseEntity.ok(voto);
    }

    public ResponseEntity unidad(Long id) {
        var voto= repositoryVoto.getReferenceById(id);
        if(voto!=null){
            return ResponseEntity.ok(voto);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity borrar(Long id) {
        var voto= repositoryVoto.getReferenceById(id);
        if(voto!=null){
            repositoryVoto.delete(voto);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity crear(DtoVoto dtoVoto) {
        var partido = repositoryPartido.getReferenceById(dtoVoto.partido());
        if(partido!=null){
            var alumno= repositoryAlumno.getReferenceById(dtoVoto.alumno());
            if(alumno!=null){
                var voto= repositoryVoto.save(new Voto(partido,alumno));
                return ResponseEntity.ok(voto);
            }
        }
        return ResponseEntity.noContent().build();
    }
}
