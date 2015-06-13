package com.example.yanir.huella_de_carbono;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button boton1;
    private Button boton2;
    private Button boton3;
    private Button boton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton1 = (Button)findViewById(R.id.button1);
        boton1.setOnClickListener(this);
        boton2 = (Button)findViewById(R.id.button2);
        boton2.setOnClickListener(this);
        boton3 = (Button)findViewById(R.id.button3);
        boton3.setOnClickListener(this);
        boton4 = (Button)findViewById(R.id.button4);
        boton4.setOnClickListener(this);
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


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button1:


                break;
            case R.id.button2:


                break;
            case R.id.button3:
                Intent intent = new Intent(this, menu31.class);
                startActivity(intent);

                break;
            case R.id.button4:


                break;



        }

    }
}
