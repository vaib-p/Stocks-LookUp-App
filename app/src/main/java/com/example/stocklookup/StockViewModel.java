package com.example.stocklookup;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StockViewModel extends ViewModel {

    private MutableLiveData<StockData> stockData;
    private StockApi stockApi;
    private MutableLiveData<String> errorMessage;


    public StockViewModel() {
        stockData = new MutableLiveData<>();
        stockApi = RetrofitClient.getRetrofitInstance().create(StockApi.class);
        errorMessage = new MutableLiveData<>();
    }

    public LiveData<StockData> getStockData() {
        return stockData;
    }
    public LiveData<String> getErrorMessage() { // Getter for error messages
        return errorMessage;
    }

    // Fetch data for name, percent_change, and price
    public void fetchStockData(String symbol, String apiKey) {
        // Fetch quote (name, percent_change)
        stockApi.getStockQuote(symbol, apiKey).enqueue(new Callback<QuoteResponse>() {
            @Override
            public void onResponse(Call<QuoteResponse> call, Response<QuoteResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    QuoteResponse quote = response.body();
                    StockData data = new StockData();
                    data.setName(quote.getName());
                    data.setPercentChange(quote.getPercentChange());
                    data.setCurrency(quote.getCurrency());

                    // Fetch price
                    stockApi.getStockPrice(symbol, apiKey).enqueue(new Callback<PriceResponse>() {
                        @Override
                        public void onResponse(Call<PriceResponse> call, Response<PriceResponse> response) {
                            if (response.isSuccessful() && response.body() != null) {
                                data.setPrice(response.body().getPrice());
                                stockData.setValue(data);  // Update LiveData
                            }
                        }

                        @Override
                        public void onFailure(Call<PriceResponse> call, Throwable t) {
                            errorMessage.setValue("Error fetching stock price.");

                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<QuoteResponse> call, Throwable t) {

                errorMessage.setValue("Network error: " + t.getMessage());
            }
        });
    }
}
