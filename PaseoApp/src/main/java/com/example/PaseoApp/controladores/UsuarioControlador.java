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

import com.example.PaseoApp.modelos.Usuario;
import com.example.PaseoApp.servicios.UsuarioServicio;

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/paseoapi/v1/usuarios")//Dice que es api, no se que es v1, y tabla usuarios
public class UsuarioControlador {

//Por cada servicio ofrecido, 
//Configuro 1 funcion controladora

@Autowired
UsuarioServicio servicio; 

//Funcion para controlar el guardado
@PostMapping
public ResponseEntity<Usuario>controlarGuardado(@RequestBody Usuario datos){
    return ResponseEntity
    .status(HttpStatus.CREATED)
    .body(this.servicio.guardarUsuarioEnBD(datos));
}

//Funcion para controlar la modificacion
@PutMapping("/{id}")//Id variable
public ResponseEntity<Usuario>controlarModificado(@RequestBody Usuario datos, @PathVariable UUID id){
    return ResponseEntity
    .status(HttpStatus.OK)
    .body(this.servicio.modificarUsuarioEnBD(datos, id));
}

//Funcion para controlar la eliminacion
@DeleteExchange("/{id}")
public ResponseEntity<?>controlarEliminado(@PathVariable UUID id){
    return ResponseEntity
    .status(HttpStatus.OK)
    .body(this.servicio.eliminarUsuarioEnBD(id));
}
//?: cualquier cosa
//Se deberia poner DTO.
//Funcion para controlar la lista
@GetMapping
public ResponseEntity<?>controlarListado(){
    return ResponseEntity
    .status(HttpStatus.OK)
    .body(this.servicio.buscarUsuariosEnBD());
}

}
