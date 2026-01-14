package com.kekosoftware.transferencias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuentaDTO {
    private Long id;
    private String numeroCuenta;
    private String titular;
    private BigDecimal saldo;
    private String moneda;
    private Boolean activa;
    private LocalDateTime createdAt;
}