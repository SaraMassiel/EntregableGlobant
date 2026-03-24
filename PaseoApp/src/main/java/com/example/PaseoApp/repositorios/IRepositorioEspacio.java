package com.example.PaseoApp.repositorios;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PaseoApp.modelos.Espacio;

@Repository
public interface IRepositorioEspacio extends JpaRepository<Espacio, UUID>{

}
