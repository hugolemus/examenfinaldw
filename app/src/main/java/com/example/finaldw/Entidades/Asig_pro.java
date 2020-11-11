package com.example.finaldw.Entidades;

import java.io.Serializable;
import java.util.Date;

public class Asig_pro implements Serializable  {

    private Integer id_asig_pro;
    private String  cliente;
    private String  direccion;
    private String  repartidor ;
    private Integer id_producto;
    private Integer id_marca;

    public Asig_pro(Integer id_asig_pro, String cliente, String direccion,String repartidor, Integer id_producto, Integer id_marca) {
        this.id_asig_pro = id_asig_pro;
        this.cliente = cliente;
        this.direccion = direccion;
        this.repartidor = repartidor;
        this.id_producto = id_producto;
        this.id_marca = id_marca;
    }

    public Asig_pro() {
    }

    public Integer getId_asig_pro() {
        return id_asig_pro;
    }

    public void setId_asig_pro(Integer id_asig_pro) {
        this.id_asig_pro = id_asig_pro;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(String repartidor) {
        this.repartidor = repartidor;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public Integer getId_marca() {
        return id_marca;
    }

    public void setId_marca(Integer id_marca) {
        this.id_marca = id_marca;
    }
}
