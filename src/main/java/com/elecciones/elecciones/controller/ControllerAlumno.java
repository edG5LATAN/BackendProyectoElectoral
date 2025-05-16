package com.elecciones.elecciones.controller;


import com.elecciones.elecciones.domain.dto.alumno.DtoAlumno;
import com.elecciones.elecciones.domain.dto.usuario.DtoUsuario;
import com.elecciones.elecciones.domain.model.Usuario;
import com.elecciones.elecciones.domain.service.ServiceAlumno;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/alumno/")
@RequiredArgsConstructor
public class ControllerAlumno {

    private final ServiceAlumno serviceAlumno;

    @GetMapping("/mostrar")
    public ResponseEntity<?> mostrar(){
        return serviceAlumno.mostrar();
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id){
        return serviceAlumno.borrar(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody @Valid DtoAlumno dtoAlumno){
        return serviceAlumno.crear(dtoAlumno);
    }

    @GetMapping("/unidad/{id}")
    public ResponseEntity<?> unidad(@PathVariable Long id){
        return serviceAlumno.unidad(id);
    }

    @GetMapping("/porCorreo/{correo}")
    public ResponseEntity alumnoPorCorreo(@PathVariable @Valid String correo){
        return serviceAlumno.alumnoPorCorreo(correo);
    };


}
