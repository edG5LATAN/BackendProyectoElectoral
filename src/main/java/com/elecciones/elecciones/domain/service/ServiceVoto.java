package com.elecciones.elecciones.domain.service;

import com.elecciones.elecciones.domain.dto.voto.DtoVoto;
import com.elecciones.elecciones.domain.model.Alumno;
import com.elecciones.elecciones.domain.model.Partido;
import com.elecciones.elecciones.domain.model.Voto;
import com.elecciones.elecciones.domain.repository.RepositoryAlumno;
import com.elecciones.elecciones.domain.repository.RepositoryPartido;
import com.elecciones.elecciones.domain.repository.RepositoryVoto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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
        var voto= repositoryVoto.findById(id);
        if(voto.isPresent()){
            return ResponseEntity.ok(voto);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity borrar(Long id) {
        var voto= repositoryVoto.findById(id);
        if(voto.isPresent()){
            repositoryVoto.delete(voto.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> crear(DtoVoto dtoVoto) {
        Optional<Partido> partido = repositoryPartido.findById(dtoVoto.partido());
        if(partido.isEmpty()){
            return ResponseEntity.ok("no se encontro el id de partido "+dtoVoto.partido());
        }
        Optional<Alumno> alumno = repositoryAlumno.findById(dtoVoto.alumno());
        if(alumno.isEmpty()){
            return ResponseEntity.ok("no se encontro el id de alumno "+dtoVoto.alumno());
        }

        if(repositoryVoto.existsByAlumno(alumno.get())) {
            return ResponseEntity.badRequest().body("El alumno ya ha votado");
        }

        var voto = repositoryVoto.save(new Voto(partido.get(), alumno.get()));
        return ResponseEntity.ok(voto);
    }

    public ResponseEntity buscarPorPartido(Long id) {

        Optional<Partido> partido= repositoryPartido.findById(id);
        if(partido.isEmpty()){
            return ResponseEntity.ok("no se encontro partidos");
        }
      List<Voto> votosPorPartido= repositoryVoto.findAllByPartido(partido);
      return ResponseEntity.ok(votosPorPartido);
    }
}
