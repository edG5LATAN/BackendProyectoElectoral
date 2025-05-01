package com.elecciones.elecciones.controller;


import com.elecciones.elecciones.domain.dto.partido.DtoPartido;
import com.elecciones.elecciones.domain.service.ServicePartido;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/partido")
@RequiredArgsConstructor
public class ControllerPartido {

    private final ServicePartido servicePartido;

    @GetMapping("/mostrar")
    public ResponseEntity mostrar(){
        return servicePartido.mostrar();
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity borrar(@PathVariable Long id){
        return servicePartido.borrar(id);
    }

    @GetMapping("/unidad/{id}")
    public ResponseEntity unidad(@PathVariable Long id){
        return servicePartido.unidad(id);
    }

    @PostMapping("/crear")
    public ResponseEntity crear(@RequestBody @Valid DtoPartido dtoPartido){
        return servicePartido.crear(dtoPartido);
    }

}
