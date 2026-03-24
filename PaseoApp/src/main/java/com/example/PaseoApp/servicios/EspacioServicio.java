package com.example.PaseoApp.servicios;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.PaseoApp.modelos.Espacio;
import com.example.PaseoApp.modelos.Usuario;
import com.example.PaseoApp.repositorios.IRepositorioEspacio;
import com.example.PaseoApp.repositorios.IRepositorioReserva;

@Service
public class EspacioServicio {


private IRepositorioEspacio repositorioEspacio;

    public boolean guardarEspacioEnBD(Espacio datos){}

    public boolean modificarEspacioEnBD(Espacio datos, UUID id){}

    public boolean eliminarEspacioEnBD(UUID id){}

    public boolean buscarEspaciosEnBD(){}


}
