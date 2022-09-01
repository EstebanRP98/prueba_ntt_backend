/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erosero.bancontt.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "ntt_tipo_cuenta")
public class NttTipoCuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tpc_id")
    private Integer tpcId;

    @Column(name = "tpc_descripcion")
    private String tpcDescripcion;

    public NttTipoCuenta() {
    }

    public Integer getTpcId() {
        return tpcId;
    }

    public void setTpcId(Integer tpcId) {
        this.tpcId = tpcId;
    }

    public String getTpcDescripcion() {
        return tpcDescripcion;
    }

    public void setTpcDescripcion(String tpcDescripcion) {
        this.tpcDescripcion = tpcDescripcion;
    }
}
