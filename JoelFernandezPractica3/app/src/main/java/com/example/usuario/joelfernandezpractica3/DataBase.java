package com.example.usuario.joelfernandezpractica3;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Usuario on 29/07/2016.
 */
public class DataBase extends SQLiteOpenHelper {

    // favorito boleano 0 para no 1 para si id INTEGER PRIMARY KEY AUTOINCREMENT, usuario TEXT, pass TEXT,fav number
    private final String sqlCreacionTablaHistorico = "CREATE TABLE HISTORICO (FECHA TEXT PRIMARY KEY,NOMBRE TEXT )";


    public DataBase(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version); //el método padre, llamará a Oncreate o OnUpgrade, segn corresponda
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(sqlCreacionTablaHistorico);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        //En caso de que al constructor le pasemos un número de versión distinto a
        // la base de datos existente, este métdo es invocado. Esto sería necesario
        //cuando modificamos la estrucutura de la base de datos

        //Aquí, deberíamos
        // 1 - Extraer los datos de la vieja versión y copiarlos a la nueva instancia
        // 2 - Crear la nueva versión
        // 3 - Cargar los datos en las tablas de la nueva versión

    }

    private void cerrarBaseDatos (SQLiteDatabase database)
    {
        database.close();
    }


    public void insertarHistorico (HistoricoModelo historicoModelo){
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL("INSERT INTO HISTORICO (FECHA,NOMBRE) VALUES ('"+ historicoModelo.getFecha()+"' , '"+ historicoModelo.getNombre()+"')");
        this.cerrarBaseDatos(database);
    }
    public List<HistoricoModelo> DameHistoricos(){
        List<HistoricoModelo> listahistoricos=new ArrayList<>();

        String consulta = "SELECT FECHA,NOMBRE FROM HISTORICO;";
        SQLiteDatabase basedatos = this.getReadableDatabase();
        Cursor cursor = basedatos.rawQuery(consulta, null);
        if(cursor.moveToFirst()) {
            cursor.moveToFirst();
            do
            {
                try {
                    HistoricoModelo hm;
                    hm = new HistoricoModelo(cursor.getString(0), cursor.getString(1));
                    Log.i("historico",hm.getNombre()+" "+hm.getFecha());
                    listahistoricos.add(hm);
                }catch(Exception e){
                    Log.i("errorsao", e.toString());
                }
            }while (cursor.moveToNext());
            cursor.close();
        }
        return listahistoricos;
    }


}

