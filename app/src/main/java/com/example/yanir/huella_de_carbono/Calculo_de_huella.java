package com.example.yanir.huella_de_carbono;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 * Created by Yanir on 09-06-2015.
 */
public class Calculo_de_huella extends Activity implements View.OnClickListener {

    private double valor_estandar_hogar =  0.5 ;
    private double valor_estandar_transporte ;
    private double resultados_de_consumos [] = new double[3];
    private EditText consumo_introducido;
    private TextView respuesta;
    private Spinner Tipo_transporte;
    private Spinner Tamano_transporte;
    private String[] Tm_transporte;
    private String [] Seleccion_de_usuario;
    private ImageView huella;
    private static Manejador_BD BD;
    private TextView informacion1;
    private TextView informacion2;
    private TextView informacion3;
    private Button carroenbus;
    private Button carroencasa;
    private Button busencarro;
    private Button busencasa;
    private Button casaencarro;
    private Button casaenbus;
    LinearLayout ll_elSwipe1;
    LinearLayout ll_elSwipe2;
    LinearLayout ll_elSwipe3;
    private tips tipPaticas;
    Vector<String> tips_paticas = new Vector<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Seleccion_de_usuario = new String[]{"null","null"};
        setContentView(R.layout.consumo_en_el_hogar);
        informacion1 = (TextView) findViewById(R.id.Informacion);
        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"DK Crayon Crumble.ttf");
        informacion1.setTypeface(myTypeface);
        carroencasa = (Button) findViewById(R.id.botoncarroencasa);
        busencasa = (Button) findViewById(R.id.botonbusencasa);
        busencasa.setOnClickListener(this);
        carroencasa.setOnClickListener(this);
        ll_elSwipe1 = (LinearLayout) findViewById(R.id.elSwipe_layout);
        ll_elSwipe1.setOnTouchListener(new OnSwipeTouchListener(this) {

            public void onSwipeTop() {
            }
            public void onSwipeRight() {

            }
            public void onSwipeLeft() {
                transporte_particular_activity(ll_elSwipe1);
            }
            public void onSwipeBottom() {
            }
            public void onTouchable() {
            }
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculadora, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


public void consumo_hogar_activity (View v){
    Seleccion_de_usuario = new String[]{"null","null"};
    setContentView(R.layout.consumo_en_el_hogar);
    informacion1 = (TextView) findViewById(R.id.Informacion);
    Typeface myTypeface = Typeface.createFromAsset(getAssets(),"DK Crayon Crumble.ttf");
    informacion1.setTypeface(myTypeface);
    carroencasa = (Button) findViewById(R.id.botoncarroencasa);
    busencasa = (Button) findViewById(R.id.botonbusencasa);
    busencasa.setOnClickListener(this);
    carroencasa.setOnClickListener(this);
    ll_elSwipe1 = (LinearLayout) findViewById(R.id.elSwipe_layout);
    ll_elSwipe1.setOnTouchListener(new OnSwipeTouchListener(this) {

        public void onSwipeTop() {
        }
        public void onSwipeRight() {

        }
        public void onSwipeLeft() {
            transporte_particular_activity(ll_elSwipe1);
        }
        public void onSwipeBottom() {
        }
        public void onTouchable() {
        }
        public boolean onTouch(View v, MotionEvent event) {
            return gestureDetector.onTouchEvent(event);
        }
    });
};



    public void transporte_particular_activity (View v){


        setContentView(R.layout.consumo_transporte_particular);

        respuesta = (TextView) findViewById(R.id.Resultado_de_huella2);
        Tipo_transporte = (Spinner)findViewById(R.id.Tipo_transporte);
        Tamano_transporte = (Spinner)findViewById(R.id.Tamano_transporte);
        informacion2 = (TextView) findViewById(R.id.Informacion);
        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"DK Crayon Crumble.ttf");
        informacion2.setTypeface(myTypeface);
        busencarro = (Button) findViewById(R.id.botonbusencarro);
        casaencarro = (Button) findViewById(R.id.botoncasaencarro);
        busencarro.setOnClickListener(this);
        casaencarro.setOnClickListener(this);
        ll_elSwipe2 = (LinearLayout) findViewById(R.id.elSwipe_layout2);
        ll_elSwipe2.setOnTouchListener(new OnSwipeTouchListener(this) {

            public void onSwipeTop() {
            }
            public void onSwipeRight() {
                consumo_hogar_activity(ll_elSwipe2);
            }
            public void onSwipeLeft() {
                transporte_publico_activity(ll_elSwipe2);
            }
            public void onSwipeBottom() {
            }
            public void onTouchable() {
            }
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        });

        final String[] Tp_transporte =
                new String[]{"Carro - Gasolina","Carro - Diesel","Moto"};



        //Alternativa 1: Array java
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, Tp_transporte);

        //Alternativa 2: Recurso XML de tipo string-array
        //ArrayAdapter<CharSequence> adaptador =
        //	    ArrayAdapter.createFromResource(this,
        //	        R.array.valores_array, android.R.layout.simple_spinner_item);

        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        Tipo_transporte.setAdapter(adaptador);

        Tipo_transporte.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {

               //         respuesta.setText("Seleccionado: " + parent.getItemAtPosition(position));

                        Seleccion_de_usuario [0] = (String) parent.getItemAtPosition(position);
                        switch ((String) parent.getItemAtPosition(position) ) {
                            case "Carro - Gasolina":
                                Tm_transporte = new String[]{"Pequeño - hasta 1.4 ltrs. ","Mediano (1.4 - 2.0) ltrs. ","Grande 2.0 ltrs en adelante."};
                                break;
                            case "Carro - Diesel":
                                Tm_transporte = new String[]{"Pequeño - hasta 1.7 ltrs. ","Mediano (1.7 - 2.0) ltrs. ","Grande 2.0 ltrs en adelante."};
                                break;
                            case "Moto":
                                Tm_transporte = new String[]{"Pequeña 125cc.","Mediana (125 - 500) cc.","Grande 500cc en adelante."};
                                break;
                        };

/*******************************************************************************************/

                        //Alternativa 1: Array java
                        ArrayAdapter<String> adaptador_tamano_transporte =
                                new ArrayAdapter<String>(Calculo_de_huella.this,
                                        android.R.layout.simple_spinner_item, Tm_transporte);

                        adaptador_tamano_transporte.setDropDownViewResource(
                                android.R.layout.simple_spinner_dropdown_item);

                        Tamano_transporte.setAdapter(adaptador_tamano_transporte);

                        Tamano_transporte.setOnItemSelectedListener(
                                new AdapterView.OnItemSelectedListener() {
                                    public void onItemSelected(AdapterView<?> parent,
                                                               android.view.View v, int position, long id) {

                                     //


                                        Seleccion_de_usuario [1] = parent.getItemAtPosition(position).toString().substring (0 , parent.getItemAtPosition(position).toString().indexOf(' '));
                                        respuesta.setText("Seleccionado: " + Seleccion_de_usuario [1]);

                                        BD = new Manejador_BD(Calculo_de_huella.this);
                                        Cursor Co2;

                                        switch (Seleccion_de_usuario [0] ) {
                                            case "Carro - Gasolina":
                                                Co2 = BD.Get_BD("SELECT co2 FROM Valores_Estandar where area = 'Gasolina' and dato = '"+Seleccion_de_usuario [1] +"' ;");

                                                if (Co2.moveToFirst()) {
                                                    //Recorremos el cursor hasta que no haya más registros
                                                    do {
                                                        valor_estandar_transporte = (Co2.getDouble(0));
                                                        respuesta.setText("Seleccionado: " + valor_estandar_transporte);
                                                    } while(Co2.moveToNext());
                                                }

                                                break;
                                            case "Carro - Diesel":
                                                Co2 = BD.Get_BD("SELECT co2 FROM Valores_Estandar where area = 'Diesel' and dato = '"+Seleccion_de_usuario [1] +"' ;");

                                                if (Co2.moveToFirst()) {
                                                    do {
                                                        valor_estandar_transporte = (Co2.getDouble(0));
                                                        respuesta.setText("Seleccionado: " + valor_estandar_transporte);
                                                    } while(Co2.moveToNext());
                                                }

                                                break;
                                            case "Moto":
                                                Co2 = BD.Get_BD("SELECT co2 FROM Valores_Estandar where area = 'Moto' and dato = '"+Seleccion_de_usuario [1] +"' ;");

                                                if (Co2.moveToFirst()) {
                                                    do {
                                                        valor_estandar_transporte = (Co2.getDouble(0));
                                                        respuesta.setText("Seleccionado: " + valor_estandar_transporte);
                                                    } while(Co2.moveToNext());
                                                }

                                                break;
                                        };

                                    }

                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }

                                });
       /***********************************************************************************************************************************/

                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        respuesta.setText("");
                    }

                });
    };

    public void transporte_publico_activity (View v) {

        setContentView(R.layout.consumo_en_transporte_publico);

        respuesta = (TextView) findViewById(R.id.Resultado_de_huella);
        Tipo_transporte = (Spinner)findViewById(R.id.spinner2);
        informacion3 = (TextView) findViewById(R.id.Informacion);
        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"DK Crayon Crumble.ttf");
        informacion3.setTypeface(myTypeface);
        carroenbus = (Button) findViewById(R.id.botoncarroenbus);
        casaenbus = (Button) findViewById(R.id.botoncasaenbus);
        carroenbus.setOnClickListener(this);
        casaenbus.setOnClickListener(this);
        ll_elSwipe3 = (LinearLayout) findViewById(R.id.elSwipe_layout3);
        ll_elSwipe3.setOnTouchListener(new OnSwipeTouchListener(this) {

            public void onSwipeTop() {
            }
            public void onSwipeRight() {
                transporte_particular_activity(ll_elSwipe1);
            }
            public void onSwipeLeft() {
            }
            public void onSwipeBottom() {
            }
            public void onTouchable() {
            }
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        });
        final String[] Tp_transporte =
                new String[]{"Taxi","Autobus","Metro"};



        //Alternativa 1: Array java
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, Tp_transporte);

        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        Tipo_transporte.setAdapter(adaptador);

        Tipo_transporte.setOnItemSelectedListener(

                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {

                        //respuesta.setText("Seleccionado: " + parent.getItemAtPosition(position));
                        Cursor Co2;
                        Seleccion_de_usuario[0] = (String) parent.getItemAtPosition(position);
                        switch (Seleccion_de_usuario[0]) {
                            case "Taxi":
                                Co2 = BD.Get_BD("SELECT co2 FROM Valores_Estandar where area = '" + parent.getItemAtPosition(position).toString() + "' ;");

                                if (Co2.moveToFirst()) {
                                    //Recorremos el cursor hasta que no haya más registros
                                    do {
                                        valor_estandar_transporte = (Co2.getDouble(0));
                                        respuesta.setText("Seleccionado: " + valor_estandar_transporte);
                                    } while (Co2.moveToNext());
                                }

                                break;
                            case "Autobus":
                                Co2 = BD.Get_BD("SELECT co2 FROM Valores_Estandar where area = '" + parent.getItemAtPosition(position).toString() + "' ;");

                                if (Co2.moveToFirst()) {
                                    do {
                                        valor_estandar_transporte = (Co2.getDouble(0));
                                        respuesta.setText("Seleccionado: " + valor_estandar_transporte);
                                    } while (Co2.moveToNext());
                                }

                                break;
                            case "Metro":
                                Co2 = BD.Get_BD("SELECT co2 FROM Valores_Estandar where area = '" + parent.getItemAtPosition(position).toString() + "' ;");

                                if (Co2.moveToFirst()) {
                                    do {
                                        valor_estandar_transporte = (Co2.getDouble(0));
                                        respuesta.setText("Seleccionado: " + valor_estandar_transporte);
                                    } while (Co2.moveToNext());
                                }

                                break;
                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        respuesta.setText("No se ha seleccionado nada. ");
                    }

                });
    };

    public void calculo_consumo_hogar (View v){

        consumo_introducido =(EditText) findViewById(R.id.entrada_de_datos);
        respuesta = (TextView) findViewById(R.id.Resultado_de_huella);
        if(consumo_introducido.getText().toString().equals(""))
            consumo_introducido.setText("0");
        double consumo_de_usuario = Double.parseDouble(String.valueOf(consumo_introducido.getText()));
        resultados_de_consumos [0] =  consumo_de_usuario * valor_estandar_hogar ;
        respuesta.setText("Tu emision para este consumo es de : " + String.valueOf(resultados_de_consumos [0]) + " KgCo2.");

    };

    public void calculo_consumo_transporte_particular (View v){

        consumo_introducido =(EditText) findViewById(R.id.entrada_de_datos);
        if(consumo_introducido.getText().toString().equals(""))
            consumo_introducido.setText("0");
        double consumo_de_usuario = Double.parseDouble(String.valueOf(consumo_introducido.getText()));
        resultados_de_consumos [1] = new Double(consumo_de_usuario * valor_estandar_hogar) ;
        respuesta.setText("Tu emision para este consumo es de : " + String.valueOf(resultados_de_consumos [1]) + " KgCo2.");

    };

    public void calculo_consumo_transporte_publico (View v){

        consumo_introducido =(EditText) findViewById(R.id.entrada_de_datos);
        if(consumo_introducido.getText().toString().equals(""))
            consumo_introducido.setText("0");
        double consumo_de_usuario = Double.parseDouble(String.valueOf(consumo_introducido.getText()));
        resultados_de_consumos [2] = new Double(consumo_de_usuario * valor_estandar_hogar) ;
        respuesta.setText("Tu emision para este consumo es de : " + String.valueOf(resultados_de_consumos [2]) + " KgCo2.");


    };



    public void resultado_de_huella_activity (View v) {

        setContentView(R.layout.resultado_de_huella);
        tipPaticas = new tips();
        TextView mensaje = (TextView) findViewById(R.id.mensaje);
        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"DK Crayon Crumble.ttf");
        mensaje.setTypeface(myTypeface);
        ImageView huella = (ImageView) findViewById(R.id.ImageHuella);
        double resultado_final = 0;

        for(int i= 0; i<=2; i++) {
            resultado_final += resultados_de_consumos[i];
        }

        mensaje.setText(" Tu calculo fue de "+String.valueOf(resultado_final)+" KgC02\n");

        if(resultado_final <=6*30){
            tips_paticas=tipPaticas.agregarTips(13);
            mensaje.setText(mensaje.getText()+"Tu color es verde\ny estos son los tips que escogimos para ti:\n\n");
            huella.setImageResource(R.drawable.ic_huellacarbono2);
        }

        if(resultado_final >6*30 && resultado_final <= 14*30){
            tips_paticas=tipPaticas.agregarTips(9);
            mensaje.setText(mensaje.getText()+"Tu color es amarillo\ny estos son los tips que escogimos para ti:\n\n");
            huella.setImageResource(R.drawable.ic_huella_amarilla);
        }

        if(resultado_final >14*30 && resultado_final <= 22*30){
            tips_paticas=tipPaticas.agregarTips(10);
            mensaje.setText(mensaje.getText()+"Tu color es anaranjado\ny estos son los tips que escogimos para ti:\n\n");
            huella.setImageResource(R.drawable.ic_huella_naranja);
        }

        if(resultado_final >22*30 && resultado_final <= 30*30){
            tips_paticas=tipPaticas.agregarTips(12);
            mensaje.setText(mensaje.getText()+"Tu color es rojo\ny estos son los tips que escogimos para ti:\n\n");
            huella.setImageResource(R.drawable.ic_huella_roja);
        }

        if(resultado_final > 30*30){
            tips_paticas=tipPaticas.agregarTips(11);
            mensaje.setText(mensaje.getText()+"Tu color es negro\ny estos son los tips que escogimos para ti:\n\n" +
                    "");
            huella.setImageResource(R.drawable.ic_huella_negra);
        }


        for(int i=0; i<tips_paticas.size();i++){
            mensaje.setText(mensaje.getText()+tips_paticas.get(i)+"\n");
        }


        //YA esta el resultado completo

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fecha = new Date();
        String currentDateandTime = sdf.format(fecha);



        BD.Push_BD("INSERT INTO Resultado_de_emision (resultado,fecha,mensaje)  VALUES('"+resultado_final+"','"+currentDateandTime+"','"+mensaje.getText()+"');");



    };

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case (R.id.botoncarroenbus):
                transporte_particular_activity(v);
                break;
            case (R.id.botoncarroencasa):
                transporte_particular_activity(v);
                break;

            case (R.id.botoncasaenbus):
                consumo_hogar_activity(v);
                break;
            case (R.id.botoncasaencarro):
                consumo_hogar_activity(v);
                break;

            case (R.id.botonbusencarro):
                transporte_publico_activity(v);
                break;
            case (R.id.botonbusencasa):
                transporte_publico_activity(v);
                break;

            default:
                System.out.println("ENTRE CON EL ID "+v.getId());

        }


    }


}
