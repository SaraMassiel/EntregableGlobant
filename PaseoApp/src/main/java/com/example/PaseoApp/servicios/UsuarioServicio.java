package com.example.PaseoApp.servicios;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PaseoApp.modelos.Usuario;
import com.example.PaseoApp.repositorios.IRepositorioUsuario;

@Service
public class UsuarioServicio {


    //Intectando una dependencia del repositorio de usuario. Autowired es mala practica
    @Autowired
    //Listado de servicios que ofrecemos
    private IRepositorioUsuario repositorioUsuario;
    
//Se rompe principio de responsabilidd unica.
    public boolean guardarUsuarioEnBD(Usuario datos){
        //validar que datos existen y si cumplen reglas de negocio
    //guardar fatos
    return false;
    }

    public boolean modificarUsuarioEnBD(Usuario datos, UUID id){
        //validar que se envian datos y que cumplen reglas de negocio
        //modificar datos
        return false;
    }

    public boolean eliminarUsuarioEnBD(UUID id){
        //validar que se envia un id y que existe en la base de datos
        //eliminar datos
        return false;
    }

    public boolean buscarUsuariosEnBD(){
        //Dependiendo del parametro de busqueda, validar
        //buscar datos y devolverlos
        return false;
    }

}
