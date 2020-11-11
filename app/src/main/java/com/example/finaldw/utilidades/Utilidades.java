package com.example.finaldw.utilidades;

public class Utilidades {

    public static int DB_VERSION=1;
    public static String DB_NAME="bd_productos";


// constantes campos tabla productos
    public static final String TABLA_PRODUCTO="producto";
    public static final String CAMPO_IDP="id_producto";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_PROVEEDOR="proveedor";
    public static final String CAMPO_STOCK="stock";


    public static final String CREAR_TABLA_PRODUCTO = "CREATE TABLE "+ TABLA_PRODUCTO+
            "("+ CAMPO_IDP +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            CAMPO_NOMBRE +" TEXT, "+
            CAMPO_PROVEEDOR +" TEXT, "+
            CAMPO_STOCK +" TEXT)";


    // constantes campos tabla marca
    public static final String TABLA_MARCA ="marca";
    public static final String CAMPO_IDM="id_marca";
    public static final String CAMPO_MARCA="marca";

    public static final String CREAR_TABLA_MARCA = "CREATE TABLE "+ TABLA_MARCA+
            "(" + CAMPO_IDM + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            CAMPO_MARCA + " TEXT)";


    //Constantes campos asignacion pedidos
    public static final String TABLA_ASIG_PRO ="asig_pro";
    public static final String CAMPO_ID_ASIG_PRO ="id_asig_pro";
    public static final String CAMPO_CLIE ="cliente";
    public static final String CAMPO_DIRE ="direccion";
    public static final String CAMPO_REPA ="repartidor";
    public static final String CAMPO_ID_PROD ="id_prod";
    public static final String CAMPO_ID_MARC ="id_marc";


    public static final String CREAR_TABLA_ASIG_PRO = "CREATE TABLE "+ TABLA_ASIG_PRO+
            "("+ CAMPO_ID_ASIG_PRO +" INTEGER , "+
            CAMPO_CLIE +" TEXT, "+
            CAMPO_DIRE +" TEXT, "+
            CAMPO_REPA +" TEXT, "+
            CAMPO_ID_PROD +" INTEGER, "+
            CAMPO_ID_MARC +" INTEGER)";

}
