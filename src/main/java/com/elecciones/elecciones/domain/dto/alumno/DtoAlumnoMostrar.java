package com.elecciones.elecciones.domain.dto.alumno;

import com.elecciones.elecciones.domain.Enumerate.Grado;
import com.elecciones.elecciones.domain.model.Alumno;
import com.elecciones.elecciones.domain.model.Usuario;

public record DtoAlumnoMostrar(
        String nombre,
        String apellido,
        String correo,
        Grado grado
) {
    public DtoAlumnoMostrar(Alumno alumno){
        this(alumno.getNombre(),
                alumno.getApellido(),
                alumno.getUsuario().getCorreo(),
                alumno.getGrado());
    }

}
