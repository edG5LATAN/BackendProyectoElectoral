package com.elecciones.elecciones.domain.dto.usuario;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;

public record DtoUsuario(
       @NotNull @JsonAlias("email") String correo,
       @NotNull @JsonAlias("password") String clave
) {
}
