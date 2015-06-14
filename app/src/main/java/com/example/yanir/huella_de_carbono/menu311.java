package com.example.yanir.huella_de_carbono;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Vector;


public class menu311 extends Activity {

TextView tv_tips;
ImageView iv_tipo;
int tipo;
LinearLayout ll_elSwipe;
int indice;
Tips tips;
Vector<String> vector_tips = new Vector<String>();
TextView tv_superior;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu311);
        Bundle bundle = getIntent().getExtras();
        indice = 0;
        tips = new Tips();
        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"DK Crayon Crumble.ttf");
        tv_tips = (TextView) findViewById(R.id.textview_tips);
        tv_superior = (TextView) findViewById(R.id.superior_textView);
        tv_tips.setTypeface(myTypeface);
        tv_superior.setTypeface(myTypeface);

        iv_tipo = (ImageView) findViewById(R.id.imageView_tipo);
        tipo=bundle.getInt("tipo");
        setearPorTipo(tipo);
        ll_elSwipe = (LinearLayout) findViewById(R.id.elSwipe_layout);
        ll_elSwipe.setOnTouchListener(new OnSwipeTouchListener(this) {

            public void onSwipeTop() {
            }
            public void onSwipeRight() {
                if(indice>0)
                    indice--;
                tv_tips.setText(vector_tips.elementAt(indice));
            }
            public void onSwipeLeft() {
                if(indice<vector_tips.size())
                    indice++;
                tv_tips.setText(vector_tips.elementAt(indice));
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
        getMenuInflater().inflate(R.menu.menu_menu311, menu);
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

    public void setearPorTipo (int cualTipo){
        switch (cualTipo){

            case 1:
                iv_tipo.setImageResource(R.drawable.ic_maps_directions_car);
                vector_tips = tips.agregarTips(1);
                    tv_tips.setText(vector_tips.elementAt(0));
                break;
            case 2:
                iv_tipo.setImageResource(R.drawable.ic_action_home_presionada);
                vector_tips = tips.agregarTips(2);
                tv_tips.setText(vector_tips.elementAt(0));
                break;
            case 3:
                iv_tipo.setImageResource(R.drawable.ic_kitchen_presionada);
                vector_tips = tips.agregarTips(3);
                tv_tips.setText(vector_tips.elementAt(0));
                break;
            case 4:
                iv_tipo.setImageResource(R.drawable.ic_hardware_laptop_mac_presionada);
                vector_tips = tips.agregarTips(4);
                tv_tips.setText(vector_tips.elementAt(0));
                break;
            case 5:
                iv_tipo.setImageResource(R.drawable.ic_image_flash_on_presionado);
                vector_tips = tips.agregarTips(5);
                tv_tips.setText(vector_tips.elementAt(0));
                break;
            case 6:
                iv_tipo.setImageResource(R.drawable.ic_alimentacion_presionada);
                vector_tips = tips.agregarTips(6);
                tv_tips.setText(vector_tips.elementAt(0));
                break;
            case 7:
                System.out.println("ENTRE AQUI");
                iv_tipo.setImageResource(R.drawable.ic_transparente);
                tv_superior.setText("¿Que es la Huella de Carbono?");
                vector_tips = tips.agregarTips(7);
                tv_tips.setText(vector_tips.elementAt(0));
                break;
            case 8:
                iv_tipo.setImageResource(R.drawable.ic_transparente);
                tv_superior.setText("¿Como se calcula?");
                vector_tips = tips.agregarTips(8);
                tv_tips.setText(vector_tips.elementAt(0));
                break;

        }


    }


}
