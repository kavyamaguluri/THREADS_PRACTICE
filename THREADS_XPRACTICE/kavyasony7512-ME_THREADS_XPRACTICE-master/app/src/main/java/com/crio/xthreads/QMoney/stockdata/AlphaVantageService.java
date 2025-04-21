package com.crio.xthreads.QMoney.stockdata;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.crio.xthreads.QMoney.dto.Candle;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

class AlphaVantageService implements StockDataService {

    private final String API_URL = "https://www.alphavantage.co/query";
    private final String API_KEY = "9ILGFAZ7HNYOJ96T";
    private final OkHttpClient httpClient;
    private final ObjectMapper objectMapper;

    public AlphaVantageService(OkHttpClient httpClient, ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }
    
    @Override
    public List<Candle> fetchStockData(String symbol, LocalDate from, LocalDate to) {
        String url = buildUrl(symbol);
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            ResponseBody responseBody = response.body();
            if (responseBody == null) {
                throw new IOException("Empty response body");
            }

            String jsonResponse = responseBody.string();
            AlphaVantageResponse apiResponse = objectMapper.readValue(jsonResponse, AlphaVantageResponse.class);

            // Convert the API response to a list of Candle objects
            return apiResponse.getTimeSeries()
                .entrySet()
                .stream()
                .filter(entry -> {
                    LocalDate date = entry.getKey();
                    return !date.isBefore(from) && !date.isAfter(to);
                })
                .map(entry -> toCandle(entry.getValue(), entry.getKey()))
                .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Failed to fetch stock data", e);
        }
    }

    private String buildUrl(String symbol) {
        return String.format("%s?function=TIME_SERIES_DAILY&symbol=%s&apikey=%s&outputsize=full",
                API_URL, symbol, API_KEY);
    }

    private Candle toCandle(AlphaVantageResponse.TimeSeriesData data, LocalDate date) {
        return new Candle(
            data.getOpen(),
            data.getClose(),
            data.getHigh(),
            data.getLow(),
            date
        );
    }
}
