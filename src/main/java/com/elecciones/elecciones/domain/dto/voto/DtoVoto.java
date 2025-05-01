package com.elecciones.elecciones.domain.dto.voto;


import jakarta.validation.constraints.NotNull;

public record DtoVoto(
       @NotNull Long partido,
       @NotNull Long alumno
) {

}
