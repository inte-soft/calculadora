package intesoft.elecal.elec;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

import com.example.electrovir.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Calculototalizadores extends AppCompatActivity {

    private Spinner spinner3;
    private Spinner spinner4;
    private Button calcular1;
    private Button borrar1;
    private EditText fp1;
    private EditText ingvalor1;
    private EditText voltaje;
    private TextView resultado;
    private TextView factorp;
    private AdView mAdView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculototalizadores);

        //inicializar anuncios
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView1);
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


        //Arreglo de las lita desplegable.
        spinner3 = (Spinner)findViewById(R.id.potencia);
        String [] listaDatos = {"kVA","VA","W","kW","kVAR"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_personalizacion, listaDatos);
        spinner3.setAdapter(adapter);

        //Arreglo para seleccionar el tipo de sistema.
        spinner4 = (Spinner)findViewById(R.id.sistema1);
        String [] Fin = {"Trifasico","Bifasico","Monofasico"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.spinner_item_personalizacion, Fin);
        spinner4.setAdapter(adapter1);

        //arreglo edit text
        ingvalor1 = (EditText) findViewById(R.id.ingvalor1);
        fp1 = (EditText) findViewById(R.id.fp1);
        voltaje = (EditText) findViewById(R.id.volt);

        //arreglo text view
        resultado= (TextView) findViewById(R.id.resultado);
        factorp=(TextView)findViewById(R.id.label_factorp);

        //arreglo botones
        calcular1 = (Button) findViewById(R.id.calcular1);
        borrar1= (Button) findViewById(R.id.borrar1);
        //arreglo para inhabilitar factor de potencia
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if ((spinner3.getSelectedItem().toString()=="kW")|| (spinner3.getSelectedItem().toString()=="W")){
                    fp1.setVisibility(View.VISIBLE);
                    factorp.setVisibility(View.VISIBLE);

                }else if (((spinner3.getSelectedItem().toString()=="kVA")|| (spinner3.getSelectedItem().toString()=="VA")|| (spinner3.getSelectedItem().toString()=="kVAR"))){

                    fp1.setVisibility(View.GONE);
                    factorp.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //arreglo para calcular
        calcular1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double n1=0;
                double v=0;
                double fp2=0;
                double p=0;



                if (ingvalor1.getText().toString().isEmpty()) {
                    Toast toast3 = Toast.makeText(getApplicationContext(), "No ha ingresado valor", Toast.LENGTH_SHORT);
                    toast3.show();



                }else if (voltaje.getText().toString().isEmpty()) {
                    Toast toast4 = Toast.makeText(getApplicationContext(), "Ingrese voltaje", Toast.LENGTH_SHORT);
                    toast4.show();

                }else if (((spinner3.getSelectedItem().toString()=="kVA")||(spinner3.getSelectedItem().toString()=="VA"))&&(fp1.getText().toString().isEmpty())) {
                        Toast toast4 = Toast.makeText(getApplicationContext(), "Ingrese factor de potencia", Toast.LENGTH_SHORT);
                        toast4.show();

                //calculo para sistemas trifasicos
                }else {

                    v = Double.parseDouble(voltaje.getText().toString());
                    p = Double.parseDouble(ingvalor1.getText().toString());

                    if (spinner4.getSelectedItem().toString() == "Trifasico") {

                        // calculo totalizador para potencia en va
                        if (spinner3.getSelectedItem().toString() == "VA") {
                            fp2 = Double.parseDouble(fp1.getText().toString());
                            n1 = (p / (v * Math.sqrt(3))) * 1.25;
                            resultado.setText(String.valueOf(String.format("%.2f A", n1)));
                        }
                        // calculo totalizador para potencia en kva
                        if (spinner3.getSelectedItem().toString() == "kVA") {
                            fp2 = Double.parseDouble(fp1.getText().toString());
                            n1 = ((p * 1000) / (v * Math.sqrt(3))) * 1.25;
                            resultado.setText(String.valueOf(String.format("%.2f A", n1)));
                        }
                        // calculo totalizador para potencia en kvar
                        if (spinner3.getSelectedItem().toString() == "kVAR") {
                            n1 = ((p * 1000) / (v * Math.sqrt(3))) * 1.35;
                            resultado.setText(String.valueOf(String.format("%.2f A", n1)));
                        }
                        // calculo totalizador para potencia en kW
                        if (spinner3.getSelectedItem().toString() == "kW") {
                            n1 = ((p * 1000) / (v * Math.sqrt(3)*Math.cos(Math.toRadians(fp2)))) * 1.25;
                            resultado.setText(String.valueOf(String.format("%.2f A", n1)));
                        }
                        // calculo totalizador para potencia en w
                        if (spinner3.getSelectedItem().toString() == "W") {
                            n1 = (p / (v * Math.sqrt(3)*Math.cos(Math.toRadians(fp2)))) * 1.25;
                            resultado.setText(String.valueOf(String.format("%.2f A", n1)));
                        }
                    }

                        //calculo para sistemas bifasicos
                    if (spinner4.getSelectedItem().toString() == "Bifasico") {
                        // calculo totalizador para potencia en va
                        if (spinner3.getSelectedItem().toString() == "VA") {
                            fp2 = Double.parseDouble(fp1.getText().toString());
                            n1 = (p / (v * Math.sqrt(2))) * 1.25;
                            resultado.setText(String.valueOf(String.format("%.2f A", n1)));
                        }
                        // calculo totalizador para potencia en kva
                        if (spinner3.getSelectedItem().toString() == "kVA") {
                            fp2 = Double.parseDouble(fp1.getText().toString());
                            n1 = ((p * 1000) / (v * Math.sqrt(2)  )) * 1.25;
                            resultado.setText(String.valueOf(String.format("%.2f A", n1)));
                        }
                        // calculo totalizador para potencia en kvar
                        if (spinner3.getSelectedItem().toString() == "kVAR") {
                            n1 = ((p * 1000) / (v * Math.sqrt(2))) * 1.35;
                            resultado.setText(String.valueOf(String.format("%.2f A", n1)));
                        }
                        // calculo totalizador para potencia en kW
                        if (spinner3.getSelectedItem().toString() == "kW") {
                            n1 = ((p * 1000) / (v * Math.sqrt(2)*Math.cos(Math.toRadians(fp2)))) * 1.25;
                            resultado.setText(String.valueOf(String.format("%.2f A", n1)));
                        }
                        // calculo totalizador para potencia en w
                        if (spinner3.getSelectedItem().toString() == "W") {
                            n1 = (p / (v * Math.sqrt(2)*Math.cos(Math.toRadians(fp2)))) * 1.25;
                            resultado.setText(String.valueOf(String.format("%.2f A", n1)));
                        }
                    }
                        //calculo para sistemas monofasicos
                    if (spinner4.getSelectedItem().toString() == "Monofasico") {
                            // calculo totalizador para potencia en va
                            if (spinner3.getSelectedItem().toString() == "VA") {
                                fp2 = Double.parseDouble(fp1.getText().toString());
                                n1 = (p / (v * Math.cos(Math.toRadians(fp2)))) * 1.25;
                                resultado.setText(String.valueOf(String.format("%.2f A", n1)));
                            }
                            // calculo totalizador para potencia en kva
                            if (spinner3.getSelectedItem().toString() == "kVA") {
                                fp2 = Double.parseDouble(fp1.getText().toString());
                                n1 = ((p * 1000) / (v)) * 1.25;
                                resultado.setText(String.valueOf(String.format("%.2f A", n1)));
                            }
                            // calculo totalizador para potencia en kvar
                            if (spinner3.getSelectedItem().toString() == "kVAR") {
                                n1 = ((p * 1000) / (v)) * 1.35;
                                resultado.setText(String.valueOf(String.format("%.2f A", n1)));
                            }
                            // calculo totalizador para potencia en kW
                            if (spinner3.getSelectedItem().toString() == "kW") {
                                n1 = ((p * 1000) / (v *Math.cos(Math.toRadians(fp2)))) * 1.25;
                                resultado.setText(String.valueOf(String.format("%.2f A", n1)));
                            }
                            // calculo totalizador para potencia en w
                            if (spinner3.getSelectedItem().toString() == "W") {
                                n1 = (p / (v *Math.cos(Math.toRadians(fp2)))) * 1.25;
                                resultado.setText(String.valueOf(String.format("%.2f A", n1)));
                            }
                    }
                }
            }


        });

        borrar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingvalor1.setText(String.valueOf(""));
                fp1.setText(String.valueOf(""));
                voltaje.setText(String.valueOf(""));
            }
        });




    }


    //Metodo para regresar
    public void Regresar2(View view){
        Intent regresar2 = new Intent(this,vistaPrincipal.class);
        startActivity(regresar2);
        finish();
    }
}