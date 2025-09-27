package com.example;

public class ProductoElectronico extends Producto {

    private int garantiaMeses;
    private String marca;
    private double voltaje;
    private boolean esImportado;

    public ProductoElectronico(String nombre, double precioBase, String codigo, int cantidadStock, String categoria,
            int garantiaMeses, String marca, double voltaje, boolean esImportado) {
        super(nombre, precioBase, codigo, cantidadStock, categoria);
        this.garantiaMeses = garantiaMeses;
        this.marca = marca;
        this.voltaje = voltaje;
        this.esImportado = esImportado;
    }

    // Getters
    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public String getMarca() {
        return marca;
    }

    public double getVoltaje() {
        return voltaje;
    }

    public boolean isEsImportado() {
        return esImportado;
    }

    //Setters

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setVoltaje(double voltaje) {
        this.voltaje = voltaje;
    }

    public void setEsImportado(boolean esImportado) {
        this.esImportado = esImportado;
    }

    //Métodos concretos

    public double calcularDescuentoGarantia() {
        if (this.garantiaMeses >= 24) {
            return 0.10; // 10% descuento
        } else if (this.garantiaMeses >= 12) {
            return 0.05; // 5% descuento
        } else {
            return 0.0; // sin descuento
        }
    }

    public double calcularPrecioElectronico() {
        double precioConIVA = super.calcularPrecioFinal();
        double precioFinal = precioConIVA;

        if (this.esImportado) {
            precioFinal += getPrecioBase() * 0.05;
        }

        double descuento = calcularDescuentoGarantia();
        precioFinal -= precioFinal * descuento;
        return precioFinal;
    }

    public boolean esGarantiaExtendida() {
        if (garantiaMeses > 12) {
            return true;
        } else {
            return false;
        }
    }

    public double calcularCostoGarantia() {
        return getPrecioBase() * 0.02 * this.garantiaMeses;
    }

    public boolean esCompatibleVoltaje(double voltajeLocal) {
        Double voltaje = Math.abs(this.voltaje - voltajeLocal);
        if (voltaje <= (0.1 * voltajeLocal)) {
            return true;
        } else {
            return false;
        }
    }

}
