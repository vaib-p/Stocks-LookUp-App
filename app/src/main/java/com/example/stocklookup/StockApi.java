package com.example.stocklookup;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

// Retrofit interface
public interface StockApi {
    // Get stock quote
    @GET("quote")
    Call<QuoteResponse> getStockQuote(
            @Query("symbol") String symbol,
            @Query("apikey") String apiKey
    );

    // Get stock price
    @GET("price")
    Call<PriceResponse> getStockPrice(
            @Query("symbol") String symbol,
            @Query("apikey") String apiKey
    );
}

