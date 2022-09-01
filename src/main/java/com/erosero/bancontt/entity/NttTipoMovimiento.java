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
@Table(name = "ntt_tipo_movimiento")
public class NttTipoMovimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tpm_id")
    private Integer tpmId;

    @Column(name = "tpm_descripcion")
    private String tpmDescripcion;

    public NttTipoMovimiento() {
    }

    public Integer getTpmId() {
        return tpmId;
    }

    public void setTpmId(Integer tpmId) {
        this.tpmId = tpmId;
    }

    public String getTpmDescripcion() {
        return tpmDescripcion;
    }

    public void setTpmDescripcion(String tpmDescripcion) {
        this.tpmDescripcion = tpmDescripcion;
    }
}
