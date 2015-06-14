package com.example.yanir.huella_de_carbono;

import java.util.Vector;

/**
 * Created by LjnozZ on 13/06/2015.
 */
public class tips {

    Vector<String> tips_carro = new Vector<String>();
    Vector<String> tips_casa = new Vector<String>();
    Vector<String> tips_luz = new Vector<String>();
    Vector<String> tips_cocina = new Vector<String>();
    Vector<String> tips_comida = new Vector<String>();
    Vector<String> tips_laptop = new Vector<String>();
    Vector<String> que_es_la_huella = new Vector<String>();
    Vector<String> como_se_calcula = new Vector<String>();



    public tips() {


    }

    public Vector agregarTips(int tipo){
        switch (tipo){
            case 1:
                tips_carro.add("Mantenga bien infladas y calibradas las llantas de su carro. Esta acción le permite ahorrar gasolina, además el motor no la quema en exceso.");
                tips_carro.add("Usa gasolina sin plomo, ya hay suficiente en las calles de Venezuela");
                tips_carro.add("Ponle un mataburro al carro; el libertinaje lo amerita");
            return tips_carro;

            case 2:
                tips_casa.add("No apagues la luz de tu casa al salir, así confundes a la \"sensación de inseguridad\" ");
             return tips_casa;

            case 3:
                tips_cocina.add("Tips de cocina");
            return tips_cocina;

            case 4:
                tips_laptop.add("Tips de laptop");
            return tips_laptop;

            case 5:
                tips_luz.add("Tips de luz");
            return tips_luz;

            case 6:
                tips_comida.add("Tips de comida");
            return tips_comida;

            case 7:
                que_es_la_huella.add("Primera pizarra de que es la huella");
            return que_es_la_huella;

            case 8:
                como_se_calcula.add("Primera pizarra de como se calcula");
            return como_se_calcula;

        }

        return tips_carro;
    }



}
