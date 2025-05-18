package com.elecciones.elecciones.domain.dto.login;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;

public record DtoLogin(
        @NotNull @JsonAlias("email") String correo,
        @NotNull String password
) {
}
