package com.example.finaldw.Entidades;

import java.io.Serializable;

public class Producto  implements Serializable {
    private Integer id_producto;
    private String nombre;
    private String proveedor;
    private String stock;

    public Producto(Integer id_producto, String nombre, String proveedor, String stock) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.stock = stock;
    }

    public Producto() {
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
}
