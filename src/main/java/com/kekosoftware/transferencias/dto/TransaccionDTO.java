package com.kekosoftware.transferencias.dto;

import com.kekosoftware.transferencias.entity.enums.EstadoTransaccion;
import com.kekosoftware.transferencias.entity.enums.TipoTransaccion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time. LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransaccionDTO {
    private Long id;
    private TipoTransaccion tipo;
    private Long cuentaOrigenId;
    private Long cuentaDestinoId;
    private BigDecimal monto;
    private EstadoTransaccion estado;
    private String descripcion;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;
}