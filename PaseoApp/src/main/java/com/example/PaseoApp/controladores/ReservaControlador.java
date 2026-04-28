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

import com.example.PaseoApp.modelos.Reserva;
import com.example.PaseoApp.servicios.ReservaServicio;

@RestController
@RequestMapping("/paseoapi/v1/reservas")
public class ReservaControlador {

    @Autowired
    ReservaServicio servicio;

    @PostMapping
    public ResponseEntity<Reserva> controlarGuardado(@RequestBody Reserva datos) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.servicio.guardarReservaEnBD(datos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> controlarModificado(@RequestBody Reserva datos, @PathVariable UUID id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.servicio.modificarReservaEnBD(datos, id));
    }

    @DeleteExchange("/{id}")
    public ResponseEntity<?> controlarEliminado(@PathVariable UUID id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.servicio.eliminarReservaEnBD(id));
    }

    @GetMapping
    public ResponseEntity<?> controlarListado() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.servicio.buscarReservasEnBD());
    }

}
