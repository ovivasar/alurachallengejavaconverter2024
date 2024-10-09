package com.alura.convertermatch.http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientWrapper {
    private final HttpClient client;

    public HttpClientWrapper() {
        this.client = HttpClient.newHttpClient();
    }

    public String get(String url) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            // Manejar la excepción y retornar un mensaje de error
            return "Error al realizar la solicitud HTTP: " + e.getMessage();
        }
    }
}
