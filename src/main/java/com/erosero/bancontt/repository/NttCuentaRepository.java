package com.erosero.bancontt.repository;

import com.erosero.bancontt.entity.NttCuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NttCuentaRepository extends JpaRepository<NttCuenta, Integer> {
}
