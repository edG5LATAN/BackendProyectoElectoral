package com.elecciones.elecciones.infra.errores;


import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorErrores {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> nulo(MethodArgumentNotValidException errores){
        var error= errores.getFieldErrors().stream().map(DtoErrores::new).toList();
        return ResponseEntity.ok(error);
    }

    @ExceptionHandler(HttpMessageNotWritableException.class)
    public ResponseEntity<?> respuestaNula(){
        return ResponseEntity.notFound().build();
    }

}
