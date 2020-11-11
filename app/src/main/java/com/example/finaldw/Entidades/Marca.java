package com.example.finaldw.Entidades;

import java.io.Serializable;

public class Marca implements Serializable {
    private Integer id_marca;
    private String marca;

    public Marca(Integer id_marca, String marca) {
        this.id_marca = id_marca;
        this.marca = marca;
    }

    public Marca() {
    }

    public Integer getId_marca() {
        return id_marca;
    }

    public void setId_marca(Integer id_marca) {
        this.id_marca = id_marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
