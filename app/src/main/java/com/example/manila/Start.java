package com.example.manila;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void TempGo(View view) {
        startActivity(new Intent(this, SignIn.class));
    }

    public void TempGo2(View view) {
        startActivity(new Intent(this, SignUp.class));
    }
}
