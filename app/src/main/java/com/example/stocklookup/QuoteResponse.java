package com.example.stocklookup;

public class QuoteResponse {
    private String name;
    private String percent_change;
    private String currency;

    // Getters
    public String getName() {
        return name;
    }

    public String getPercentChange() {
        return percent_change;
    }
    public String getCurrency() {
        return currency;
    }
}