package com.elecciones.elecciones.domain.service;


import at.favre.lib.crypto.bcrypt.BCrypt;
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

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceAlumno {

    private final RepositoryAlumno repositoryAlumno;
    private final RepositoryUsuario repositoryUsuario;

    public ResponseEntity mostrar() {
        var alumno= repositoryAlumno.findAll().stream().map(DtoAlumnoMostrar::new).toList();
        return ResponseEntity.ok(alumno);
    }

    public ResponseEntity borrar(Long id) {
        var alumno= repositoryAlumno.findById(id);
        if(alumno.isPresent()){
            repositoryAlumno.delete(alumno.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity unidad(Long id) {
        boolean alumnoB = repositoryAlumno.existsById(id);
        if(!alumnoB){
            return ResponseEntity.notFound().build();
        }
        Optional<Alumno> alumno=repositoryAlumno.findById(id);
        return ResponseEntity.ok(new DtoAlumnoMostrar(alumno.get()));
    }

    public ResponseEntity crear(@Valid DtoAlumno dtoAlumno) {
        var clave= passEcond(dtoAlumno.usuario().clave());
        var usuario= repositoryUsuario.save(new Usuario(dtoAlumno.usuario(),clave));
        var alumno= repositoryAlumno.save(new Alumno(dtoAlumno,usuario));
        return ResponseEntity.ok(new DtoAlumnoMostrar(alumno));
    }

    private String passEcond(String clave){
        return BCrypt.withDefaults().hashToString(12, clave.toCharArray());
    }
}
