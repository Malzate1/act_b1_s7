package com.example;

public class Main {
    public static void main(String[] args) {

        ProductoAlimenticio leche = (ProductoAlimenticio) new Producto("Leche refrigerada", 4500, "PROD-0001", 20,
                "Lácteos");

        leche.setRefrigerado(true);
        leche.setLote("L001");
        leche.setDiasParaVencer(5);

        ProductoAlimenticio pan = (ProductoAlimenticio) new Producto("Pan tajado", 7000, "PROD-0002", 10, "Harinas");

        pan.setRefrigerado(false);
        pan.setLote("L002");
        pan.setDiasParaVencer(15);

        ProductoElectronico laptop = (ProductoElectronico) new Producto("Laptop importada", 2500000, "PROD-0003", 5,
                "Electronicos");

        laptop.setGarantiaMeses(24);
        laptop.setMarca("ASUS");
        laptop.setVoltaje(110);
        laptop.setEsImportado(true);

        ProductoElectronico telefono = (ProductoElectronico) new Producto(" Iphone 17", 8500000, "PROD-0004", 6,
                "Electronicos");

        laptop.setGarantiaMeses(12);
        laptop.setMarca("Apple");
        laptop.setVoltaje(220);
        laptop.setEsImportado(true);

        // Venta exitosa

        System.out.println("\n--- Venta exitosa ---");

        laptop.vender(3);

        // Venta fallida por falta de stock

        System.out.println("\n--- Venta fallida ---");

        pan.vender(18);

        // Cálculo de precios usando métodos específicos

        System.out.println("\n--- Cálculo de precios ---");
        System.out.println("Precio final leche: " + leche.calcularPrecioAlimenticio());
        System.out.println("Precio final pan: " + pan.calcularPrecioAlimenticio());
        System.out.println("Precio final laptop: " + laptop.calcularPrecioElectronico());
        System.out.println("Precio final celular: " + telefono.calcularPrecioElectronico());


        // Reabastecimiento de inventario

        System.out.println("\n--- Reabastecimiento ---");
        pan.reabastecer(10);


        // Verificación de compatibilidad de voltaje

        System.out.println("\n--- Compatibilidad de voltaje ---");
        double voltajeLocal = 120;
        System.out.println("Laptop compatible con voltaje local: " + laptop.esCompatibleVoltaje(voltajeLocal));
        System.out.println("Celular compatible con voltaje local: " + telefono.esCompatibleVoltaje(voltajeLocal));


        // Comparación entre precio base y precios específicos

        System.out.println("\n--- Comparación de precios ---");
        System.out.println("Laptop: Base=" + laptop.getPrecioBase() + ", Final=" + laptop.calcularPrecioElectronico());
        System.out.println("Leche: Base=" + leche.getPrecioBase() + ", Final=" + leche.calcularPrecioAlimenticio());

        // Funcionalidades únicas de cada tipo
        
        System.out.println("\n--- Funcionalidades únicas ---");
        System.out.println("Laptop garantía extendida? " + laptop.esGarantiaExtendida());
        System.out.println("Costo garantía laptop: " + laptop.calcularCostoGarantia());
        System.out.println("Leche próxima a vencer? " + leche.estaProximoAVencer());
        System.out.println("Estado frescura leche: " + leche.obtenerEstadoFrescura());
        System.out.println("Pérdida por vencimiento leche: " + leche.calcularPerdidaPorVencimiento());
    }
}