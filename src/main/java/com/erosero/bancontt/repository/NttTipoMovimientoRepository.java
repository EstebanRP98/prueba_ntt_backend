package com.erosero.bancontt.repository;


import com.erosero.bancontt.entity.NttTipoMovimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NttTipoMovimientoRepository extends JpaRepository<NttTipoMovimiento, Integer> {
}
