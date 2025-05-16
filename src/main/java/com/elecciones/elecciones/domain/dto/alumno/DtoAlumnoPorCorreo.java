package com.elecciones.elecciones.domain.dto.alumno;

import jakarta.validation.constraints.NotNull;

public record DtoAlumnoPorCorreo(
       @NotNull String correo
) {
}
