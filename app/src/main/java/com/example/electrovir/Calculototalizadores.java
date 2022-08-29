package com.example.electrovir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Calculototalizadores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculototalizadores);
    }

    //Metodo para regresar
    public void Regresar2(View view){
        Intent regresar2 = new Intent(this,vistaPrincipal.class);
        startActivity(regresar2);
        finish();
    }
}