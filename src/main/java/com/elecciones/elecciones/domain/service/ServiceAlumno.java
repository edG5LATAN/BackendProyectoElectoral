package com.elecciones.elecciones.domain.service;


import com.elecciones.elecciones.domain.dto.alumno.DtoAlumno;
import com.elecciones.elecciones.domain.dto.alumno.DtoAlumnoMostrar;
import com.elecciones.elecciones.domain.model.Alumno;
import com.elecciones.elecciones.domain.model.Usuario;
import com.elecciones.elecciones.domain.repository.RepositoryAlumno;
import com.elecciones.elecciones.domain.repository.RepositoryUsuario;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceAlumno {

    private final RepositoryAlumno repositoryAlumno;
    private final RepositoryUsuario repositoryUsuario;

    public ResponseEntity mostrar() {
        var alumno= repositoryAlumno.findAll();
        return ResponseEntity.ok(alumno);
    }

    public ResponseEntity borrar(Long id) {
        var alumno= repositoryAlumno.getReferenceById(id);
        if(alumno!=null){
            repositoryAlumno.delete(alumno);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity unidad(Long id) {
        var alumno = repositoryAlumno.getReferenceById(id);
        if(alumno!=null){
            return ResponseEntity.ok(alumno);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity crear(@Valid DtoAlumno dtoAlumno) {
        var usuario= repositoryUsuario.save(new Usuario(dtoAlumno.usuario()));
        var alumno= repositoryAlumno.save(new Alumno(dtoAlumno,usuario));
        return ResponseEntity.ok(new DtoAlumnoMostrar(alumno,usuario));
    }
}
