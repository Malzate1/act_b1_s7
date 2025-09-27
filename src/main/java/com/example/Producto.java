package com.example;

public class Producto {

    protected String nombre;
    protected double precioBase;
    protected String codigo;
    protected int cantidadStock;
    protected String categoria;
    protected boolean activo;

    public Producto(String nombre, double precioBase, String codigo, int cantidadStock, String categoria) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.codigo = codigo;
        this.cantidadStock = cantidadStock;
        this.categoria = categoria;
        this.activo = true;
    }

    //Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        if (precioBase > 0) {
            this.precioBase = precioBase;
        } else {
            System.out.println("El precio base debe ser mayor a cero.");
        }

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {

        if (codigo != null && codigo.matches("PROD-\\d{4}")) {
            // \\d{4}: \\d representa un dígito (0-9). {4} indica que debe aparecer
            // exactamente cuatro veces. La doble barra invertida \\ es necesaria porque la
            // barra simple \ es un carácter de escape en Java.
            this.codigo = codigo;
        } else {
            System.out.println("Error: El código no cumple con el formato 'PROD-XXXX'.");
        }
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        if (cantidadStock >= 0) {
            this.cantidadStock = cantidadStock;
        } else {
            System.out.println("El stock no puede ser negativo.");
        }

    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }


    // Métodos concretos y su respectiva lógica de negocio

    public double calcularPrecioFinal() {
        return precioBase + (precioBase * 1.19);
    }

    public boolean hayStock(int cantidad) {

        if (cantidadStock >= cantidad && activo) {
            return true;
        } else {
            return false;
        }

    }

    public void vender(int cantidad) {

        if (hayStock(cantidad)) {
            cantidadStock -= cantidad;
            System.out.println("Venta exitosa: " + cantidad + "unidades de " + nombre);
        } else {
            System.out.println("Error: Stock insuficiente");
        }
    }

    public void reabastecer(int cantidad) {
        if (cantidad > 0) {
            cantidadStock = cantidadStock + cantidad;
            System.out.println("Reabastecimiento exitoso: " + cantidad + " unidades de " + nombre);
        } else {
            System.out.println("Error. La cantidad a reabastecer debe ser mayor a cero.");
        }
    }

    public double calcularDescuento() {
        return 0.0;
    }

}
