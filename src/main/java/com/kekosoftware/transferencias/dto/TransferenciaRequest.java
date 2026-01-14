package com.kekosoftware.transferencias.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferenciaRequest {
    
    @NotNull(message = "La cuenta de origen es obligatoria")
    private Long cuentaOrigenId;
    
    @NotNull(message = "La cuenta de destino es obligatoria")
    private Long cuentaDestinoId;
    
    @NotNull(message = "El monto es obligatorio")
    @DecimalMin(value = "0.01", message = "El monto debe ser mayor a 0")
    private BigDecimal monto;
    
    @Size(max = 500, message = "La descripción no puede exceder 500 caracteres")
    private String descripcion;
}