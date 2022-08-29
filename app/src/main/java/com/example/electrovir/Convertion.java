package com.example.electrovir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class Convertion extends AppCompatActivity {

    private Spinner spinner1;
    private Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertion);

        //Arreglo de las lita desplegable.
        spinner1 = (Spinner)findViewById(R.id.lista_desplegable);
        String [] listaDatos = {"convertir","va","kva","kvar","w","kw","hp"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_personalizacion, listaDatos);
        spinner1.setAdapter(adapter);

        //Arreglo para seleccionar el tipo de sistema.
        spinner2 = (Spinner)findViewById(R.id.sistema);
        String [] Sistemas = {"Sistema", "Trifasico", "Bifasico", "Monofasico"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.spinner_item_personalizacion, Sistemas);
        spinner2.setAdapter(adapter1);

    }

    //Metodo para regresar
    public void Regresar(View view){
        Intent regresar = new Intent(this,vistaPrincipal.class);
        startActivity(regresar);
        finish();
    }
}