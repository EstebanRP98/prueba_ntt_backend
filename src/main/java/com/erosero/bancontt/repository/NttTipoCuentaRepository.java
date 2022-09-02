package com.erosero.bancontt.repository;

import com.erosero.bancontt.entity.NttTipoCuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NttTipoCuentaRepository extends JpaRepository<NttTipoCuenta, Integer> {

    NttTipoCuenta findByTpcId(Integer tpcId);
}
