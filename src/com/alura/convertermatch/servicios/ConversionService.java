package com.alura.convertermatch.servicios;

import com.alura.convertermatch.modelos.MonedaConversion;
import com.alura.convertermatch.http.HttpClientWrapper;
import com.google.gson.JsonObject;
import com.google.gson.Gson;

public class ConversionService {
    private final HttpClientWrapper httpClientWrapper;
    private final Gson gson;

    public ConversionService() {
        this.httpClientWrapper = new HttpClientWrapper();
        this.gson = new Gson();
    }

    public MonedaConversion convertirMoneda(String origen, String destino, double cantidad) {
        String url = "https://v6.exchangerate-api.com/v6/90402e5b8982702b2c526d61/pair/" + origen + "/" + destino;
        String jsonResponse = httpClientWrapper.get(url);

        // Manejo de excepciones en la conversión de la respuesta JSON
        try {
            JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);
            double tasaConversion = jsonObject.get("conversion_rate").getAsDouble();
            double valorConvertido = cantidad * tasaConversion;
            return new MonedaConversion(origen, destino, tasaConversion, cantidad, valorConvertido);
        } catch (Exception e) {
            // Manejar la excepción y retornar null o lanzar una excepción personalizada
            System.out.println("Error al convertir moneda: " + e.getMessage());
            return null; // O puedes lanzar una excepción personalizada
        }
    }
}
