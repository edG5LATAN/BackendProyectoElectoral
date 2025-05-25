package com.elecciones.elecciones.domain.dto.partido;

import com.elecciones.elecciones.domain.model.Partido;

public record DtoPartidoMostrar(
        Long id,
        String nombre,
        String bandera
) {
    public DtoPartidoMostrar(Partido partido){
        this(partido.getIdPartido(), partido.getNombre(), partido.getBandera());
    }
}
