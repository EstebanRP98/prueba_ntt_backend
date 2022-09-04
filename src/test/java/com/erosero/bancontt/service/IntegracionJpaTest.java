package com.erosero.bancontt.service;

import com.erosero.bancontt.entity.*;
import com.erosero.bancontt.repository.*;
import org.checkerframework.checker.nullness.Opt;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IntegracionJpaTest {

    @Autowired
    NttCuentaRepository nttCuentaRepository;
    @Autowired
    NttClienteRepository nttClienteRepository;
    @Autowired
    NttTipoCuentaRepository nttTipoCuentaRepository;
    @Autowired
    NttMovimientoRepository nttMovimientoRepository;
    @Autowired
    NttTipoMovimientoRepository nttTipoMovimientoRepository;

    @Test
    void encontrarCuentaPorId(){
       Optional<NttCuenta> nttCuenta = nttCuentaRepository.findById(1);
       assertTrue(nttCuenta.isPresent());
       assertEquals("2539187665", nttCuenta.get().getCuenNumero());
    }

    @Test
    void saveCuenta(){
        Optional<NttCliente> nttCliente = nttClienteRepository.findById(1);
        Optional<NttTipoCuenta> nttTipoCuenta = nttTipoCuentaRepository.findById(1);
        NttCuenta cuenta = new NttCuenta(2, "2539187668", new BigDecimal("200.00"),
                true, nttCliente.get(), nttTipoCuenta.get() , null);
        NttCuenta nttCuentaGuardada = nttCuentaRepository.save(cuenta);


        assertEquals("2539187668", nttCuentaGuardada.getCuenNumero());
        assertEquals(new BigDecimal("200.00"), nttCuentaGuardada.getCuenSaldoInicial());
    }


    @Test
    void encontrarClientePorId(){
        Optional<NttCliente> nttCliente = nttClienteRepository.findById(1);
        assertTrue(nttCliente.isPresent());
        assertEquals("1708306046", nttCliente.get().getPersIdentificacion());
    }

    @Test
    void saveCliente(){
        Optional<NttCliente> nttCliente = nttClienteRepository.findById(1);

        NttCliente cliente = new NttCliente(2, "Juan", "masculino", "1726442906", new Date(), "remigio",
                "0935467472","pass", true, null );
        NttCliente nttClienteGuardada = nttClienteRepository.save(cliente);


        assertEquals("1726442906", nttClienteGuardada.getPersIdentificacion());
        assertEquals("0935467472", nttClienteGuardada.getPersTelefono());
    }


    @Test
    void encontrarMovimientoPorId(){
        Optional<NttMovimiento> nttMovimiento = nttMovimientoRepository.findById(1);
        assertTrue(nttMovimiento.isPresent());
        assertEquals(new BigDecimal("200.00"), nttMovimiento.get().getMovValor());
    }

    @Test
    void saveMovimiento(){
        Optional<NttCuenta> nttCuenta = nttCuentaRepository.findById(1);
        Optional<NttTipoMovimiento> nttTipoMovimiento = nttTipoMovimientoRepository.findById(1);
        NttMovimiento movimiento = new NttMovimiento(1 , new Date(), new BigDecimal("200"), new BigDecimal("200"), new BigDecimal("0"), nttCuenta.get(), nttTipoMovimiento.get());
        NttMovimiento nttMovimientoGuardada = nttMovimientoRepository.save(movimiento);


        assertEquals(new BigDecimal("200"), nttMovimientoGuardada.getMovValor());
        assertEquals(new BigDecimal("0"), nttMovimientoGuardada.getMovSaldoInicial());
    }





}
