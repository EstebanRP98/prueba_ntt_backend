/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erosero.bancontt.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "ntt_cliente")
public class NttCliente extends NttPersona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cli_id")
    private Integer cliId;

    @Column(name = "cli_password")
    private String cliPassword;

    @Column(name = "cli_estado")
    private boolean cliEstado;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenCliId", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<NttCuenta> nttCuenta;

    public NttCliente() {
    }

    public Integer getCliId() {
        return cliId;
    }

    public void setCliId(Integer cliId) {
        this.cliId = cliId;
    }

    public String getCliPassword() {
        return cliPassword;
    }

    public void setCliPassword(String cliPassword) {
        this.cliPassword = cliPassword;
    }

    public boolean isCliEstado() {
        return cliEstado;
    }

    public void setCliEstado(boolean cliEstado) {
        this.cliEstado = cliEstado;
    }

    public List<NttCuenta> getNttCuenta() {
        return nttCuenta;
    }

    public void setNttCuenta(List<NttCuenta> nttCuenta) {
        this.nttCuenta = nttCuenta;
    }
}
