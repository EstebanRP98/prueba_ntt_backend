/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erosero.bancontt.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "ntt_persona")
@Inheritance(strategy = InheritanceType.JOINED)
public class NttPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pers_id")
    private Integer persId;

    @NotNull(message = "El nombre es requerido")
    @Column(name = "pers_nombre")
    @Pattern(regexp = "^[A-Za-z0-9\\s]+$", message = "El nombre debe tener solo letras")
    private String persNombre;

    @Column(name = "pers_genero")
    private String persGenero;

    @NotNull(message = "El numero de cedula es requerido")
    @Column(name = "pers_identificacion", length = 10, unique = true)
    @Size(min = 10, max = 10, message = "La cedula debe tener 10 digitos")
    @Pattern(regexp = "^[0-9]{10}$", message = "La cedula debe tener 10 digitos")
    private String persIdentificacion;

    @Column(name = "pers_fecha_nacimiento")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date persFechaNacimiento;


    @Basic(optional = false)
    @Column(name = "pers_direccion")
    private String persDireccion;

    @Column(name = "pers_telefono")
    @Pattern(regexp = "^[0-9]{10}$", message = "El telefono debe tener 10 digitos")
    private String persTelefono;


    public NttPersona() {
        super();
    }

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
}
