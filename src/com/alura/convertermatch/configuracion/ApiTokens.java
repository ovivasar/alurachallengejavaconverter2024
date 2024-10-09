package com.alura.convertermatch.configuracion;

public record ApiTokens(String exchangeRateToken, String openexchangeToken) {
    //www.exchangerate-api.com
    //www.openexchangerates.org
    // Constructor con token de ExchangeRate API
    public static final ApiTokens TOKENS = new ApiTokens(
            "90402e5b8982702b2c526d61",   // Token de ExchangeRate API
            "b277bb1804b847fc89fa0e7fe11bc801"  // Token del segundo proveedor
    );
}