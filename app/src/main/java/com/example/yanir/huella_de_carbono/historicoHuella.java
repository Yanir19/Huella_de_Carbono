package com.example.yanir.huella_de_carbono;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class historicoHuella extends Activity implements View.OnClickListener {

    private int[] tiposDePaticas = {R.drawable.ic_huella_amarilla,R.drawable.ic_huella_naranja,R.drawable.ic_huella_negra,R.drawable.ic_huella_roja};
    private LinearLayout imagenesHorizontales;
    private ArrayList<Patica> paticas;
    TextView tv_tips;
    ImageView iv_patica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_huella);
        paticas = new ArrayList<Patica>();
        inicializarPaticas(paticas,tiposDePaticas);
        iv_patica = (ImageView) findViewById(R.id.imageViewPatica);
        imagenesHorizontales = (LinearLayout) findViewById(R.id.imagenesHorizontales);
        for(int i=0;i<paticas.size();i++){
            imagenesHorizontales.addView(paticas.get(i).getAccesorio());

        }
        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"DK Crayon Crumble.ttf");
        tv_tips = (TextView) findViewById(R.id.textview_tips);
        tv_tips.setTypeface(myTypeface);
    }

    @Override
    public void onClick(View v) {
        int i=0;
        while(v.getId() != paticas.get(i).getCedula())
            i++;

        tv_tips.setText(paticas.get(i).getSugerencias());
        iv_patica.setImageResource(paticas.get(i).getRecurso());

    }


    private class Patica {

        private ImageView patica;
        private int idRecurso;
        private int cedula;
        private String sugerencias;

        //GETTERS Y SETTERS
        public ImageView getAccesorio(){
            return patica;
        }
        public int getRecurso(){
            return idRecurso;
        }
        public int getCedula() {
            return cedula;
        }
        public void setCedula(int cedula) {
            this.cedula = cedula;
        }

        public void setSugerencias(String sugerencias) {
            this.sugerencias = sugerencias;
        }

        public String getSugerencias() {
            return sugerencias;
        }

        /**
         *
         * @param vistaAccesorio ImageView donde se encuentra la imagen
         * @param id El id del recurso utilizdo (El de la imagen)
         * @param context   El contexto donde se ejecutara el evento de click
         */
        public Patica(ImageView vistaAccesorio,int id,Context context, int cedula,String sugerencia){
            this.patica = vistaAccesorio;
            this.idRecurso = id;
            this.patica.setImageResource(id);
            this.patica.setOnClickListener((View.OnClickListener) context);
            this.patica.setId(cedula);
            this.cedula=cedula;
            sugerencias = new String();
            this.sugerencias = sugerencia;
            LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.gravity= Gravity.CENTER;
        }
    }


    private void inicializarPaticas(ArrayList<Patica> paticasArray, int[] tiposDePaticas){
        for(int i=0;i<tiposDePaticas.length;i++){
            paticasArray.add(new Patica(new ImageView(this),tiposDePaticas[i],this,i,"Aqui debe ir el String sacado de la BD con la sugerencia personalizada"));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_historico_huella, menu);
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
