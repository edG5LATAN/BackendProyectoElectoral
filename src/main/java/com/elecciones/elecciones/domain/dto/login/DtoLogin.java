package com.elecciones.elecciones.domain.dto.login;

import jakarta.validation.constraints.NotNull;

public record DtoLogin(
        @NotNull String correo,
        @NotNull String password
) {
}
