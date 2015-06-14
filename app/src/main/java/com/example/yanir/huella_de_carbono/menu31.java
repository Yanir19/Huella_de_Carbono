package com.example.yanir.huella_de_carbono;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Vector;


public class menu31 extends Activity implements View.OnClickListener {

    Button boton_carro;
    Button boton_casa;
    Button boton_rayo;
    Button boton_cocina;
    Button boton_comida;
    Button boton_laptop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu31);
        boton_carro = (Button) findViewById(R.id.boton_carro);
        boton_casa = (Button) findViewById(R.id.boton_casa);
        boton_cocina = (Button) findViewById(R.id.boton_conina);
        boton_comida = (Button) findViewById(R.id.boton_comida);
        boton_laptop = (Button) findViewById(R.id.boton_laptop);
        boton_rayo = (Button) findViewById(R.id.boton_luz);
        boton_carro.setOnClickListener(this);
        boton_rayo.setOnClickListener(this);
        boton_comida.setOnClickListener(this);
        boton_laptop.setOnClickListener(this);
        boton_cocina.setOnClickListener(this);
        boton_casa.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu3, menu);
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

    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.boton_carro:
                Intent i = new Intent(this, menu311.class);
                i.putExtra("tipo", 1);
                startActivity(i);
                break;
            case R.id.boton_casa:
                Intent j = new Intent(this, menu311.class);
                j.putExtra("tipo", 2);
                startActivity(j);
                break;
            case R.id.boton_conina:
                Intent k = new Intent(this, menu311.class);
                k.putExtra("tipo", 3);
                startActivity(k);
                break;
            case R.id.boton_laptop:
                Intent l = new Intent(this, menu311.class);
                l.putExtra("tipo", 4);
                startActivity(l);
                break;

            case R.id.boton_luz:
                Intent m = new Intent(this, menu311.class);
                m.putExtra("tipo", 5);
                startActivity(m);
                break;

            case R.id.boton_comida:
                Intent n = new Intent(this, menu311.class);
                n.putExtra("tipo", 6);
                startActivity(n);
                break;

        }
    }





}