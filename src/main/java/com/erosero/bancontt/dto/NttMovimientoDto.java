package com.erosero.bancontt.dto;

import com.erosero.bancontt.entity.NttCuenta;
import com.erosero.bancontt.entity.NttTipoMovimiento;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Date;

public class NttMovimientoDto {

    private BigDecimal movValor;
    private Integer movCuenId;
    private Integer movTipoMovimiento;


    public BigDecimal getMovValor() {
        return movValor;
    }

    public void setMovValor(BigDecimal movValor) {
        this.movValor = movValor;
    }

    public Integer getMovCuenId() {
        return movCuenId;
    }

    public void setMovCuenId(Integer movCuenId) {
        this.movCuenId = movCuenId;
    }

    public Integer getMovTipoMovimiento() {
        return movTipoMovimiento;
    }

    public void setMovTipoMovimiento(Integer movTipoMovimiento) {
        this.movTipoMovimiento = movTipoMovimiento;
    }
}
