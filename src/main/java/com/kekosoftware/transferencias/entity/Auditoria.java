package com.kekosoftware.transferencias.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate. annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "auditoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Auditoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaccion_id")
    private Transaccion transaccion;
    
    @Column(nullable = false, length = 50)
    private String evento;
    
    @Column(name = "datos_antes", columnDefinition = "JSON")
    private String datosAntes;
    
    @Column(name = "datos_despues", columnDefinition = "JSON")
    private String datosDespues;
    
    @Column(length = 100)
    private String usuario;
    
    @Column(name = "ip_address", length = 45)
    private String ipAddress;
    
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime timestamp;
}