package com.elecciones.elecciones.domain.model;


import com.elecciones.elecciones.domain.dto.voto.DtoVoto;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "voto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCodigo;

    @OneToOne
    private Alumno alumno;
    @ManyToOne
    private Partido partido;

    public Voto(Partido partido, Alumno alumno) {
        this.alumno=alumno;
        this.partido=partido;
    }
}
