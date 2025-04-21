package com.crio.xthreads.QMoney.stockdata;

import java.time.LocalDate;
import java.util.List;

import com.crio.xthreads.QMoney.dto.Candle;

public interface StockDataService {
    List<Candle> fetchStockData(String symbol, LocalDate from, LocalDate to);
}
