package com.example.electrovir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import java.util.*;
import android.widget.*;


import java.util.Hashtable;

public class CalculoCobre extends AppCompatActivity {

    private Spinner cobre1;
    private Button calccu;
    private EditText valcurrent;
    private ListView result_list;
    private ArrayList<String> names;
    private TextView resultadocobre;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_cobre);


        //definir list view
        resultadocobre= (TextView) findViewById(R.id.resulttexview);
        //definir valor de corriente
        valcurrent= (EditText)findViewById(R.id.ingcorrientecu);
        //definir boton calcular
        calccu= (Button)findViewById(R.id.calcular_cobre2);
        //Arreglo de las lista desplegable cobre.
        cobre1 = (Spinner)findViewById(R.id.lcobre);
        String [] lDatos = {" ","Barras","Laminilla"};
        ArrayAdapter<String> adaptercobre = new ArrayAdapter<String>(this, R.layout.spinner_item_personalizacion, lDatos);
        cobre1.setAdapter(adaptercobre);


        //declaracion de diccionario

        Hashtable<Integer,String> corrientes_barras = new Hashtable<Integer,String>();

        // asociar corrientes a  seccion y numero de barras
        {
        corrientes_barras .put(108,"12x2 1 Barra");
        corrientes_barras .put(128,"15x2 1 Barra");
        corrientes_barras .put(161,"15x3 1 Barra");
        corrientes_barras .put(162,"20x2 1 Barra");
        corrientes_barras .put(182,"12x2 2 Barra");
        corrientes_barras .put(204,"20x3 1 Barra");
        corrientes_barras .put(216,"12x2 3 Barra");
        corrientes_barras .put(274,"20x5 1 Barra");
        corrientes_barras .put(245,"25x3 1 Barra");
        corrientes_barras .put(285,"30x3 1 Barra");
        corrientes_barras .put(212,"15x2 2 Barras");
        corrientes_barras .put(282,"15x3 2 Barras");
        corrientes_barras .put(264,"20x2 2 Barras");
        corrientes_barras .put(247,"15x2 3 Barras");
        corrientes_barras .put(298,"20x2 3 Barras");
        corrientes_barras .put(327,"25x5 1 Barra");
        corrientes_barras .put(379,"30x5 1 Barra");
        corrientes_barras .put(348,"20x3 2 Barras");
        corrientes_barras .put(361,"15x3 3 Barras");
        corrientes_barras .put(427,"20x10 1 Barra");
        corrientes_barras .put(482,"40x5 1 Barra");
        corrientes_barras .put(500,"20x5 2 Barras");
        corrientes_barras .put(412,"25x3 2 Barras");
        corrientes_barras .put(476,"30x3 2 Barras");
        corrientes_barras .put(431,"20x3 3 Barras");
        corrientes_barras .put(573,"30x10 1 Barra");
        corrientes_barras .put(583,"50x5 1 Barra");
        corrientes_barras .put(586,"25x5 2 Barras");
        corrientes_barras .put(564,"30x3 3 Barras");
        corrientes_barras .put(715,"40x10 1 Barra");
        corrientes_barras .put(688,"60x5 1 Barra");
        corrientes_barras .put(672,"30x5 2 Barras");
        corrientes_barras .put(690,"20x5 3 Barras");
        corrientes_barras .put(795,"25x5 3 Barras");
        corrientes_barras .put(852,"50x10 1 Barra");
        corrientes_barras .put(885,"80x5 1 Barra");
        corrientes_barras .put(825,"20x10 2 Barras");
        corrientes_barras .put(836,"40x5 2 Barras");
        corrientes_barras .put(896,"30x5 3 Barras");
        corrientes_barras .put(985,"60x10 1 Barra");
        corrientes_barras .put(1080,"100x5 1 Barra");
        corrientes_barras .put(1060,"30x10 2 Barras");
        corrientes_barras .put(994,"50x5 2 Barras");
        corrientes_barras .put(1090,"40x5 3 Barras");
        corrientes_barras .put(1240,"80x10 1 Barras");
        corrientes_barras .put(1290,"40x10 2 Barras");
        corrientes_barras .put(1150,"60x5 2 Barras");
        corrientes_barras .put(1180,"20x10 3 Barras");
        corrientes_barras .put(1260,"50x5 3 Barras");
        corrientes_barras .put(1490,"100x10 1 Barra");
        corrientes_barras .put(1510,"50x10 2 Barras");
        corrientes_barras .put(1450,"80x5 2 Barras");
        corrientes_barras .put(1480,"30x10 3 Barras");
        corrientes_barras .put(1440,"60x5 3 Barras");
        corrientes_barras .put(1740,"120x10 1 Barra");
        corrientes_barras .put(1720,"60x10 2 Barras");
        corrientes_barras .put(1730,"100x5 2 Barras");
        corrientes_barras .put(1770,"40x10 3 Barras");
        corrientes_barras .put(1750,"80x5 3 Barras");
        corrientes_barras .put(2110,"80x10 2 Barras");
        corrientes_barras .put(2040,"50x10 3 Barras");
        corrientes_barras .put(2050,"100x5 3 Barras");
        corrientes_barras .put(1920,"50x5 4 Barras");
        corrientes_barras .put(2300,"60x10 3 Barras");
        corrientes_barras .put(2280,"40x10 4 Barras");
        corrientes_barras .put(2210,"80x10 2 Barras");
        corrientes_barras .put(2480,"100x10 2 Barras");
        corrientes_barras .put(2790,"80x10 3 Barras");
        corrientes_barras .put(2600,"50x10 4 Barras");
        corrientes_barras .put(2720,"80x5 4 Barras");
        corrientes_barras .put(2860,"120x10 2 Barras");
        corrientes_barras .put(3260,"100x10 3 Barras");
        corrientes_barras .put(2900,"60x10 4 Barras");
        corrientes_barras .put(3190,"100x5 4 Barras");
        corrientes_barras .put(3470,"120x10 3 Barras");
        corrientes_barras .put(3450,"80x10 4 Barras");
        corrientes_barras .put(3980,"100x10 4 Barras");
        corrientes_barras .put(4500,"120x10 4 Barras");
        corrientes_barras .put(2220,"160x10 1 Barra");
        corrientes_barras .put(3590,"160x10 2 Barras");
        corrientes_barras .put(4680,"160x10 3 Barras");
        corrientes_barras .put(5530,"160x10 4 Barras");
        corrientes_barras .put(2690,"200x10 1 Barra");
        corrientes_barras .put(4310,"200x10 2 Barras");
        corrientes_barras .put(5610,"200x10 3 Barras");
        corrientes_barras .put(6540,"200x10 4 Barras");
        }


        calccu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double nsup = 0;
                double ninf = 0;
                ArrayList<Integer> corrientes_list = new ArrayList<Integer>(corrientes_barras.keySet());
                ArrayList<String> result_list = new ArrayList<String>();
                ArrayList<Integer> result_listdes = new ArrayList<Integer>();

                if(valcurrent.getText().toString() == "") {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Ingrese Corriente", Toast.LENGTH_SHORT);
                    toast1.show();
                }else{
                    if (Double.parseDouble(valcurrent.getText().toString()) <= 1200) {
                        nsup = Double.parseDouble(valcurrent.getText().toString()) + 100;
                        ninf = Double.parseDouble(valcurrent.getText().toString());
                    } else {
                        nsup = Double.parseDouble(valcurrent.getText().toString()) + 500;
                        ninf = Double.parseDouble(valcurrent.getText().toString());
                    }
                    Toast toast1 = Toast.makeText(getApplicationContext(), Double.toString(nsup)+Double.toString(ninf), Toast.LENGTH_SHORT);
                    toast1.show();
                    for (int x = 0; x < corrientes_list.size(); x++) {
                        Integer it = corrientes_list.get(x);
                        if ((it >= ninf) && (it <= nsup)) {
                            result_list.add(Integer.toString(corrientes_list.get(x)));
                            it = 0;
                        } else {
                            it = 0;
                            continue;

                        }
                    }
                    for (int x = 0; x < corrientes_list.size(); x++) {
                        Integer text = corrientes_list.get(x);
                        if (x == 0) {
                            resultadocobre.setText(text + " " + corrientes_barras.get(text));
                        } else {
                            resultadocobre.setText(resultadocobre.getText() + "\n" + text + " " + corrientes_barras.get(text));
                        }

                    }
                }


            }
        });





    }
    public void calcular (View view){

    }

    public void Regresarcobre(View view){
        Intent regresarcobre1 = new Intent(this,vistaPrincipal.class);
        startActivity(regresarcobre1);
        finish();
    }


}