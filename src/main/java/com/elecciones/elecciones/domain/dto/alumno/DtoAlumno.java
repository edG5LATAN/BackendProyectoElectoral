package com.elecciones.elecciones.domain.dto.alumno;

import com.elecciones.elecciones.domain.Enumerate.Grado;
import com.elecciones.elecciones.domain.dto.usuario.DtoUsuario;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record DtoAlumno(
       @NotNull @JsonAlias("name") String nombre,
       @NotNull @JsonAlias("lastname") String apellido,
       @NotNull @JsonAlias("user") DtoUsuario usuario,
       @NotNull @JsonAlias("grade") Grado grado
) {
}
