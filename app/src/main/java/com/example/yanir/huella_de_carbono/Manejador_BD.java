package com.example.yanir.huella_de_carbono;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Yanir on 24-03-2015.
 */
public class Manejador_BD {


        // Codigo SQLite para la creacion de la tabla usuario;
        public static final  String Valores_Estandar =
                "CREATE TABLE Valores_Estandar ( " +
                "  `_id` INTEGER PRIMARY KEY   AUTOINCREMENT, " +
                "  `area` VARCHAR(45) NOT NULL, " +
                "  `dato` VARCHAR(45) NOT NULL, " +
                "  `co2` FLOAT(11) NOT NULL ); " ;

        public static final  String Resultado_de_emision =  "CREATE TABLE Resultado_de_emision ( " +
                "   `_idResultados` INTEGER  PRIMARY KEY AUTOINCREMENT  NOT NULL, " +
                "   `resultado` DOUBLE NOT NULL, " +
                "   'fecha' DATE NOT NULL, " +
                "   'mensaje' VARCHAR(100) NOT NULL); " ;


    public static final  String _idSabias_que = " CREATE TABLE  _idSabias_que  ( " +
                "  `_idSabias_que` INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL, " +
                "  `Tipo` VARCHAR(45) NOT NULL, " +
                "  `Mensaje` VARCHAR(45) NOT NULL); ";


        public static final  String Historial =  "CREATE TABLE Historial ( " +
                "  `Valores_Estandar__id`  INTEGER REFERENCES Valores_Estandar(_id) ON UPDATE CASCADE, " +
                "  `Resultado_de_emision__id`  INTEGER REFERENCES Resultado_de_emision(_idSabias_que) ON UPDATE CASCADE, " +
                "  `Fecha` VARCHAR(45) NOT NULL ); " ;



    private BdHelper helper ;
        private SQLiteDatabase BD ;

        // Constructor de la base de datos.
        public Manejador_BD(Context context) {
            helper = new BdHelper(context);
            BD = helper.getWritableDatabase();
        }

    public void Push_BD (String codigo) {
        BD.execSQL(codigo);
    }

    //Funcion para realiza consultas sobre la base de datos
    public Cursor Get_BD (String consulta){
        Cursor C ;
        return  C = BD.rawQuery(consulta,null);
    }




}
