package com.example.PaseoApp.servicios;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.PaseoApp.modelos.Reserva;
import com.example.PaseoApp.repositorios.IRepositorioReserva;

@Service
public class ReservaServicio {

private IRepositorioReserva repositorioReserva;

    public Reserva guardarReservaEnBD(Reserva datos){
        
        if (datos.getFecha() == null) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, 
                "El campo de fecha no se puede enviar vacio"
            );
        }

        if (datos.getTiempo() == null) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, 
                "El campo de tiempo no se puede enviar vacio"
            );
        }

        return repositorioReserva.save(datos);
    }

    public Reserva modificarReservaEnBD(Reserva datos, UUID id){
        Optional<Reserva> reserva_que_estoy_buscando=this.repositorioReserva.findById(id);
        if (!reserva_que_estoy_buscando.isPresent()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, 
                "No se encontro una reserva con ese id"
            );
    }

    Reserva reserva_que_encontre=reserva_que_estoy_buscando.get();

    if (datos.getFecha() == null) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, 
                "El campo de fecha no se puede enviar vacio"
            );
        }

        if (datos.getTiempo() == null) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, 
                "El campo de tiempo no se puede enviar vacio"
            );
        }

        reserva_que_encontre.setFecha(datos.getFecha());
        reserva_que_encontre.setTiempo(datos.getTiempo());
        return this.repositorioReserva.save(reserva_que_encontre);


    public boolean eliminarReservaEnBD(UUID id){
        return false;
    }

    public boolean buscarReservasEnBD(){
        return false;
    }


}
