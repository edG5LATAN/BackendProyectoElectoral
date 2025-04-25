package com.elecciones.elecciones.controller;

import com.elecciones.elecciones.domain.dto.usuario.DtoUsuario;
import com.elecciones.elecciones.domain.service.ServiceUsuario;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/usuario")
@RequiredArgsConstructor
public class ControllerUsuario {

    private final ServiceUsuario serviceUsuario;

    @GetMapping("/mostrar")
    public ResponseEntity mostrar(){
        return serviceUsuario.mostrar();
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity borrar(@PathVariable Long id){
        return serviceUsuario.borrar(id);
    }

    @GetMapping("/unidad/{id}")
    public ResponseEntity unidad(@PathVariable Long id){
        return serviceUsuario.unidad(id);
    }

    @PostMapping("/crear")
    public ResponseEntity crear(@RequestBody @Valid DtoUsuario dtoUsuario){
        return serviceUsuario.crear(dtoUsuario);
    }
}
