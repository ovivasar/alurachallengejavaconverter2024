package com.alura.convertermatch.modelos;

public class MonedaConversion {
    private String origen;
    private String destino;
    private double tasaConversion;
    private double valorConvertido;
    private double cantidad;

    public MonedaConversion(String origen, String destino, double tasaConversion, double cantidad, double valorConvertido) {
        this.origen = origen;
        this.destino = destino;
        this.tasaConversion = tasaConversion;
        this.cantidad = cantidad;
        this.valorConvertido = valorConvertido;
    }

    @Override
    public String toString() {
        return "De " + origen + " a " + destino + " con tasa de " + tasaConversion + ": " + cantidad + " se convierte en " + valorConvertido;
    }
}