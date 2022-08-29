package com.example.electrovir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class vistaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_principal);
    }

    //Metodo para llamar una activity potencia
    public void CalculoPotencia(View view){
        Intent siguiente1 = new Intent(this,Convertion.class);
        startActivity(siguiente1);
        finish();
    }

    //Metodo para llamar una activity ventilacion
    public void Ventila(View view){
        Intent ventilar = new Intent(this,CalculoVentilacion.class);
        startActivity(ventilar);
        finish();
    }


    //Metodo para llamar una activity totalizadores
    public void totalizador(View view){
        Intent breaker = new Intent(this,CalculoVentilacion.class);
        startActivity(breaker);
        finish();
    }

    //Metodo para llamar una activity banco condensadores
    public void condensador(View view){
        Intent banco = new Intent(this,CalculoVentilacion.class);
        startActivity(banco);
        finish();
    }

    //Metodo para llamar una activity transformadores
    public void Transformador(View view){
        Intent trafo = new Intent(this,CalculoVentilacion.class);
        startActivity(trafo);
        finish();
    }

}