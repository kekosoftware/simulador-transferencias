package com.kekosoftware.transferencias.repository;

import com.kekosoftware.transferencias.entity.Transaccion;
import com.kekosoftware.transferencias.entity.enums.EstadoTransaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
    
    List<Transaccion> findByCuentaOrigenIdOrCuentaDestinoId(Long origenId, Long destinoId);
    
    List<Transaccion> findByEstado(EstadoTransaccion estado);
}