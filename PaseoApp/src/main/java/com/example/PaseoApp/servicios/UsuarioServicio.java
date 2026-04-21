package com.example.PaseoApp.servicios;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.PaseoApp.modelos.Usuario;
import com.example.PaseoApp.repositorios.IRepositorioUsuario;

@Service
public class UsuarioServicio {


    //Intectando una dependencia del repositorio de usuario. Autowired es mala practica
    @Autowired
    //Listado de servicios que ofrecemos
    private IRepositorioUsuario repositorioUsuario;
    
//Se rompe principio de responsabilidd unica.
    public Usuario guardarUsuarioEnBD(Usuario datos){
    //validar que datos existen y si cumplen reglas de negocio
    //guardar fatos

    //1. Validar que el correo no se haya guardado antes
    if(repositorioUsuario.findByCorreo(datos.getCorreo()).isPresent()){
        throw new ResponseStatusException(
            HttpStatus.CONFLICT, "Ya existe un usuario registrado con ese correo"
        );


    }
    if (datos.getNombre().isEmpty()||datos.getNombre().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, 
                "El campo de nombre no se puede enviar vacio"
            );
        }

    if (datos.getContraseña().length()<6) {
        throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST, 
            "La contraseña debe tener al menos 6 caracteres"
        );
    }
    //Si paso la zona de validaciones procedo a preparar la receta (ejecuto la query que se necesita)
    //return false;
    return this.repositorioUsuario.save(datos);
    }

    public Usuario modificarUsuarioEnBD(Usuario datos, UUID id){
        //validar que se envian datos y que cumplen reglas de negocio
        //modificar datos
        //1. Buscar si el usuario existe en la base de datos
        Optional<Usuario> usuario_que_estoy_buscando=this.repositorioUsuario.findById(id);
        if (!usuario_que_estoy_buscando.isPresent()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No se encontro un usuario registrado con ese id"
             );
        }
        Usuario usuario_que_encontre=usuario_que_estoy_buscando.get();

        //2.Validar la info nueva que manda el cliente
        if (datos.getNombre().isEmpty()||datos.getNombre().isBlank()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, 
                "El campo de nombre no se puede enviar vacio"
            );
        }
        //3. Ejecutar el nuevo guardado y retornar
        usuario_que_encontre.setNombre(datos.getNombre());
        return this.repositorioUsuario.save(usuario_que_encontre);
    
    }

    public boolean eliminarUsuarioEnBD(UUID id){
        //validar que se envia un id y que existe en la base de datos
        //eliminar datos
        return false;
    }

    public List<Usuario> buscarUsuariosEnBD(){
        //Dependiendo del parametro de busqueda, validar
        //buscar datos y devolverlos
        //List<Para> nombre = lo que lo hace
        List<Usuario> usuariosEncontrados = this.repositorioUsuario.findAll();

        return usuariosEncontrados;
    }

}
