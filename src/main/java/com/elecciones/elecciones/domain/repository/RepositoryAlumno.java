package com.elecciones.elecciones.domain.repository;

import com.elecciones.elecciones.domain.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryAlumno extends JpaRepository<Alumno,Long> {
}
