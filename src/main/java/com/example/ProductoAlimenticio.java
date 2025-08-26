package com.example;

public class ProductoAlimenticio extends  Producto {

    private int garantiaMeses;
    private String marca;
    private double voltaje;
    private boolean esImportado;


    public ProductoAlimenticio(String nombre,double precioBase, String codigo, int cantidadStock, String categoria,int garantiaMeses,String marca,double voltaje,boolean esImportado){
        super(nombre, precioBase, codigo, cantidadStock, categoria);
        this.garantiaMeses=garantiaMeses;
        this.marca=marca;
        this.voltaje=voltaje;
        this.esImportado=esImportado;
    }


}
