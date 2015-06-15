package com.example.yanir.huella_de_carbono;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Yanir on 24-03-2015.
 */
public class BdHelper extends SQLiteOpenHelper {

    private static final String Nombre_BD = "Tooca.sqlite";
    private static final int BD_VERSION_ESQUEMA = 1;

    public BdHelper(Context context) {
        super(context, Nombre_BD, null, BD_VERSION_ESQUEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Manejador_BD.Valores_Estandar);
        db.execSQL(Manejador_BD.Resultado_de_emision);
        db.execSQL(Manejador_BD._idSabias_que);
        db.execSQL(Manejador_BD.Historial);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
