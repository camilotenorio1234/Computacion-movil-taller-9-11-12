package com.proyect_chidos.app_sonripluss_app.dto;

public class Client_New {
    private String tipo_id;
    private Long id_docu;
    private String nombres;
    private String primer_apellido;
    private String segundo_apellido;
    private String sexo;
    private int edad_actual;
    private String estado_civil;
    private String ocupacion;
    private String dir_residencia;
    private Long num_tel;
    private String lugar_de_residencia;
    private String motivo_consulta;
    private String email;

    public Client_New(String tipo_selec, Long aLong, String s) {
    }

    public Client_New(String tipo_id, Long id_docu, String nombres, String primer_apellido, String segundo_apellido, String sexo, int edad_actual, String estado_civil, String ocupacion, String dir_residencia, Long num_tel, String lugar_de_residencia, String motivo_consulta, String email) {
        this.tipo_id = tipo_id;
        this.id_docu = id_docu;
        this.nombres = nombres;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.sexo = sexo;
        this.edad_actual = edad_actual;
        this.estado_civil = estado_civil;
        this.ocupacion = ocupacion;
        this.dir_residencia = dir_residencia;
        this.num_tel = num_tel;
        this.lugar_de_residencia = lugar_de_residencia;
        this.motivo_consulta = motivo_consulta;
        this.email = email;
    }

    public String getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(String tipo_id) {
        this.tipo_id = tipo_id;
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
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
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
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getDir_residencia() {
        return dir_residencia;
    }

    public void setDir_residencia(String dir_residencia) {
        this.dir_residencia = dir_residencia;
    }

    public Long getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(Long num_tel) {
        this.num_tel = num_tel;
    }

    public String getLugar_de_residencia() {
        return lugar_de_residencia;
    }

    public void setLugar_de_residencia(String lugar_de_residencia) {
        this.lugar_de_residencia = lugar_de_residencia;
    }

    public String getMotivo_consulta() {
        return motivo_consulta;
    }

    public void setMotivo_consulta(String motivo_consulta) {
        this.motivo_consulta = motivo_consulta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
