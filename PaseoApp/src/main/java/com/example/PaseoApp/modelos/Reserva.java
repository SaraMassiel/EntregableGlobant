package com.example.PaseoApp.modelos;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID usuarioId;
    private UUID espacioId;

    private LocalDateTime fecha;
    private Integer tiempo;
    
    public Reserva() {
    }

    public Reserva(UUID id, UUID usuarioId, UUID espacioId, LocalDateTime fecha, Integer tiempo) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.espacioId = espacioId;
        this.fecha = fecha;
        this.tiempo = tiempo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public UUID getUsuarioId() {
        return usuarioId;
    }

    public UUID getEspacioId() {
        return espacioId;
    }

}
