package com.itsqmet.talle2_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "cliente")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El campo cédula no puede estar vacío")
    @Pattern(regexp = "^{10}$", message = "La cédula debe tener exactamente 10 dígitos numéricos")
    private String cedula;

    @NotBlank(message = "El campo nombre no puede estar vacio")
    @Size(min = 4, message = "El nombre no cumple con el rango minimo de 5 caracteres")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "El campo apellido no puede estar vacio")
    @Size(min = 4, message = "El nombre no cumple con el rango minimo de 5 caracteres")
    @Column(nullable = false)
    private String apellido;

    @NotBlank(message = "El campo email no puede estar vacio")
    @Email(message = "El email no tiene el formato correcto")
    private String correo;

    @Pattern(regexp = "^{10}$", message = "El teléfono debe tener exactamente 10 dígitos numéricos")
    private String telefono;

    @NotNull(message = "El campo dirección no puede estar vacio")
    private String direccion;

    public Perfil() {
    }

    public Perfil(Long id, String cedula, String apellido, String nombre, String correo, String telefono, String direccion) {
        this.id = id;
        this.cedula = cedula;
        this.apellido = apellido;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
