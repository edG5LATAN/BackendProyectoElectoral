package com.elecciones.elecciones.domain.repository;

import com.elecciones.elecciones.domain.model.Alumno;
import jakarta.validation.Valid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepositoryAlumno extends JpaRepository<Alumno,Long> {

//    @Query(value = "select * from alumno where usuario.correo = correo")
//    Alumno buscarPorCorreo(@Valid String correo);

    Alumno findByUsuarioCorreo(@Valid String correo);
}
