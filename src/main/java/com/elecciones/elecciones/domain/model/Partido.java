package com.elecciones.elecciones.domain.model;


import com.elecciones.elecciones.domain.dto.partido.DtoPartido;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "partido")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPartido;
    private String nombre;
    private String bandera;

    @OneToMany
    private List<Voto> votos;

    public Partido(@Valid DtoPartido dtoPartido) {
        this.nombre= dtoPartido.partido();
        this.bandera = dtoPartido.bandera();
    }
}
