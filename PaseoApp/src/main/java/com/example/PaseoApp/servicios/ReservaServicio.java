package com.example.PaseoApp.servicios;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.PaseoApp.modelos.Usuario;
import com.example.PaseoApp.repositorios.IRepositorioReserva;
import com.example.PaseoApp.repositorios.IRepositorioUsuario;

@Service
public class ReservaServicio {

private IRepositorioReserva repositorioReserva;

    public boolean guardarReservaEnBD(Usuario datos){}

    public boolean modificarReservaEnBD(Usuario datos, UUID id){}

    public boolean eliminarReservaEnBD(UUID id){}

    public boolean buscarReservasEnBD(){}


}
