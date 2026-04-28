package com.example.PaseoApp.servicios;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.PaseoApp.modelos.Espacio;
import com.example.PaseoApp.modelos.Reserva;
import com.example.PaseoApp.modelos.Usuario;
import com.example.PaseoApp.repositorios.IRepositorioEspacio;
import com.example.PaseoApp.repositorios.IRepositorioReserva;
import com.example.PaseoApp.repositorios.IRepositorioUsuario;

@Service
public class ReservaServicio {

    @Autowired
    private IRepositorioReserva repositorioReserva;

    @Autowired
    private IRepositorioUsuario repositorioUsuario;

    @Autowired
    private IRepositorioEspacio repositorioEspacio;


    public Reserva guardarReservaEnBD(Reserva datos) {

        if (datos.getFecha() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El campo de fecha no se puede enviar vacio");
        }

        if (datos.getTiempo() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El campo de tiempo no se puede enviar vacio");
        }

        if (datos.getId() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El usuario no existe");
        }

        Optional<Usuario> usuario_que_estoy_buscando = this.repositorioUsuario.findById(datos.getUsuarioId());
        if (!usuario_que_estoy_buscando.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No se encontro un usuario registrado con ese id");
        }

        if (datos.getEspacioId() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El espacio no existe");
        }
        Optional<Espacio> espacio_que_estoy_buscando = this.repositorioEspacio.findById(datos.getEspacioId());
        if (!espacio_que_estoy_buscando.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No se encontro un espacio registrado con ese id");
        }

        return this.repositorioReserva.save(datos);
    }

    public Reserva modificarReservaEnBD(Reserva datos, UUID id) {
        Optional<Reserva> reserva_que_estoy_buscando = this.repositorioReserva.findById(id);
        if (!reserva_que_estoy_buscando.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "No se encontro una reserva con ese id");
        }

        Reserva reserva_que_encontre = reserva_que_estoy_buscando.get();

        if (datos.getFecha() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El campo de fecha no se puede enviar vacio");
        }

        if (datos.getTiempo() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El campo de tiempo no se puede enviar vacio");
        }

        reserva_que_encontre.setFecha(datos.getFecha());
        reserva_que_encontre.setTiempo(datos.getTiempo());
        return this.repositorioReserva.save(reserva_que_encontre);
    }

    public boolean eliminarReservaEnBD(UUID id) {
        Optional<Reserva> reserva_que_estoy_buscando = this.repositorioReserva.findById(id);
        if (!reserva_que_estoy_buscando.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "La reserva que quieres eliminar, no se encuentra registrado en la BD");
        }
        this.repositorioReserva.deleteById(id);

        return true;
    }

    public List<Reserva> buscarReservasEnBD() {
        List<Reserva> reservasEncontradas = this.repositorioReserva.findAll();

        return reservasEncontradas;
    }

}
