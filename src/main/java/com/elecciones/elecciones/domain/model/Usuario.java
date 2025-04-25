package com.elecciones.elecciones.domain.model;

import com.elecciones.elecciones.domain.dto.usuario.DtoUsuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String correo;
    private String password;


    public Usuario(@Valid DtoUsuario dtoUsuario) {
        this.correo= dtoUsuario.correo();
        this.password= dtoUsuario.clave();
    }
}
