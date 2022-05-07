package com.example.FirebaseEnhanced;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity {

    private FirebaseAuth auth;

    private Button logInBtn;
    private TextView mailText;
    private TextView passwordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        auth = FirebaseAuth.getInstance();
        mailText = findViewById(R.id.LogInMail);
        passwordText  =findViewById(R.id.LogInPassword);

        logInBtn = findViewById(R.id.LogInPageBtn);
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mailString = mailText.getText().toString();
                String passwordString = passwordText.getText().toString();
                logInUser(mailString,passwordString);
            }
        });
    }
    private void logInUser(String mailString, String passwordString) {
        auth.signInWithEmailAndPassword(mailString,passwordString).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(LogInActivity.this,"Loged In", Toast.LENGTH_LONG);
                startActivity(new Intent(LogInActivity.this, HomeActivity.class));
                finish();
            }
        });
    }
}