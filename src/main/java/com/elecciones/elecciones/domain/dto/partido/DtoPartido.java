package com.elecciones.elecciones.domain.dto.partido;

import jakarta.validation.constraints.NotNull;

public record DtoPartido(
        @NotNull String partido,
       @NotNull String bandera
) {
}
