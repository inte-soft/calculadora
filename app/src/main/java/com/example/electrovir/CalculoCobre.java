package com.example.electrovir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class CalculoCobre extends AppCompatActivity {

    private Spinner cobre1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_cobre);

        //Arreglo de las lista desplegable cobre.
        cobre1 = (Spinner)findViewById(R.id.lcobre);
        String [] lDatos = {" ","Barras","Laminilla"};
        ArrayAdapter<String> adaptercobre = new ArrayAdapter<String>(this, R.layout.spinner_item_personalizacion, lDatos);
        cobre1.setAdapter(adaptercobre);
    }

    public void Regresarcobre(View view){
        Intent regresarcobre1 = new Intent(this,vistaPrincipal.class);
        startActivity(regresarcobre1);
        finish();
    }

}