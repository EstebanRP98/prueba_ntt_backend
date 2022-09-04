package com.erosero.bancontt.service;

import com.erosero.bancontt.Datos;
import com.erosero.bancontt.entity.NttCuenta;
import com.erosero.bancontt.repository.NttCuentaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringbootTestApplicationTests {

    NttCuentaRepository nttCuentaRepository;
    NttCuentaService nttCuentaService;

    @BeforeEach
    void setUp() {
        nttCuentaRepository = mock(NttCuentaRepository.class);
        nttCuentaService = new NttCuentaService(nttCuentaRepository);
    }

    @Test
    void contextLoad() throws Exception {
        NttCuenta nttCuenta = nttCuentaService.encontrarCuentaPorId(1);
        when(nttCuentaService.encontrarCuentaPorId(1)).thenReturn(Datos.cuenta);
    }

}
