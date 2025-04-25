package com.elecciones.elecciones.controller;


import com.elecciones.elecciones.domain.dto.voto.DtoVoto;
import com.elecciones.elecciones.domain.service.ServiceVoto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/voto")
@RequiredArgsConstructor
public class ControllerVoto {

    private final ServiceVoto serviceVoto;

    @GetMapping("/mostrar")
    public ResponseEntity mostrar(){
        return serviceVoto.mostrar();
    }

    @GetMapping("/unidad/{id}")
    public ResponseEntity unidad(@PathVariable Long id){
        return serviceVoto.unidad(id);
    }

    @DeleteMapping("/borrar")
    public ResponseEntity borrar(@PathVariable Long id){
        return serviceVoto.borrar(id);
    }

    @PostMapping("/crear")
    public ResponseEntity crear(@RequestBody DtoVoto dtoVoto){
        return serviceVoto.crear(dtoVoto);
    }

}
