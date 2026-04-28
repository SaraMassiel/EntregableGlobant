package com.example.PaseoApp.controladores;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.example.PaseoApp.modelos.Espacio;
import com.example.PaseoApp.servicios.EspacioServicio;

@RestController
@RequestMapping("/paseoapi/v1/espacios")
public class EspacioControlador {

    @Autowired
    EspacioServicio servicio;

    @PostMapping
    public ResponseEntity<Espacio> controlarGuardado(@RequestBody Espacio datos) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.servicio.guardarEspacioEnBD(datos));
    }

    @PutMapping("/{id}") // Id variable
    public ResponseEntity<Espacio> controlarModificado(@RequestBody Espacio datos, @PathVariable UUID id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.servicio.modificarEspacioEnBD(datos, id));
    }

    @DeleteExchange("/{id}")
    public ResponseEntity<?> controlarEliminado(@PathVariable UUID id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.servicio.eliminarEspacioEnBD(id));
    }

    @GetMapping
    public ResponseEntity<?> controlarListado() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.servicio.buscarEspaciosEnBD());
    }

}
