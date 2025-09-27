package com.example;

public class ProductoAlimenticio extends Producto {

    private boolean refrigerado;
    private String lote;
    private int diasParaVencer;

    public ProductoAlimenticio(boolean refrigerado, String lote, int diasParaVencer, String nombre, double precioBase,
            String codigo, int cantidadStock, String categoria) {

        super(nombre, precioBase, codigo, cantidadStock, categoria);
        this.refrigerado = refrigerado;
        this.lote = lote;
        this.diasParaVencer = diasParaVencer;

    }
    // Getters

    public boolean isRefrigerado() {
        return refrigerado;
    }

    public String getLote() {
        return lote;
    }

    public int getDiasParaVencer() {
        return diasParaVencer;
    }

    // Setters

    public void setRefrigerado(boolean refrigerado) {
        this.refrigerado = refrigerado;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public void setDiasParaVencer(int diasParaVencer) {
        this.diasParaVencer = diasParaVencer;
    }


    //Métodos concretos

    public double calcularPrecioAlimenticio() {
        Double precioConIVA = super.calcularPrecioFinal();
        if (this.refrigerado == true) {
            precioConIVA = precioConIVA * 1.08;
        }
        Double descuento = calcularDescuentoVencimiento();
        precioConIVA = precioConIVA - (precioConIVA * descuento);
        return precioConIVA;
    }

    public double calcularDescuentoVencimiento() {
        if (diasParaVencer <= 3) {
            return 0.50;
        } else if (diasParaVencer <= 7) {
            return 0.30;
        } else if (diasParaVencer <= 15) {
            return 0.15;
        } else {
            return 0.0;
        }
    }

    public boolean estaProximoAVencer() {
        if (diasParaVencer <= 7) {
            return true;
        } else {
            return false;
        }
    }

    public boolean estaVencido() {
        if (diasParaVencer <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public String obtenerEstadoFrescura() {
        if (estaVencido() == true) {
            return "VENCIDO";
        } else {
            if (diasParaVencer <= 3) {
                return "URGENTE";
            } else if (diasParaVencer <= 7) {
                return "PRÓXIMO A VENCER";
            } else if (diasParaVencer <= 15) {
                return "CONSUMIR PRONTO";
            } else {
                return "FRESCO";
            }
        }
    }

    public double calcularPerdidaPorVencimiento() {
        if (estaVencido() == true) {
            return getPrecioBase() * getCantidadStock();
        } else {
            return 0.0;
        }
    }

}
