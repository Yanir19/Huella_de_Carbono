package com.example.yanir.huella_de_carbono;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Yanir on 09-06-2015.
 */
public class Calculo_de_huella extends ActionBarActivity{

    private double valor_estandar_hogar =  0.5 ;
    private double valor_estandar_transporte ;
    private EditText consumo_introducido;
    private TextView respuesta;
    private Spinner Tipo_transporte;
    private Spinner Tamano_transporte;
    private String[] Tm_transporte;
    private String [] Seleccion_de_usuario;
    private static Manejador_BD BD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Seleccion_de_usuario = new String[]{"null","null"};
        setContentView(R.layout.consumo_en_el_hogar);

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






    public void transporte_particular_activity (View v){


        setContentView(R.layout.consumo_transporte_particular);

        respuesta = (TextView) findViewById(R.id.Resultado_de_huella2);
        Tipo_transporte = (Spinner)findViewById(R.id.Tipo_transporte);
        Tamano_transporte = (Spinner)findViewById(R.id.Tamano_transporte);

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

        setContentView(R.layout.consumo_transporte_particular);

        respuesta = (TextView) findViewById(R.id.Resultado_de_huella2);
        Tipo_transporte = (Spinner)findViewById(R.id.Tipo_transporte);
        Tamano_transporte = (Spinner)findViewById(R.id.Tamano_transporte);

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

        double consumo_de_usuario = Double.parseDouble(String.valueOf(consumo_introducido.getText()));

        respuesta.setText("Tu emision para este consumo es de : " + String.valueOf(consumo_de_usuario * valor_estandar_hogar) + " KgCo2.");

    };

    public void calculo_consumo_transporte_particular (View v){

        consumo_introducido =(EditText) findViewById(R.id.entrada_de_datos);
        double consumo_de_usuario = Double.parseDouble(String.valueOf(consumo_introducido.getText()));
        respuesta.setText("Tu emision para este consumo es de : " + String.valueOf(consumo_de_usuario * valor_estandar_transporte) + " KgCo2.");

    };

    public void calculo_consumo_transporte_publico (View v){

        consumo_introducido =(EditText) findViewById(R.id.entrada_de_datos);
        double consumo_de_usuario = Double.parseDouble(String.valueOf(consumo_introducido.getText()));
        respuesta.setText("Tu emision para este consumo es de : " + String.valueOf(consumo_de_usuario * valor_estandar_transporte) + " KgCo2.");

    };



}
