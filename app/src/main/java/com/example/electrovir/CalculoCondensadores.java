package com.example.electrovir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CalculoCondensadores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_condensadores);
    }

    //Metodo para regresar
    public void Regresar3(View view){
        Intent regresar3 = new Intent(this,vistaPrincipal.class);
        startActivity(regresar3);
        finish();
    }
}