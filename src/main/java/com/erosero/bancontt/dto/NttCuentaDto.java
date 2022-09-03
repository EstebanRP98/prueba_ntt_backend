package com.erosero.bancontt.dto;

import com.erosero.bancontt.entity.NttCliente;
import com.erosero.bancontt.entity.NttTipoCuenta;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class NttCuentaDto {

    private Integer cuenId;
    private String cuenNumero;
    private BigDecimal cuenSaldoInicial;
    private boolean cuenEstado;
    private Integer cuenCliId;
    private Integer cuenTipoCuenta;

    public Integer getCuenId() {
        return cuenId;
    }

    public void setCuenId(Integer cuenId) {
        this.cuenId = cuenId;
    }

    public String getCuenNumero() {
        return cuenNumero;
    }

    public void setCuenNumero(String cuenNumero) {
        this.cuenNumero = cuenNumero;
    }

    public BigDecimal getCuenSaldoInicial() {
        return cuenSaldoInicial;
    }

    public void setCuenSaldoInicial(BigDecimal cuenSaldoInicial) {
        this.cuenSaldoInicial = cuenSaldoInicial;
    }

    public boolean isCuenEstado() {
        return cuenEstado;
    }

    public void setCuenEstado(boolean cuenEstado) {
        this.cuenEstado = cuenEstado;
    }

    public Integer getCuenCliId() {
        return cuenCliId;
    }

    public void setCuenCliId(Integer cuenCliId) {
        this.cuenCliId = cuenCliId;
    }

    public Integer getCuenTipoCuenta() {
        return cuenTipoCuenta;
    }

    public void setCuenTipoCuenta(Integer cuenTipoCuenta) {
        this.cuenTipoCuenta = cuenTipoCuenta;
    }
}
