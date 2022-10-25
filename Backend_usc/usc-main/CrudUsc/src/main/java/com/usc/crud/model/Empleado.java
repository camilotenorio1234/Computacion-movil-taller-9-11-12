package com.usc.crud.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="empleado")

public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    private String apellido;
    private Long CCid;
    private Long num_tel;

    private String email;
    private String password;
    @ManyToMany(mappedBy = "empleados")
    private Set<Client> client;

    public Set<Client> getClient() {
        return client;
    }

    public void setClient(Set<Client> client) {
        this.client = client;
    }

    public Empleado() {

    }

    public Empleado(Long id, String nombre, String apellido, Long CCid, Long num_tel, String email, String password, Set<Client> client) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.CCid = CCid;
        this.num_tel = num_tel;
        this.email = email;
        this.password = password;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getNum_tel() {
        return num_tel;
    }

    public Long getCCid() {
        return CCid;
    }

    public void setCCid(Long CCid) {
        this.CCid = CCid;
    }

    public void setNum_tel(Long num_tel) {
        this.num_tel = num_tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
