package com.elecciones.elecciones.domain.model;


import com.elecciones.elecciones.domain.dto.alumno.DtoAlumno;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "alumno")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlumno;
    private String nombre;
    private String apellido;

    @OneToOne(cascade = CascadeType.REMOVE)
    private Usuario usuario;

    public Alumno(@Valid DtoAlumno dtoAlumno,Usuario usuario) {
        this.nombre=dtoAlumno.nombre();
        this.apellido= dtoAlumno.apellido();
        this.usuario=usuario;
    }
}
