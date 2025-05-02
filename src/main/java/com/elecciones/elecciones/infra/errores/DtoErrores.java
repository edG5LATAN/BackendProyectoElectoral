package com.elecciones.elecciones.infra.errores;

import org.springframework.validation.FieldError;

public record DtoErrores(
        String error,
        String mensaje
) {
    public DtoErrores(FieldError error){
        this(error.getField(),error.getDefaultMessage());
    }

}
