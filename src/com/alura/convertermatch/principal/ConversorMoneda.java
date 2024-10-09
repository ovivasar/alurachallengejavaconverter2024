package com.alura.convertermatch.principal;

import com.alura.convertermatch.modelos.MonedaConversion;
import com.alura.convertermatch.servicios.ConversionService;
import com.alura.convertermatch.servicios.MonedaRankingService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConversorMoneda {

    private final ConversionService conversionService;
    private final MonedaRankingService monedaRankingService;

    public ConversorMoneda() {
        this.conversionService = new ConversionService();
        this.monedaRankingService = new MonedaRankingService();
    }

    public void iniciar() throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        List<MonedaConversion> conversiones = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        while (true) {
            mostrarMenu();
            int opcion = lectura.nextInt();
            if (opcion == 10) {
                break;
            }

            String origen = "";
            String destino = "";
            //Seleccion de monedas
            switch (opcion) {
                case 1:
                    origen = "USD";
                    destino = "ARS";
                    break;
                case 2:
                    origen = "ARS";
                    destino = "USD";
                    break;
                case 3:
                    origen = "USD";
                    destino = "BRL";
                    break;
                case 4:
                    origen = "BRL";
                    destino = "USD";
                    break;
                case 5:
                    origen = "USD";
                    destino = "COP";
                    break;
                case 6:
                    origen = "COP";
                    destino = "USD";
                    break;
                case 7:
                    origen = "USD";
                    destino = "PEN";
                    break;
                case 8:
                    origen = "PEN";
                    destino = "USD";
                    break;
                case 9:
                    try {
                        monedaRankingService.mostrarMonedaMasFuerte();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    continue;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    continue;
            }

            System.out.println("Ingrese la cantidad de " + origen + " a convertir: " + destino);
            double cantidad = lectura.nextDouble();

            try {
                MonedaConversion conversion = conversionService.convertirMoneda(origen, destino, cantidad);
                System.out.println("Conversión obtenida: " + conversion);
                conversiones.add(conversion);
            } catch (Exception e) {
                System.out.println("Error al realizar la conversión: " + e.getMessage());
            }
        }

        FileWriter escritura = new FileWriter("conversiones.json");
        escritura.write(gson.toJson(conversiones));
        escritura.close();
        System.out.println("Historial de conversiones guardado en conversiones.json");
    }

    public static void mostrarMenu() {
        System.out.println("Seleccione una opción de conversión:");
        System.out.println("1. Dólar >> Peso Argentino");
        System.out.println("2. Peso Argentino >> Dólar");
        System.out.println("3. Dólar >> Real Brasileño");
        System.out.println("4. Real Brasileño >> Dólar");
        System.out.println("5. Dólar >> Peso Colombiano");
        System.out.println("6. Peso Colombiano >> Dólar");
        System.out.println("7. Dólar >> Sol Peruano");
        System.out.println("8. Sol Peruano >> Dólar");
        System.out.println("9. Ranking Moneda Latinoamérica más fuerte");
        System.out.println("10. Salir");
    }
}

