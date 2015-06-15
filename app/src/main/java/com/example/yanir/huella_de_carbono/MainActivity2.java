package com.example.yanir.huella_de_carbono;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity2 extends ActionBarActivity {

    private static Manejador_BD BD;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BD = new Manejador_BD(this);
        BD.Push_BD("INSERT INTO Valores_Estandar (area,dato,co2)  VALUES('Hogar','Electricidad','0.5');");
        BD.Push_BD("INSERT INTO Valores_Estandar (area,dato,co2)  VALUES('Gasolina','Pequeño','0.15991');");
        BD.Push_BD("INSERT INTO Valores_Estandar (area,dato,co2)  VALUES('Gasolina','Mediano','0.20018');");
        BD.Push_BD("INSERT INTO Valores_Estandar (area,dato,co2)  VALUES('Gasolina','Grande','0.28944');");
        BD.Push_BD("INSERT INTO Valores_Estandar (area,dato,co2)  VALUES('Diesel','Pequeño','0.14519');");
        BD.Push_BD("INSERT INTO Valores_Estandar (area,dato,co2)  VALUES('Diesel','Mediano','0.17538');");
        BD.Push_BD("INSERT INTO Valores_Estandar (area,dato,co2)  VALUES('Diesel','Grande','0.22867');");
        BD.Push_BD("INSERT INTO Valores_Estandar (area,dato,co2)  VALUES('Moto','Pequeño','0.08499');");
        BD.Push_BD("INSERT INTO Valores_Estandar (area,dato,co2)  VALUES('Moto','Mediano','0.10316');");
        BD.Push_BD("INSERT INTO Valores_Estandar (area,dato,co2)  VALUES('Moto','Grande','0.0.13724');");
        BD.Push_BD("INSERT INTO Valores_Estandar (area,dato,co2)  VALUES('Taxi','estandar','0.17625');");
        BD.Push_BD("INSERT INTO Valores_Estandar (area,dato,co2)  VALUES('Autobus','estandar','0.10067');");
        BD.Push_BD("INSERT INTO Valores_Estandar (area,dato,co2)  VALUES('Metro','estandar','0.035645');");

        Intent intent = new Intent(MainActivity2.this, Calculo_de_huella.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
