package com.example.electrovir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {

                Intent intent = new Intent(MainActivity.this, vistaPrincipal.class);
                startActivity(intent);
                finish();
            }
        };

        Timer tiempo = new Timer();
        tiempo.schedule(tarea, 3000);

    }


    //Metodo del boton para llamr otra activity
    /*public void siguiente (View view){
        Intent siguiente = new Intent(this,vistaPrincipal.class);
        startActivity(siguiente);
        finish();
    }*/
}