package com.example.yanir.huella_de_carbono;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class menu3 extends Activity implements View.OnClickListener {

    Button b_como;
    Button b_que;
    Button b_tips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu3);
        b_como = (Button) findViewById(R.id.como_boton);
        b_como.setOnClickListener(this);
        b_que = (Button) findViewById(R.id.que_boton);
        b_que.setOnClickListener(this);
        b_tips = (Button) findViewById(R.id.tips_boton);
        b_tips.setOnClickListener(this);
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
        switch (v.getId()){
            case (R.id.que_boton):
                Intent i = new Intent(this, menu311.class);
                i.putExtra("tipo",7);
                startActivity(i);
            break;

            case (R.id.como_boton):
                Intent j = new Intent(this, menu311.class);
                j.putExtra("tipo",8);
                startActivity(j);
            break;

            case (R.id.tips_boton):
                Intent k = new Intent(this, menu31.class);
                startActivity(k);
            break;

        }
    }
}
