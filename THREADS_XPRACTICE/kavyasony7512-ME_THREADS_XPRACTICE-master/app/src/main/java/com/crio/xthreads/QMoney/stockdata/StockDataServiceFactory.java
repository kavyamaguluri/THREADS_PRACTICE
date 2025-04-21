package com.crio.xthreads.QMoney.stockdata;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;

public class StockDataServiceFactory {
    private final OkHttpClient httpClient;
    private final ObjectMapper objectMapper;

    public StockDataServiceFactory(OkHttpClient httpClient, ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    public StockDataService getStockDataService(StockDataServiceType serviceType) {
        if (serviceType == null) {
            throw new IllegalArgumentException("StockDataServiceType cannot be null");
        }
        switch (serviceType) {
            case ALPHAVANTAGE:
                return new AlphaVantageService(httpClient, objectMapper);
            case TIINGO:
                return new TiingoService(httpClient, objectMapper);
            default:
                throw new IllegalArgumentException("Unsupported StockDataServiceType: " + serviceType);
        }
    }
}
