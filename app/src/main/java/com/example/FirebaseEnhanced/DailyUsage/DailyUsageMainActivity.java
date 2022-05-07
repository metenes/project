package com.example.FirebaseEnhanced.DailyUsage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DailyUsageMainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonPrimaryUsage = findViewById(R.id.buttonPrimaryUsage);
        Button buttonSecondaryUsage = findViewById(R.id.buttonSecondaryUsage);
        Button buttonMonthlyCalculator =  findViewById(R.id.buttonMonthlyCalculator);
        Button buttonSolutions = findViewById(R.id.buttonSolutions);
        Button buttonRecycle = findViewById(R.id.buttonRecycle);

        buttonPrimaryUsage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intPrim = new Intent(DailyUsageMainActivity.this, PrimaryUsage.class);
                startActivity(intPrim);
            }
        });

        buttonSecondaryUsage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intSec = new Intent(DailyUsageMainActivity.this, secondaryUsage.class);
                startActivity(intSec);
            }
        });

        buttonMonthlyCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intMonthly = new Intent(DailyUsageMainActivity.this, MonthlyCalculator.class);
                startActivity(intMonthly);
            }
        });

        buttonRecycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intRec = new Intent(DailyUsageMainActivity.this, recycle.class);
                startActivity(intRec);
            }
        });

        buttonSolutions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intSol = new Intent(DailyUsageMainActivity.this, Solutions.class);
                startActivity(intSol);
            }
        });

    }
}