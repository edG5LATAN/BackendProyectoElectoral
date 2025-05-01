package com.elecciones.elecciones.domain.repository;

import com.elecciones.elecciones.domain.model.Alumno;
import com.elecciones.elecciones.domain.model.Partido;
import com.elecciones.elecciones.domain.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositoryVoto extends JpaRepository<Voto,Long> {

    boolean existsByAlumno(Alumno alumno);

    List<Voto> findAllByPartido(Optional<Partido> partido);
}
