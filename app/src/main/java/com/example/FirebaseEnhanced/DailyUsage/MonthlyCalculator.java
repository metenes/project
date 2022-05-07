package com.example.FirebaseEnhanced.DailyUsage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MonthlyCalculator extends AppCompatActivity {

    private TextView monthlyCalculatorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_calculator);
        monthlyCalculatorText = (TextView) findViewById(R.id.monthlyCalculatorText);
    }
}