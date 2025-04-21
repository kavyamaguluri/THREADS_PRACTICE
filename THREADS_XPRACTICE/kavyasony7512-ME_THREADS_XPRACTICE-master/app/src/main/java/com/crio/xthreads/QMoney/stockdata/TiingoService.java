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

class TiingoService implements StockDataService {

    private final String API_URL = "https://api.tiingo.com/tiingo/daily";
    private final String API_KEY = "d7ee5290251fd4882f10fde8ada179ccc1450745";
    private final OkHttpClient httpClient;
    private final ObjectMapper objectMapper;

    public TiingoService(OkHttpClient httpClient, ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<Candle> fetchStockData(String symbol, LocalDate from, LocalDate to) {
        String url = buildUrl(symbol, from, to);
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
            List<TiingoResponse> tiingoResponses = objectMapper.readValue(jsonResponse, 
                objectMapper.getTypeFactory().constructCollectionType(List.class, TiingoResponse.class));

            return tiingoResponses.stream()
                .map(this::toCandle)
                .sorted((c1, c2) -> c2.getDate().compareTo(c1.getDate())) // Sort by date in descending order
                .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Failed to fetch stock data", e);
        }
    }

    private String buildUrl(String symbol, LocalDate from, LocalDate to) {
        String baseUrl = API_URL + "/" + symbol + "/prices";
        String startDate = from.toString();
        String endDate = to.toString();
        return String.format("%s?startDate=%s&endDate=%s&token=%s", baseUrl, startDate, endDate, API_KEY);
    }

    private Candle toCandle(TiingoResponse response) {
        return new Candle(
            response.getOpen(),
            response.getClose(),
            response.getHigh(),
            response.getLow(),
            response.getDate().toLocalDate()
        );
    }
}
