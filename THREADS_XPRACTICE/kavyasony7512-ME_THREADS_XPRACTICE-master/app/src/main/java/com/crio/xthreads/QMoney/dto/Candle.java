package com.crio.xthreads.QMoney.dto;

import java.time.LocalDate;

public class Candle {

    private final Double open;
    private final Double close;
    private final Double high;
    private final Double low;
    private final LocalDate date;

    public Candle(Double open, Double close, Double high, Double low, LocalDate date) {
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
        this.date = date;
    }

    public Double getOpen() {
        return open;
    }

    public Double getClose() {
        return close;
    }

    public Double getHigh() {
        return high;
    }

    public Double getLow() {
        return low;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Candle [open=" + open + ", close=" + close + ", high=" + high + ", low=" + low + ", date=" + date + "]";
    }
}