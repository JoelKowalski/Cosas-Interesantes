package com.example.usuario.joelfernandezpractica4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Usuario on 14/09/2016.
 */
public class Sqlite extends SQLiteOpenHelper {



    // favorito boleano 0 para no 1 para si id INTEGER PRIMARY KEY AUTOINCREMENT, usuario TEXT, pass TEXT,fav number
    private final String sqlCreacionTablaRecado = "CREATE TABLE RECADO" +
            " (ID NUMBER  PRIMARY KEY AUTOINCREMENT," +
            "Fecha_hora TEXT," +
            "Nombre_cliente TEXT," +
            "TELEFONO NUMBER," +
            "Direccion_recogida TEXT," +
            "Direccion_entrega TEXT," +
            "Descripcion TEXT," +
            "Fecha_hora_maxima TEXT )";


    public Sqlite(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version); //el método padre, llamará a Oncreate o OnUpgrade, segn corresponda
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(sqlCreacionTablaRecado);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){}

    private void cerrarBaseDatos (SQLiteDatabase database)
    {
        database.close();
    }


    public void insertarRecado (Recado recado){
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL("INSERT INTO RECADO (ID,Fecha_hora,Nombre_cliente,TELEFONO,Direccion_recogida,Direccion_entrega,Descripcion,Fecha_hora_maxima)" +
                " VALUES ('NULL' , '"+recado.getFecha_hora()+"', '"+recado.getNombre_cliente()+"', '"+recado.getTelefono()+"', '"+recado.getDireccion_recogida()+"', '"+recado.getDireccion_entrega()+"', '"+recado.getDescripcion()+"', '"+recado.getFecha_hora_maxima()+"')");
        this.cerrarBaseDatos(database);
    }
    /*
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
    }*/


}
