/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erosero.bancontt.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ntt_movimiento")
public class NttMovimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mov_id")
    private Integer movId;

    @Column(name = "mov_fecha")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date movFecha;

    @Column(name = "mov_valor")
    private Double movValor;

    @Column(name = "mov_saldo")
    private Double movSaldo;

    @JoinColumn(name = "mov_cuen_id", referencedColumnName = "cuen_id")
    @ManyToOne(optional = false)
    private NttCuenta movCuenId;

    @JoinColumn(name = "mov_tipo_movimiento", referencedColumnName = "tpm_id")
    @ManyToOne(optional = false)
    private NttTipoMovimiento movTipoMovimiento;

    public NttMovimiento() {
    }

    public Integer getMovId() {
        return movId;
    }

    public void setMovId(Integer movId) {
        this.movId = movId;
    }

    public Date getMovFecha() {
        return movFecha;
    }

    public void setMovFecha(Date movFecha) {
        this.movFecha = movFecha;
    }

    public Double getMovValor() {
        return movValor;
    }

    public void setMovValor(Double movValor) {
        this.movValor = movValor;
    }

    public Double getMovSaldo() {
        return movSaldo;
    }

    public void setMovSaldo(Double movSaldo) {
        this.movSaldo = movSaldo;
    }

    public NttCuenta getMovCuenId() {
        return movCuenId;
    }

    public void setMovCuenId(NttCuenta movCuenId) {
        this.movCuenId = movCuenId;
    }

    public NttTipoMovimiento getMovTipoMovimiento() {
        return movTipoMovimiento;
    }

    public void setMovTipoMovimiento(NttTipoMovimiento movTipoMovimiento) {
        this.movTipoMovimiento = movTipoMovimiento;
    }
}
