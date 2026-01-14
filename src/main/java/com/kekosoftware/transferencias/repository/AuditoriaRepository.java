package com.kekosoftware.transferencias.repository;

import com. kekosoftware.transferencias.entity.Auditoria;
import org.springframework.data. jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {
    
    List<Auditoria> findByTransaccionIdOrderByTimestampAsc(Long transaccionId);
    
    List<Auditoria> findByEvento(String evento);
}