package com.example.electrovir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CalculoVentilacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_ventilacion);
    }

    //Metodo para regresar
    public void Regresar1(View view){
        Intent regresar1 = new Intent(this,vistaPrincipal.class);
        startActivity(regresar1);
        finish();
    }
}