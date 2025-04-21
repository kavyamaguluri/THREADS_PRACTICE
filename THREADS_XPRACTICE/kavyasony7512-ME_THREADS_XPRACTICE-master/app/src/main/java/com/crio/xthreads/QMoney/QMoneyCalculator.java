package com.crio.xthreads.QMoney;

import java.time.LocalDate;
import java.util.List;

import com.crio.xthreads.QMoney.dto.Candle;
import com.crio.xthreads.QMoney.dto.ReturnSummary;
import com.crio.xthreads.QMoney.stockdata.StockDataService;
import com.crio.xthreads.QMoney.stockdata.StockDataServiceFactory;
import com.crio.xthreads.QMoney.stockdata.StockDataServiceType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import okhttp3.OkHttpClient;

public class QMoneyCalculator {

    private final StockDataService stockDataService;

    public QMoneyCalculator(StockDataServiceType serviceType) {
        OkHttpClient httpClient = new OkHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        
        StockDataServiceFactory factory = new StockDataServiceFactory(httpClient, objectMapper);
        this.stockDataService = factory.getStockDataService(serviceType);
    }

    public ReturnSummary calculateReturns(String symbol, LocalDate startDate, LocalDate endDate) {
        List<Candle> candles = stockDataService.fetchStockData(symbol,startDate, endDate);

        if (candles.isEmpty()) {
            System.out.printf("No data available for %s\n", symbol);
            return new ReturnSummary(symbol, 0.0, 0.0);
        }

        double purchasePrice = candles.get(candles.size() - 1).getOpen();
        double latestPrice = candles.get(0).getClose();

        double totalReturn = calculateTotalReturn(purchasePrice, latestPrice);
        double annualizedReturn = calculateAnnualizedReturn(purchasePrice, latestPrice,startDate, endDate);

        return new ReturnSummary(symbol, totalReturn, annualizedReturn);
    }

    private double calculateTotalReturn(double purchasePrice, double latestPrice) {
        return ((latestPrice - purchasePrice) / purchasePrice) * 100;
    }

    private double calculateAnnualizedReturn(double purchasePrice, double latestPrice, LocalDate purchaseDate, LocalDate endDate) {
        double totalReturn = (latestPrice - purchasePrice) / purchasePrice;
        long holdingPeriodDays = java.time.temporal.ChronoUnit.DAYS.between(purchaseDate, endDate);
        double holdingPeriodYears = holdingPeriodDays / 365.24;
        return (Math.pow(1 + totalReturn, 1 / holdingPeriodYears) - 1) * 100;
    }
}
