package com.kekosoftware.transferencias.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math. BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrearCuentaRequest {
    
    @NotBlank(message = "El número de cuenta es obligatorio")
    @Size(min = 5, max = 20, message = "El número de cuenta debe tener entre 5 y 20 caracteres")
    private String numeroCuenta;
    
    @NotBlank(message = "El titular es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre del titular debe tener entre 3 y 100 caracteres")
    private String titular;
    
    @NotNull(message = "El saldo inicial es obligatorio")
    @DecimalMin(value = "0.0", inclusive = true, message = "El saldo debe ser mayor o igual a 0")
    private BigDecimal saldoInicial;
    
    @Pattern(regexp = "USD|EUR|MXN", message = "Moneda no válida.  Opciones: USD, EUR, MXN")
    private String moneda = "USD";
}