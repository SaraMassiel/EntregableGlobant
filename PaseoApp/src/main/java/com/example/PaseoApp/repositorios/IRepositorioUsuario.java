package com.example.PaseoApp.repositorios;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PaseoApp.modelos.Usuario;
import java.util.List;


@Repository
public interface IRepositorioUsuario extends JpaRepository<Usuario, UUID> {
//(Lo que devuelve)Optional<nombreTB> (funcion JPA recomendacion= findBycampo(parametros)
//Funcion tiene parentesis en el nombre, y tiene verbo.
    Optional<Usuario> findByCorreo(String correo);

}
