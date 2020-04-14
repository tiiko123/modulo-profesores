package com.disponibilidad;

public class Profesores {

    protected String clv_usuario;
    protected String pass_usuario;
    protected String tipo_usuario;
    protected String idcarrera;
    protected String nombre_usuario;
    protected String nivel_ads;
    protected String contrato;

    public Profesores(String clv_usuario,String pass_usuario,String tipo_usuario,String idcarrera,String nombre_usuario,String nivel_ads,String contrato){
        this.clv_usuario = clv_usuario;
        this.pass_usuario = pass_usuario;
        this.tipo_usuario = tipo_usuario;
        this.idcarrera = idcarrera;
        this.nombre_usuario = nombre_usuario;
        this.nivel_ads = nivel_ads;
        this.contrato = contrato;
    }

    public String getClv_usuario() {
        return clv_usuario;
    }
    public void setClv_usuario(String clv_usuario){
        this.clv_usuario = clv_usuario;
    }

    public String getPass_usuario() {
        return pass_usuario;
    }
    public void setPass_usuario(String pass_usuario){
        this.pass_usuario = pass_usuario;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }
    public void setTipo_usuario(String tipo_usuario){
        this.tipo_usuario = tipo_usuario;
    }

    public String getIdcarrera() {
        return idcarrera;
    }
    public void setIdcarrera(String idcarrera){
        this.idcarrera = idcarrera;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }
    public void setNombre_usuario(String nombre_usuario){
        this.nombre_usuario = nombre_usuario;
    }

    public String getNivel_ads() {
        return nivel_ads;
    }
    public void setNivel_ads(String nivel_ads){
        this.nivel_ads = nivel_ads;
    }

    public String getContrato() {
        return contrato;
    }
    public void setContrato(String contrato){
        this.contrato = contrato;
    }
}
