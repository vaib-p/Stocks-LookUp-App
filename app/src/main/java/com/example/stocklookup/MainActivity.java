package com.example.stocklookup;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


public class MainActivity extends AppCompatActivity {

    private StockViewModel stockViewModel;
    private EditText searchEditText;
    private Button searchButton;
    private TextView stockNameTextView, stockPriceTextView, stockChangeTextView;
    private LinearLayout layout;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout=findViewById(R.id.mainlayout);
        searchEditText = findViewById(R.id.stockSymbolEditText);
        searchButton = findViewById(R.id.searchButton);
        stockNameTextView = findViewById(R.id.companyNameTextView);
        stockPriceTextView = findViewById(R.id.stockPriceTextView);
        stockChangeTextView = findViewById(R.id.percentageChangeTextView);
        progressBar = findViewById(R.id.progressBar);

        stockViewModel = new ViewModelProvider(this).get(StockViewModel.class);

        stockViewModel.getStockData().observe(this, new Observer<StockData>() {
            @Override
            public void onChanged(StockData data) {
                progressBar.setVisibility(View.GONE);
                if (data.getName() != null) {

                    layout.setVisibility(View.VISIBLE);
                    stockNameTextView.setText("Company Name  : "+data.getName());
                    stockPriceTextView.setText("Stock Price          : "+data.getPrice()+" "+data.getCurrency());
                    stockChangeTextView.setText("Price Change       : "+data.getPercentChange() + "%");
                }else {
                    layout.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Enter Valid  stock Symbol!!!", Toast.LENGTH_SHORT).show(); // Show error message
                }


            }
        });

        stockViewModel.getErrorMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String error) {
                progressBar.setVisibility(View.GONE);
                if (error != null) {
                    Toast.makeText(MainActivity.this, error, Toast.LENGTH_LONG).show(); // Show error message
                }
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String symbol = searchEditText.getText().toString().trim();
                if (!symbol.isEmpty()) {
                    progressBar.setVisibility(View.VISIBLE);
                    stockViewModel.fetchStockData(symbol, "5c2c2adebb264bd182d5036dd3b87cbb");
                }else {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Please Enter SYMBOL name!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
