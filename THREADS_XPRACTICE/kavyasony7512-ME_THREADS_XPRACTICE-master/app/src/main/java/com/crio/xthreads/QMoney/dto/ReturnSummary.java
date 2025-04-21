package com.crio.xthreads.QMoney.dto;

public class ReturnSummary {
    private final String symbol;
    private final double totalReturn;
    private final double annualizedReturn;

    public ReturnSummary(String symbol, double totalReturn, double annualizedReturn) {
        this.symbol = symbol;
        this.totalReturn = totalReturn;
        this.annualizedReturn = annualizedReturn;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getTotalReturn() {
        return totalReturn;
    }

    public double getAnnualizedReturn() {
        return annualizedReturn;
    }
}