package com.example.PaseoApp.servicios;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.PaseoApp.modelos.Espacio;
import com.example.PaseoApp.repositorios.IRepositorioEspacio;

@Service
public class EspacioServicio {

    private IRepositorioEspacio repositorioEspacio;

    public Espacio guardarEspacioEnBD(Espacio datos) {

        if (datos.getNombre().isEmpty() || datos.getNombre().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El campo de nombre no se puede enviar vacio");
        }

        if (datos.getDescripcion().isEmpty() || datos.getDescripcion().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El campo de descripcion no se puede enviar vacio");
        }

        if (datos.getAforo() <= 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El campo de aforo no puede ser menor o igual a cero");
        }

        return this.repositorioEspacio.save(datos);
    }

    public Espacio modificarEspacioEnBD(Espacio datos, UUID id) {
        Optional<Espacio> espacio_que_estoy_buscando = this.repositorioEspacio.findById(id);
        if (!espacio_que_estoy_buscando.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "No se encontro un espacio con ese id");
        }

        Espacio espacio_que_encontre = espacio_que_estoy_buscando.get();

        if (datos.getNombre().isEmpty() || datos.getNombre().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El campo de nombre no se puede enviar vacio");
        }

        if (datos.getDescripcion().isEmpty() || datos.getDescripcion().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El campo de descripcion no se puede enviar vacio");

        }

        espacio_que_encontre.setNombre(datos.getNombre());
        espacio_que_encontre.setDescripcion(datos.getDescripcion());
        return this.repositorioEspacio.save(espacio_que_encontre);
    }

    public boolean eliminarEspacioEnBD(UUID id) {
        Optional<Espacio> espacio_que_estoy_buscando = this.repositorioEspacio.findById(id);
        if (!espacio_que_estoy_buscando.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "El espacio que quieres eliminar, no se encuentra registrado en la BD");
        }
        this.repositorioEspacio.deleteById(id);

        return true;
    }

    public List<Espacio> buscarEspaciosEnBD() {
        List<Espacio> espaciosEncontrados = this.repositorioEspacio.findAll();

        return espaciosEncontrados;
    }

}
