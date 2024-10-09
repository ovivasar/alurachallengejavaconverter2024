package com.alura.convertermatch.servicios;

import com.alura.convertermatch.http.HttpClientWrapper;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class MonedaRankingService {
    //Procesa la moneda mas fuerte en relacion al Dolar USD
    private final HttpClientWrapper httpClientWrapper;
    private final Gson gson;

    public MonedaRankingService() {
        this.httpClientWrapper = new HttpClientWrapper();
        this.gson = new Gson();
    }

    public void mostrarMonedaMasFuerte() throws Exception {
        //Usamos las monedas del menu ofrecido
        String[] monedasLatinas = {"ARS", "BRL", "COP", "PEN"};
        double montoReferencia = 100.0;
        Map<String, Double> conversionesADolar = new HashMap<>();

        //Almacenamos valores para comparacion posterior
        for (String moneda : monedasLatinas) {
            String url = "https://v6.exchangerate-api.com/v6/90402e5b8982702b2c526d61/pair/" + moneda + "/USD";
            String jsonResponse = httpClientWrapper.get(url);
            Map<String, Object> jsonObject = gson.fromJson(jsonResponse, Map.class);
            double tasaConversion = (double) jsonObject.get("conversion_rate");
            conversionesADolar.put(moneda, montoReferencia * tasaConversion);
        }

        String monedaMasFuerte = null;
        double valorMasAlto = 0.0;
        //Determinamos el mas alto
        for (Map.Entry<String, Double> entry : conversionesADolar.entrySet()) {
            if (entry.getValue() > valorMasAlto) {
                valorMasAlto = entry.getValue();
                monedaMasFuerte = entry.getKey();
            }
        }

        //Mostramos resultado
        System.out.println("La moneda más fuerte en relación al dólar es: " + monedaMasFuerte +
                " con un valor convertido de: $" + String.format("%.2f", valorMasAlto) + " USD por 100 unidades.");
    }
}
