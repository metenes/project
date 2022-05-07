package com.example.FirebaseEnhanced.ProfilePage;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.aksdev.profilepage.databinding.ActivityAboutUsBinding;

public class AboutUs extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityAboutUsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
    }
}