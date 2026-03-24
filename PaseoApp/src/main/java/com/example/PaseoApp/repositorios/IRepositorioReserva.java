package com.example.PaseoApp.repositorios;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PaseoApp.modelos.Reserva;

@Repository
public interface IRepositorioReserva extends JpaRepository<Reserva, UUID>{

}
