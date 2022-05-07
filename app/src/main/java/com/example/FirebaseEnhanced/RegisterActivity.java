package com.example.FirebaseEnhanced;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {
    //Data Pass
    public static final String EXTRA_USERNAME = "com.example.firebase.EXTRA_USERNAME";
    public static final String EXTRA_MAIL= "com.example.firebase.EXTRA_MAIL";
    public static final String EXTRA_PASSWORD= "com.example.firebase.EXTRA_PASSWORD";

    //FireBase auth object --> ( DataBase )
    private FirebaseAuth auth;
    // Register Button
    private Button registerPageBtn;

    //EdiT Text
    private EditText nameEditText;
    private EditText mailEditText;
    private EditText passwordEditText;

    //Getters
    public String getNameReg() {
        return  nameEditText.getText().toString();
    }
    public String getMailReg() {
        return mailEditText.toString();
    }
    public String getPasswordReg() {
        return passwordEditText.toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        auth = FirebaseAuth.getInstance();
        mailEditText = findViewById(R.id.editTextTextEmailAddress);
        nameEditText = findViewById(R.id.nameEdit);
        registerPageBtn = findViewById(R.id.registerPageBtn);
        passwordEditText = findViewById(R.id.editTextNumberPassword);

        registerPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textMail = mailEditText.getText().toString();
                String textPassword = passwordEditText.getText().toString();
                String textName = nameEditText.getText().toString();
                if(textMail.isEmpty() || textPassword.isEmpty() || textName.isEmpty() ){
                    if(textMail.isEmpty()){
                        Toast.makeText( RegisterActivity.this , "Mail can not be left blank", Toast.LENGTH_LONG).show();
                    }
                    else if (textPassword.isEmpty()) {
                        Toast.makeText( RegisterActivity.this , "Password can not be left blank", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText( RegisterActivity.this , "Name can not be left blank", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    registerUser(textMail, textPassword, textName);

                }
            }
        });
    }
    private void registerUser(String textMail, String textPassword, String textName) {
       auth.createUserWithEmailAndPassword(textMail,textPassword).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this, "Registered to first step", Toast.LENGTH_LONG).show();
                    //Data Pass to User
                    Intent registerIntent = new Intent(RegisterActivity.this, RegisterProfileActivity.class);
                        registerIntent.putExtra(EXTRA_USERNAME, getNameReg());
                        registerIntent.putExtra(EXTRA_MAIL, getMailReg());
                        registerIntent.putExtra(EXTRA_PASSWORD, getPasswordReg());
                    startActivity(registerIntent);
                }
                else {
                    Toast.makeText(RegisterActivity.this, "User has already registered... ", Toast.LENGTH_LONG).show();
                    try {
                        task.isSuccessful();
                    }
                    catch (Exception e){
                        Toast.makeText(RegisterActivity.this, Objects.requireNonNull(e.getCause()).toString(), Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }


}