package com.example.electrovir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CalculoTransformadores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_transformadores);
    }

    //Metodo para regresar
    public void Regresar4(View view){
        Intent regresar4 = new Intent(this,vistaPrincipal.class);
        startActivity(regresar4);
        finish();
    }
}