package com.elecciones.elecciones.domain.dto.alumno;

import com.elecciones.elecciones.domain.Enumerate.Grado;
import com.elecciones.elecciones.domain.model.Alumno;
import com.elecciones.elecciones.domain.model.Usuario;

public record DtoAlumnoMostrar(
        Long id,
        String nombre,
        String apellido,
        String correo,
        Grado grado
) {
    public DtoAlumnoMostrar(Alumno alumno){
        this(alumno.getIdAlumno(),
                alumno.getNombre(),
                alumno.getApellido(),
                alumno.getUsuario().getCorreo(),
                alumno.getGrado());
    }

}
