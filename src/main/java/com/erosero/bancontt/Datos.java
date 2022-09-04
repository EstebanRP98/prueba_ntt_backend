package com.erosero.bancontt;

import com.erosero.bancontt.entity.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Datos {
    public static final NttCliente cliente = new NttCliente(1, "Diego", "masculino", "1708306046", new Date(), "remigio",
            "0935467471","moncho", true, null );
    public static final NttCuenta cuenta = new NttCuenta(1, "2539187665", new BigDecimal("200.00"),
            true, cliente, null , null);
    public static final NttMovimiento movimiento = new NttMovimiento(1 , new Date(), new BigDecimal("200"), new BigDecimal("200"), new BigDecimal("0"), cuenta, null);
}
