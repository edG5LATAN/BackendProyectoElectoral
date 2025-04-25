package com.elecciones.elecciones.domain.dto.alumno;

import com.elecciones.elecciones.domain.dto.usuario.DtoUsuario;


public record DtoAlumno(
        String nombre,
        String apellido,
        DtoUsuario usuario
) {
}
