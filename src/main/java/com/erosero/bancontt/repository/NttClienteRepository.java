package com.erosero.bancontt.repository;

import com.erosero.bancontt.entity.NttCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NttClienteRepository extends JpaRepository<NttCliente, Integer> {




}
