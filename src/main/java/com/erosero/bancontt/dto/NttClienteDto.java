package com.erosero.bancontt.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

public class NttClienteDto {

    private Integer persId;
    private String persNombre;
    private String persGenero;
    private String persIdentificacion;
    private Date persFechaNacimiento;
    private String persDireccion;
    private String persTelefono;
    private String cliPassword;
    private boolean cliEstado;

    public Integer getPersId() {
        return persId;
    }

    public void setPersId(Integer persId) {
        this.persId = persId;
    }

    public String getPersNombre() {
        return persNombre;
    }

    public void setPersNombre(String persNombre) {
        this.persNombre = persNombre;
    }

    public String getPersGenero() {
        return persGenero;
    }

    public void setPersGenero(String persGenero) {
        this.persGenero = persGenero;
    }

    public String getPersIdentificacion() {
        return persIdentificacion;
    }

    public void setPersIdentificacion(String persIdentificacion) {
        this.persIdentificacion = persIdentificacion;
    }

    public Date getPersFechaNacimiento() {
        return persFechaNacimiento;
    }

    public void setPersFechaNacimiento(Date persFechaNacimiento) {
        this.persFechaNacimiento = persFechaNacimiento;
    }

    public String getPersDireccion() {
        return persDireccion;
    }

    public void setPersDireccion(String persDireccion) {
        this.persDireccion = persDireccion;
    }

    public String getPersTelefono() {
        return persTelefono;
    }

    public void setPersTelefono(String persTelefono) {
        this.persTelefono = persTelefono;
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
}
