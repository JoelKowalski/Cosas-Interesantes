package com.example.usuario.joelfernandezpractica1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Usuario on 10/06/2016.
 */
public class DataBase extends SQLiteOpenHelper {

            // favorito boleano 0 para no 1 para si
    private final String sqlCreacionTablaUsuario = "CREATE TABLE USUARIO (id INTEGER PRIMARY KEY AUTOINCREMENT, usuario TEXT, pass TEXT,fav number)";
    private final String sqlCreacionTablaFoto = ("CREATE TABLE FOTO(idusuario TEXT  references USUARIO(usuario),foto number)");

    public DataBase(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version); //el método padre, llamará a Oncreate o OnUpgrade, segn corresponda
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(sqlCreacionTablaUsuario);
        db.execSQL(sqlCreacionTablaFoto);
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

    public int ComprobarExistente(String user) {
        String consulta = "SELECT usuario FROM USUARIO WHERE usuario LIKE '%"+user+"%';";
        SQLiteDatabase basedatos = this.getReadableDatabase();
        Cursor cursor = basedatos.rawQuery(consulta, null);
        if(cursor.moveToFirst()){
           cursor.moveToFirst();
            if(user.equals(cursor.getString(0))){
                return 0;//usuario y edittext coinciden
            }else{
                return 1;//usuario y edittext no coinciden
            }
        }else{
           return 2;  //la base de datos esta vacia
        }

    }
    public int ComprobarPass(String user,String pass){
        String consulta = "SELECT pass FROM USUARIO WHERE usuario LIKE '%"+user+"%';";
        SQLiteDatabase basedatos = this.getReadableDatabase();
        Cursor cursor = basedatos.rawQuery(consulta, null);
        if(cursor.moveToFirst()){
            cursor.moveToFirst();
            if(pass.equals(cursor.getString(0))){
                return 0;//usuario y edittext coinciden
            }else{
                return 1;//usuario y edittext no coinciden
            }
        }else{
            return 2;  //la base de datos esta vacia
        }
    }

    public void insertarusuario (Usuario usuario){
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL("INSERT INTO USUARIO (usuario,pass,fav) VALUES ('"+ usuario.getUser()+"' , '"+ usuario.getPass()+"', "+ usuario.getFav()+")");
        this.cerrarBaseDatos(database);
    }

    public void insertarFav (String usuario,int codigoFoto){
        if(!fotoYaEsFav(codigoFoto,usuario)) {
            SQLiteDatabase database = this.getWritableDatabase();
            database.execSQL("INSERT INTO FOTO (idusuario,foto) VALUES ('"+ usuario +"' , "+ codigoFoto +");");
            this.cerrarBaseDatos(database);
        }
    }
    public boolean fotoYaEsFav(int idfoto,String usuario){
        String consulta = "SELECT * FROM FOTO where foto = "+idfoto+" and idusuario= '"+usuario+"';";
        SQLiteDatabase basedatos = this.getReadableDatabase();
        Cursor cursor = basedatos.rawQuery(consulta, null);
        if(cursor.moveToFirst()) {

                return true;//esa foto no es fav

        }else{
            return false;
        }

    }
    public int[] DameFavs(String usuario){
        int[] favoritos;
        int contadorDefotos=0;
        int foto=0;
        String consulta = "SELECT foto FROM FOTO where idusuario = '"+usuario+"';";
        SQLiteDatabase basedatos = this.getReadableDatabase();
        Cursor cursor = basedatos.rawQuery(consulta, null);
        favoritos= new int[cursor.getCount()];
        contadorDefotos=cursor.getCount();
        if(cursor.moveToFirst()) {
            cursor.moveToFirst();
            do
            {
                foto=cursor.getInt(0);
                favoritos[contadorDefotos-1]=foto;
                contadorDefotos--;
            }while (cursor.moveToNext());
            cursor.close();
        }

        return favoritos;
    }
    public int DameLongitud(String usuario) {
        String consulta = "SELECT count(foto) FROM FOTO where idusuario = '"+usuario+"';";
        SQLiteDatabase basedatos = this.getReadableDatabase();
        Cursor cursor = basedatos.rawQuery(consulta, null);
        cursor.moveToFirst();
        return cursor.getInt(0);
    }
    public void eliminarFav(String usuario,int codigoFoto){
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL("Delete from foto where idusuario='"+usuario+"' and foto="+codigoFoto+";");
        this.cerrarBaseDatos(database);
    }


}
