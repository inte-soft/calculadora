package com.example.electrovir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Convertion extends AppCompatActivity {

    private Spinner spinner1;
    private Spinner spinner2;
    private Button calcular;
    private Button borrar;
    private EditText fp;
    private EditText ingvalor;
    private TextView resultado;
    private TextView label_fp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertion);

        //Arreglo de las lita desplegable.
        spinner1 = (Spinner)findViewById(R.id.lista_desplegable);
        String [] listaDatos = {"kVA","VA","W","kW","HP"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_personalizacion, listaDatos);
        spinner1.setAdapter(adapter);

        //Arreglo para seleccionar el tipo de sistema.
        spinner2 = (Spinner)findViewById(R.id.sistema);
        String [] Fin = {"kVA","VA","W","kW","HP"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.spinner_item_personalizacion, Fin);
        spinner2.setAdapter(adapter1);

        //arreglo edit text
        ingvalor = (EditText) findViewById(R.id.ingvalor);
        fp = (EditText) findViewById(R.id.fp);

        //arreglo text view
        resultado= (TextView) findViewById(R.id.resultado);
        label_fp = (TextView) findViewById(R.id.label_fp);

        //arreglo botones
        calcular = (Button) findViewById(R.id.calcular);
        borrar= (Button) findViewById(R.id.borrar);

        //arreglo para inhabilitar factor de potencia
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (((spinner1.getSelectedItem().toString()=="W")|| (spinner1.getSelectedItem().toString()=="kW") || (spinner1.getSelectedItem().toString()=="HP"))&&((spinner2.getSelectedItem().toString()=="VA")||(spinner2.getSelectedItem().toString()=="kVA"))){
                    fp.setVisibility(View.VISIBLE);
                    label_fp.setVisibility(View.VISIBLE);

                }else if (((spinner1.getSelectedItem().toString()=="VA")|| (spinner1.getSelectedItem().toString()=="kVA"))&&((spinner2.getSelectedItem().toString()=="HP")||(spinner2.getSelectedItem().toString()=="kW")||(spinner2.getSelectedItem().toString()=="W"))){
                    fp.setVisibility(View.VISIBLE);
                    label_fp.setVisibility(View.VISIBLE);

                }else{

                    fp.setVisibility(View.GONE);
                    label_fp.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //arreglo para inhabilitar factor de potencia
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (((spinner2.getSelectedItem().toString()=="W")|| (spinner2.getSelectedItem().toString()=="kW") || (spinner2.getSelectedItem().toString()=="HP"))&&((spinner1.getSelectedItem().toString()=="VA")||(spinner1.getSelectedItem().toString()=="kVA")) ){
                    fp.setVisibility(View.VISIBLE);
                    label_fp.setVisibility(View.VISIBLE);

                }else if (((spinner2.getSelectedItem().toString()=="VA")|| (spinner2.getSelectedItem().toString()=="kVA"))&&((spinner1.getSelectedItem().toString()=="W")||(spinner1.getSelectedItem().toString()=="HP")||(spinner1.getSelectedItem().toString()=="kW")) ){
                    fp.setVisibility(View.VISIBLE);
                    label_fp.setVisibility(View.VISIBLE);

                }else{

                    fp.setVisibility(View.GONE);
                    label_fp.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        // arreglo calculos
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double n1 = 0;
                String text;

                if (ingvalor.getText().toString().isEmpty()) {
                    Toast toast2 = Toast.makeText(getApplicationContext(), "no ha ingresado valor", Toast.LENGTH_SHORT);
                    toast2.show();

                }else if(spinner1.getSelectedItem().toString() == spinner2.getSelectedItem().toString()) {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Cambiar una unidad", Toast.LENGTH_SHORT);
                    toast1.show();

                    }else{

                    // calculos va
                    // calculos de va a kw
                        if (spinner1.getSelectedItem().toString() == "VA" && spinner2.getSelectedItem().toString() == "kW") {
                            if (fp.getText().toString().isEmpty()) {
                                Toast toast1 = Toast.makeText(getApplicationContext(), "Ingrese factor de potencia", Toast.LENGTH_SHORT);
                                toast1.show();
                            } else{
                                n1 = (Double.parseDouble(ingvalor.getText().toString())) * (Double.parseDouble(fp.getText().toString())) / 1000;
                                resultado.setText(String.valueOf(String.format("%.2f", n1)));
                            }
                        }

                    // calculos de va a kva
                        if (spinner1.getSelectedItem().toString() == "VA" && spinner2.getSelectedItem().toString() == "kVA") {
                            n1 = (Double.parseDouble(ingvalor.getText().toString())) * 1000;
                            resultado.setText(String.valueOf(String.format("%.2f", n1)));
                        }
                    // calculos de va a hp
                        if (spinner1.getSelectedItem().toString() == "VA" && spinner2.getSelectedItem().toString() == "HP") {
                            if (fp.getText().toString().isEmpty()) {
                                Toast toast1 = Toast.makeText(getApplicationContext(), "Ingrese factor de potencia", Toast.LENGTH_SHORT);
                                toast1.show();
                            } else {
                                n1 = (Double.parseDouble(ingvalor.getText().toString())) * (Double.parseDouble(fp.getText().toString())) / 746;
                                resultado.setText(String.valueOf(String.format("%.2f", n1)));
                            }
                        }
                    //calculos de va a w
                        if (spinner1.getSelectedItem().toString() == "VA" && spinner2.getSelectedItem().toString() == "W") {
                            if (fp.getText().toString().isEmpty()) {
                                Toast toast1 = Toast.makeText(getApplicationContext(), "Ingrese factor de potencia", Toast.LENGTH_SHORT);
                                toast1.show();
                            } else {
                                n1 = (Double.parseDouble(ingvalor.getText().toString())) * (Double.parseDouble(fp.getText().toString()));
                                resultado.setText(String.valueOf(String.format("%.2f", n1)));
                            }
                        }
                    // calculos w
                    // calculos de w a kw
                        if (spinner1.getSelectedItem().toString() == "W" && spinner2.getSelectedItem().toString() == "kW") {

                                n1 = (Double.parseDouble(ingvalor.getText().toString())) / 1000;
                                resultado.setText(String.valueOf(String.format("%.2f", n1)));

                        }
                    // calculos de w a kva
                        if (spinner1.getSelectedItem().toString() == "W" && spinner2.getSelectedItem().toString() == "kVA") {
                            if (fp.getText().toString().isEmpty()) {
                                Toast toast1 = Toast.makeText(getApplicationContext(), "Ingrese factor de potencia", Toast.LENGTH_SHORT);
                                toast1.show();
                            } else {
                                n1 = Double.parseDouble(ingvalor.getText().toString()) / Double.parseDouble(fp.getText().toString()) / 1000;
                                resultado.setText(String.valueOf(String.format("%.2f", n1)));
                            }
                        }
                    // calculos de w a hp
                        if (spinner1.getSelectedItem().toString() == "W" && spinner2.getSelectedItem().toString() == "HP") {

                                n1 = (Double.parseDouble(ingvalor.getText().toString())) / 746;
                                resultado.setText(String.valueOf(String.format("%.2f", n1)));

                        }
                    //calculos de w a va
                        if (spinner1.getSelectedItem().toString() == "W" && spinner2.getSelectedItem().toString() == "VA") {
                            if (fp.getText().toString().isEmpty()) {
                                Toast toast1 = Toast.makeText(getApplicationContext(), "Ingrese factor de potencia", Toast.LENGTH_SHORT);
                                toast1.show();
                            } else {
                                n1 = (Double.parseDouble(ingvalor.getText().toString())) / (Double.parseDouble(fp.getText().toString()));
                                resultado.setText(String.valueOf(String.format("%.2f", n1)));
                            }
                        }

                    // calculos kw
                    // calculos de kw a w
                        if (spinner1.getSelectedItem().toString() == "kW" && spinner2.getSelectedItem().toString() == "W") {

                                n1 = (Double.parseDouble(ingvalor.getText().toString())) * 1000;
                                resultado.setText(String.valueOf(String.format("%.2f", n1)));

                        }
                    // calculos de kw a kva
                        if (spinner1.getSelectedItem().toString() == "kW" && spinner2.getSelectedItem().toString() == "kVA") {
                            if (fp.getText().toString().isEmpty()) {
                                Toast toast1 = Toast.makeText(getApplicationContext(), "Ingrese factor de potencia", Toast.LENGTH_SHORT);
                                toast1.show();
                            } else {
                                n1 = (Double.parseDouble(ingvalor.getText().toString())) / Double.parseDouble(fp.getText().toString());
                                resultado.setText(String.valueOf(String.format("%.2f", n1)));
                            }
                        }
                    // calculos de kw a hp
                        if (spinner1.getSelectedItem().toString() == "kW" && spinner2.getSelectedItem().toString() == "HP") {

                                n1 = (Double.parseDouble(ingvalor.getText().toString())) / 746 * 1000;
                                resultado.setText(String.valueOf(String.format("%.2f", n1)));

                        }
                    //calculos de kw a va
                        if (spinner1.getSelectedItem().toString() == "kW" && spinner2.getSelectedItem().toString() == "VA") {
                            if (fp.getText().toString().isEmpty()) {
                                Toast toast1 = Toast.makeText(getApplicationContext(), "Ingrese factor de potencia", Toast.LENGTH_SHORT);
                                toast1.show();
                            } else {
                                n1 = (Double.parseDouble(ingvalor.getText().toString())) / (Double.parseDouble(fp.getText().toString())) * 1000;
                                resultado.setText(String.valueOf(String.format("%.2f", n1)));
                            }
                        }

                    // calculos kva
                    // calculos de kva a w
                        if (spinner1.getSelectedItem().toString() == "kVA" && spinner2.getSelectedItem().toString() == "W") {
                            if (fp.getText().toString().isEmpty()) {
                            Toast toast1 = Toast.makeText(getApplicationContext(), "Ingrese factor de potencia", Toast.LENGTH_SHORT);
                            toast1.show();
                            } else {
                            n1 = (Double.parseDouble(ingvalor.getText().toString()))/Double.parseDouble(fp.getText().toString()) * 1000;
                            resultado.setText(String.valueOf(String.format("%.2f", n1)));
                            }
                        }
                        // calculos de kva a kva
                        if (spinner1.getSelectedItem().toString() == "kVA" && spinner2.getSelectedItem().toString() == "kW") {
                            if (fp.getText().toString().isEmpty()) {
                            Toast toast1 = Toast.makeText(getApplicationContext(), "Ingrese factor de potencia", Toast.LENGTH_SHORT);
                            toast1.show();
                            } else {
                            n1 = (Double.parseDouble(ingvalor.getText().toString())) * Double.parseDouble(fp.getText().toString());
                            resultado.setText(String.valueOf(String.format("%.2f", n1)));
                            }
                        }
                        // calculos de kva a hp
                        if (spinner1.getSelectedItem().toString() == "kVA" && spinner2.getSelectedItem().toString() == "HP") {
                            if (fp.getText().toString().isEmpty()) {
                            Toast toast1 = Toast.makeText(getApplicationContext(), "Ingrese factor de potencia", Toast.LENGTH_SHORT);
                            toast1.show();
                            } else {
                            n1 = (Double.parseDouble(ingvalor.getText().toString())) / 746/Double.parseDouble(fp.getText().toString()) * 1000;
                            resultado.setText(String.valueOf(String.format("%.2f", n1)));
                            }
                        }
                    //calculos de kva a va
                        if (spinner1.getSelectedItem().toString() == "kVA" && spinner2.getSelectedItem().toString() == "VA") {

                            n1 = (Double.parseDouble(ingvalor.getText().toString())) * 1000;
                            resultado.setText(String.valueOf(String.format("%.2f", n1)));
                        }

                    // calculos hp
                    // calculos de hp a w
                        if (spinner1.getSelectedItem().toString() == "HP" && spinner2.getSelectedItem().toString() == "W") {

                                n1 = (Double.parseDouble(ingvalor.getText().toString())) * 746;
                                resultado.setText(String.valueOf(String.format("%.2f", n1)));

                        }
                    // calculos de hp a kva
                        if (spinner1.getSelectedItem().toString() == "HP" && spinner2.getSelectedItem().toString() == "kVA") {
                            if (fp.getText().toString().isEmpty()) {
                                Toast toast1 = Toast.makeText(getApplicationContext(), "Ingrese factor de potencia", Toast.LENGTH_SHORT);
                                toast1.show();
                            } else {
                                n1 = (Double.parseDouble(ingvalor.getText().toString())) / Double.parseDouble(fp.getText().toString()) * 746 / 1000;
                                resultado.setText(String.valueOf(String.format("%.2f", n1)));
                            }
                        }
                    // calculos de hp a kw
                        if (spinner1.getSelectedItem().toString() == "HP" && spinner2.getSelectedItem().toString() == "kW") {

                                n1 = (Double.parseDouble(ingvalor.getText().toString())) / 746 / 1000;
                                resultado.setText(String.valueOf(String.format("%.2f", n1)));

                        }
                    //calculos de hp a va
                        if (spinner1.getSelectedItem().toString() == "HP" && spinner2.getSelectedItem().toString() == "VA") {
                            if (fp.getText().toString().isEmpty()) {
                                Toast toast1 = Toast.makeText(getApplicationContext(), "Ingrese factor de potencia", Toast.LENGTH_SHORT);
                                toast1.show();
                            } else {
                                n1 = (Double.parseDouble(ingvalor.getText().toString())) / (Double.parseDouble(fp.getText().toString())) * 746;
                                resultado.setText(String.valueOf(String.format("%.2f", n1)));

                            }
                    }
                }


            }
        });
        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingvalor.setText(String.valueOf(""));
                fp.setText(String.valueOf(""));
            }
        });
    }

    //Metodo para regresar
    public void Regresar(View view){
        Intent regresar = new Intent(this,vistaPrincipal.class);
        startActivity(regresar);
        finish();
    }
}