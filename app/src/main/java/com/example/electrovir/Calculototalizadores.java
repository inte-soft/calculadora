package com.example.electrovir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Calculototalizadores extends AppCompatActivity {

    private Spinner spinner1;
    private Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculototalizadores);
        //Arreglo de las lita desplegable.
        spinner1 = (Spinner)findViewById(R.id.potencia);
        String [] listaDatos = {"kVA","VA","W","kW","HP","kVAR"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_personalizacion, listaDatos);
        spinner1.setAdapter(adapter);

        //Arreglo para seleccionar el tipo de sistema.
        spinner2 = (Spinner)findViewById(R.id.sistema1);
        String [] Fin = {"Trifasico","Bifasico","Monofasico"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.spinner_item_personalizacion, Fin);
        spinner2.setAdapter(adapter1);



    }

    //Metodo para regresar
    public void Regresar2(View view){
        Intent regresar2 = new Intent(this,vistaPrincipal.class);
        startActivity(regresar2);
        finish();
    }
}