package com.grupoigal.anaruth.cedeira;


import java.io.Serializable;

/**
 * Created by Ana Ruth on 03/10/2017.
 */

public class Ficha_Directorio implements Serializable {

    private Integer id_ficha;
    private String titulo;
    private String localizacion;
    private Integer tlf;
    private String email;
    private  String web;
    private String horario;
    private Integer tlf2;

    public Ficha_Directorio(Integer id_ficha, String titulo, String localizacion, Integer tlf, String email, String web, String horario, Integer tlf2) {
        this.id_ficha=id_ficha;
        this.titulo=titulo;
        this.localizacion=localizacion;
        this.tlf=tlf;
        this.email=email;
        this.web=web;
        this.horario=horario;
        this.tlf2=tlf2;
    }

    public Ficha_Directorio() {

        super();
    }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public Integer getTlf() {
        return tlf;
    }

    public void setTlf(Integer tlf) {
        this.tlf = tlf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Integer getTlf2() {
        return tlf2;
    }

    public void setTlf2(Integer tlf2) {
        this.tlf2 = tlf2;
    }

    public Integer getId_ficha() {
        return id_ficha;
    }

    public void setId_ficha(Integer id_ficha) {
        this.id_ficha = id_ficha;
    }
}
