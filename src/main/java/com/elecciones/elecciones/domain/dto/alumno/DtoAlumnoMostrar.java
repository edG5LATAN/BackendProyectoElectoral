package com.elecciones.elecciones.domain.dto.alumno;

import com.elecciones.elecciones.domain.model.Alumno;
import com.elecciones.elecciones.domain.model.Usuario;

public record DtoAlumnoMostrar(
        String nombre,
        String apellido,
        String correo
) {
    public DtoAlumnoMostrar(Alumno alumno, Usuario usuario){
        this(alumno.getNombre(), alumno.getApellido(), usuario.getCorreo());
    }
}
