/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erosero.bancontt.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author david
 */
@Entity
@Table(name = "ntt_cuenta")
public class NttCuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cuen_id")
    private Integer cuenId;

    @NotNull(message = "El numero de cuenta es requerido")
    @Column(name = "cuen_numero", length = 10, unique = true)
    @Size(min = 10, max = 10, message = "La cuenta debe tener 10 digitos")
    @Pattern(regexp = "^[0-9]{10}$", message = "La cuenta debe tener 10 digitos")
    private String cuenNumero;

    @Column(name = "cuen_saldo_inicial")
    private Double cuenSaldoInicial;

    @Column(name = "cuen_estado")
    private boolean cuenEstado;

    @JoinColumn(name = "cuen_cli_id", referencedColumnName = "cli_id")
    @ManyToOne(optional = false)
    private NttCliente cuenCliId;

    @JoinColumn(name = "cuen_tipo_cuenta", referencedColumnName = "tpc_id")
    @ManyToOne(optional = false)
    private NttTipoCuenta cuenTipoCuenta;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movCuenId", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<NttMovimiento> nttMovimiento;

    public NttCuenta() {
    }

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

    public Double getCuenSaldoInicial() {
        return cuenSaldoInicial;
    }

    public void setCuenSaldoInicial(Double cuenSaldoInicial) {
        this.cuenSaldoInicial = cuenSaldoInicial;
    }

    public boolean isCuenEstado() {
        return cuenEstado;
    }

    public void setCuenEstado(boolean cuenEstado) {
        this.cuenEstado = cuenEstado;
    }

    public NttCliente getCuenCliId() {
        return cuenCliId;
    }

    public void setCuenCliId(NttCliente cuenCliId) {
        this.cuenCliId = cuenCliId;
    }

    public NttTipoCuenta getCuenTipoCuenta() {
        return cuenTipoCuenta;
    }

    public void setCuenTipoCuenta(NttTipoCuenta cuenTipoCuenta) {
        this.cuenTipoCuenta = cuenTipoCuenta;
    }

    public List<NttMovimiento> getNttMovimiento() {
        return nttMovimiento;
    }

    public void setNttMovimiento(List<NttMovimiento> nttMovimiento) {
        this.nttMovimiento = nttMovimiento;
    }
}
