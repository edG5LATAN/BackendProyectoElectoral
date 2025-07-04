package com.elecciones.elecciones.domain.dto.voto;

import com.elecciones.elecciones.domain.model.Voto;
import jakarta.validation.constraints.NotNull;

public record DtoVotoMostrar (
        Long idVoto,
       @NotNull String nombre,
       @NotNull String apellido,
       @NotNull String grado,
       @NotNull String correo, @NotNull String partido, @NotNull String bandera,
       Long idPartido
){
    public DtoVotoMostrar(Voto voto){
        this(voto.getIdCodigo(),voto.getAlumno().getNombre(),voto.getAlumno().getApellido(),
                String.valueOf(voto.getAlumno().getGrado()),voto.getAlumno().getUsuario().getCorreo(),
                voto.getPartido().getNombre(),voto.getPartido().getBandera(),voto.getPartido().getIdPartido());
    }
}
