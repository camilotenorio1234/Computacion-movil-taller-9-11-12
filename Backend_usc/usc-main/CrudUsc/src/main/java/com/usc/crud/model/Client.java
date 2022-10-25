package com.usc.crud.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Historia_cliente")
public class Client {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String Tipo_id;
    private Long id_docu;
    private String nombres;
    private String Primer_apellido;
    private String Segundo_apellido;
    private String sexo;
    private int edad_actual;
    private String Estado_civil;
    private String ocupacion;
    private String Dir_residencia;
    private Long num_tel;
    private String Lugar_de_residencia;
    private String Motivo_consulta;
    private String email;


    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "Clients_new",
            joinColumns = {@JoinColumn(name = "Client_id")},
            inverseJoinColumns = {@JoinColumn(name = "Empleado_id")}
    )
    private Set<Empleado> empleados;

    public Set<Empleado> getEmpleados() {
        return empleados;
    }

    public Client() {

    }

    public Client(Long id, String tipo_id, Long id_docu, String nombres, String primer_apellido, String segundo_apellido, String sexo, int edad_actual, String estado_civil, String ocupacion, String dir_residencia, Long num_tel, String lugar_de_residencia, String motivo_consulta, String email, String password, Set<Empleado> empleados) {
        this.id = id;
        Tipo_id = tipo_id;
        this.id_docu = id_docu;
        this.nombres = nombres;
        Primer_apellido = primer_apellido;
        Segundo_apellido = segundo_apellido;
        this.sexo = sexo;
        this.edad_actual = edad_actual;
        Estado_civil = estado_civil;
        this.ocupacion = ocupacion;
        Dir_residencia = dir_residencia;
        this.num_tel = num_tel;
        Lugar_de_residencia = lugar_de_residencia;
        Motivo_consulta = motivo_consulta;
        this.email = email;
        this.empleados = empleados;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo_id() {
        return Tipo_id;
    }

    public void setTipo_id(String tipo_id) {
        Tipo_id = tipo_id;
    }

    public Long getId_docu() {
        return id_docu;
    }

    public void setId_docu(Long id_docu) {
        this.id_docu = id_docu;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPrimer_apellido() {
        return Primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        Primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return Segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        Segundo_apellido = segundo_apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad_actual() {
        return edad_actual;
    }

    public void setEdad_actual(int edad_actual) {
        this.edad_actual = edad_actual;
    }

    public String getEstado_civil() {
        return Estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        Estado_civil = estado_civil;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getDir_residencia() {
        return Dir_residencia;
    }

    public void setDir_residencia(String dir_residencia) {
        Dir_residencia = dir_residencia;
    }

    public Long getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(Long num_tel) {
        this.num_tel = num_tel;
    }

    public String getLugar_de_residencia() {
        return Lugar_de_residencia;
    }

    public void setLugar_de_residencia(String lugar_de_residencia) {
        Lugar_de_residencia = lugar_de_residencia;
    }

    public String getMotivo_consulta() {
        return Motivo_consulta;
    }

    public void setMotivo_consulta(String motivo_consulta) {
        Motivo_consulta = motivo_consulta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }
}
