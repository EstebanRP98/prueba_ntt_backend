package com.erosero.bancontt.repository;

import com.erosero.bancontt.entity.NttMovimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NttMovimientoRepository extends JpaRepository<NttMovimiento, Integer> {

    @Query(value = "select m " +
            "from NttMovimiento m " +
            "where m.movFecha between :fechaInicial and :fechaFinal ")
    List<NttMovimiento> encontrarMovimientosPorFechas(Date fechaInicial, Date fechaFinal);

}
