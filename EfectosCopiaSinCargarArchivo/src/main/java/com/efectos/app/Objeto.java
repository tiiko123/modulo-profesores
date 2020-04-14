package com.efectos.app;

public class Objeto {

    private String id;
    private String nombre;
    private String categoria;

    public Objeto(String id, String nombre,String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
