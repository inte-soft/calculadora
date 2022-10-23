package com.example.electrovir;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class CalculoCobre extends AppCompatActivity {

    private Spinner cobre1;
    private Button calccu;
    private Button borrarcu;
    private EditText valcurrent;
    private ListView result_list;
    private ArrayList<String> names;
    private TextView resultadocobre;
    private EditText borne;
    private TextView labelborne;
    private AdView mAdView;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_cobre);

        //inicializar anuncios
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }
            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
            }
            @Override
            public void onAdImpression() {
                // Code to be executed when an impression is recorded
                // for an ad.
            }
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }
            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }
        });


        //definir list view
        resultadocobre= (TextView) findViewById(R.id.resulttexview);
        //definir valor de corriente
        valcurrent= (EditText)findViewById(R.id.ingcorrientecu);
        //definir boton calcular
        calccu= (Button)findViewById(R.id.calcular_cobre2);
        //definir boton borrar
        borrarcu= (Button)findViewById(R.id.borrarcu1);
        //Arreglo de las lista desplegable cobre.
        cobre1 = (Spinner)findViewById(R.id.lcobre);
        String [] lDatos = {"","Barras","Laminilla"};
        ArrayAdapter<String> adaptercobre = new ArrayAdapter<String>(this, R.layout.spinner_item_personalizacion, lDatos);
        cobre1.setAdapter(adaptercobre);
        //definir edit text para borne de laminilla
        borne=(EditText) findViewById(R.id.ingborne);
        labelborne=(TextView) findViewById(R.id.label_borne);


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
        //arreglo para inhabilitar factor de potencia
        cobre1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (cobre1.getSelectedItem().toString()=="Laminilla" ){
                    labelborne.setVisibility(View.VISIBLE);
                    borne.setVisibility(View.VISIBLE);


                }else{

                    borne.setVisibility(View.GONE);
                    labelborne.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        calccu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //declaracion de variable para el limite superior de la corriente
                double nsup = 0;
                //decalracion de la variable para el limite inferior de la corriente
                double ninf = 0;

                //creacion de arraylist para almacenar las claves del diccionario de corrientes y barras
                ArrayList<Integer> corrientes_list = new ArrayList<Integer>(corrientes_barras.keySet());
                //creacion de arraylist para almacenar las corrientes que se pueden utilizar segun la corriente que el usuari ingrese.
                ArrayList<Integer> result_list = new ArrayList<Integer>();

                // validacion de si el spinner esta vacio
                if (cobre1.getSelectedItem().toString()=="") {
                    //escribir mensaje indicandole al usuario que debe seleccionar un tipo de material para realizar los calculos
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Seleccione Material", Toast.LENGTH_SHORT);
                    toast1.show();
                //validacion si ha seleccionado laminilla en el spinner
                } else if (cobre1.getSelectedItem().toString() == "Laminilla") {
                    //validacion si ha ingresado la corriente para realizar el calculo de las laminillas.
                    if(valcurrent.getText().toString().isEmpty()) {
                        //escribir mensaje indicandole al usuario que debe ingresar una corriente par poder realizar el calculo
                        Toast toast2 = Toast.makeText(getApplicationContext(), "Ingrese Corriente", Toast.LENGTH_SHORT);
                        toast2.show();
                    //validacion campo de borne vacio
                    }else if(borne.getText().toString().isEmpty()){
                        //escribir mensaje indicandole al usuario que debe ingresar un tamaño de borne
                        Toast toast4 = Toast.makeText(getApplicationContext(), "Ingrese borne", Toast.LENGTH_SHORT);
                        toast4.show();
                    //calculo para todos los tipos de laminillas.
                    } else {
                        Double nlam1 = Double.parseDouble(valcurrent.getText().toString()) / (2 * 0.9*Double.parseDouble(borne.getText().toString()));
                        Double nlam2 = Double.parseDouble(valcurrent.getText().toString()) / (2 * 0.8*Double.parseDouble(borne.getText().toString()));
                        Double nlam3 = Double.parseDouble(valcurrent.getText().toString()) / (2 * 0.7*Double.parseDouble(borne.getText().toString()));
                        Double nlam4 = Double.parseDouble(valcurrent.getText().toString()) / (2 * 0.6*Double.parseDouble(borne.getText().toString()));
                        Double nlam5 = Double.parseDouble(valcurrent.getText().toString()) / (2 * 0.5*Double.parseDouble(borne.getText().toString()));
                        //escrbir el resultado de los calculos en el tex view del resultado
                        resultadocobre.setText(String.valueOf(String.format("%.2f", nlam1))+" Laminillas de 0.9mm"+"\n"
                                +String.valueOf(String.format("%.1f", nlam2))+" Laminillas de 0.8mm"+"\n"
                                +String.valueOf(String.format("%.1f", nlam3))+" Laminillas de 0.7mm"+"\n"
                                +String.valueOf(String.format("%.1f", nlam4))+" Laminillas de 0.6mm"+"\n"
                                +String.valueOf(String.format("%.2f", nlam5))+" Laminillas de 0.5mm"+"\n");
                    }

                //validacion si ha sellecionado cobre en el spinner
                } else if (cobre1.getSelectedItem().toString() == "Barras") {
                    //validacion si el campo de ingreso de corriente se encuentra vacio.
                    if (valcurrent.getText().toString().isEmpty()) {
                        //escribir mensaje indicandole al usuario que debe ingresar una corriente par poder realizar el calculo
                        Toast toast3 = Toast.makeText(getApplicationContext(), "Ingrese Corriente", Toast.LENGTH_SHORT);
                        toast3.show();
                    //definir limite superiro e inferior segunla corriente que sel usuario ingreso en este caso para menores de 1201
                    } else if (Double.parseDouble(valcurrent.getText().toString()) <= 1200) {
                        nsup = Double.parseDouble(valcurrent.getText().toString()) + 100;
                        ninf = Double.parseDouble(valcurrent.getText().toString())-10;

                        //iteracion para hallar cuales son las corrientes que se encuentran en el rango de la corriente del usuario
                        for (int x = 0; x < corrientes_list.size(); x++) {
                            Integer it = corrientes_list.get(x);
                            if ((it >= ninf) && (it <= nsup)) {
                                result_list.add((corrientes_list.get(x)));
                                it = 0;
                            } else {
                                it = 0;
                                continue;
                            }
                        }
                        // organizacion de resultados en orden ascendentes.
                        Collections.sort(result_list);
                        //iteracion para hallar en el diccionario las descripciones segun las corrientes del rango hallado en la iteracion anterior  y escribir los resultados
                        for (int x = 0; x < result_list.size(); x++) {
                            Integer text = result_list.get(x);
                            if (x == 0) {
                                resultadocobre.setText(text + "A " + corrientes_barras.get(text));
                            } else {
                                resultadocobre.setText(resultadocobre.getText() + "\n" + text + "A " + corrientes_barras.get(text));
                            }
                        }
                    } else {
                        //definir limite superiro e inferior segunla corriente que sel usuario ingreso en este caso para mayores de 1200
                        nsup = Double.parseDouble(valcurrent.getText().toString()) + 500;
                        ninf = Double.parseDouble(valcurrent.getText().toString())-100;

                        //iteracion para hallar cuales son las corrientes que se encuentran en el rango de la corriente del usuario
                        for (int x = 0; x < corrientes_list.size(); x++) {
                            Integer it = corrientes_list.get(x);
                            if ((it >= ninf) && (it <= nsup)) {
                                result_list.add((corrientes_list.get(x)));
                                it = 0;
                            } else {
                                it = 0;
                                continue;

                            }
                        }
                        //iteracion para hallar en el diccionario las descripciones segun las corrientes del rango hallado en la iteracion anterior y escribir los resultados
                        for (int x = 0; x < result_list.size(); x++) {
                            Integer text = result_list.get(x);
                            if (x == 0) {
                                resultadocobre.setText(text + "A " + corrientes_barras.get(text));
                            } else {
                                resultadocobre.setText(resultadocobre.getText() + "\n" + text + "A " + corrientes_barras.get(text));
                            }
                        }
                    }
                }
            }
        });
        //metodo para borrar los resultados y el valor de corriente ingresado
        borrarcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valcurrent.setText(String.valueOf(""));
                resultadocobre.setText(String.valueOf(""));
            }
        });



    }
    // metodo para regresar a lapagina principal de la aplicacion
    public void Regresarcobre(View view){
        Intent regresarcobre1 = new Intent(this,vistaPrincipal.class);
        startActivity(regresarcobre1);
        finish();
    }


}