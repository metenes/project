package com.example.FirebaseEnhanced.DailyUsage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class secondaryUsage extends AppCompatActivity {

    private TextView secondaryUsageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary_usage);
        secondaryUsageText = (TextView) findViewById(R.id.secondaryUsageText);
    }
}