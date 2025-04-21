package com.crio.xthreads.QMoney.stockdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
class AlphaVantageResponse {

    @JsonProperty("Time Series (Daily)")
    private Map<LocalDate, TimeSeriesData> timeSeries;

    public Map<LocalDate, TimeSeriesData> getTimeSeries() {
        return timeSeries;
    }

    public void setTimeSeries(Map<LocalDate, TimeSeriesData> timeSeries) {
        this.timeSeries = timeSeries;
    }

    public static class TimeSeriesData {

        @JsonProperty("1. open")
        private Double open;

        @JsonProperty("2. high")
        private Double high;

        @JsonProperty("3. low")
        private Double low;

        @JsonProperty("4. close")
        private Double close;

        @JsonProperty("5. volume")
        private Long volume;

        public Double getOpen() {
            return open;
        }

        public void setOpen(Double open) {
            this.open = open;
        }

        public Double getHigh() {
            return high;
        }

        public void setHigh(Double high) {
            this.high = high;
        }

        public Double getLow() {
            return low;
        }

        public void setLow(Double low) {
            this.low = low;
        }

        public Double getClose() {
            return close;
        }

        public void setClose(Double close) {
            this.close = close;
        }

        public Long getVolume() {
            return volume;
        }

        public void setVolume(Long volume) {
            this.volume = volume;
        }
    }
}
