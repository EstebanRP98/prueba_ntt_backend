/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erosero.bancontt.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "ntt_cliente")
@PrimaryKeyJoinColumn(name = "cli_id",referencedColumnName = "pers_id")
public class NttCliente extends NttPersona implements Serializable {

    @Column(name = "cli_password")
    private String cliPassword;

    @Column(name = "cli_estado")
    private boolean cliEstado;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenCliId", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<NttCuenta> nttCuenta;

    public NttCliente() {
        super();
    }

    public NttCliente(Integer persId, String persNombre, String persGenero, String persIdentificacion, Date persFechaNacimiento, String persDireccion, String persTelefono, String cliPassword, boolean cliEstado, List<NttCuenta> nttCuenta) {
        super(persId, persNombre, persGenero, persIdentificacion, persFechaNacimiento, persDireccion, persTelefono);
        this.cliPassword = cliPassword;
        this.cliEstado = cliEstado;
        this.nttCuenta = nttCuenta;
    }

    public NttCliente(String cliPassword, boolean cliEstado, List<NttCuenta> nttCuenta) {
        this.cliPassword = cliPassword;
        this.cliEstado = cliEstado;
        this.nttCuenta = nttCuenta;
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
