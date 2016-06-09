package com.example.nicols.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ErrorScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_screen);
    }

    public void clickRegister (View v){
        Intent nuevaVista = new Intent(getApplicationContext(), pantallaReg.class);
        startActivity(nuevaVista);
    }
    public void clickvolver (View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

}
