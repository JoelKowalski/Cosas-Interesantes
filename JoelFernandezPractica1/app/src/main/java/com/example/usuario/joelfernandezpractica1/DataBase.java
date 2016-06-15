package com.example.usuario.joelfernandezpractica1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Usuario on 10/06/2016.
 */
public class DataBase extends SQLiteOpenHelper {

            // favorito boleano 0 para no 1 para si
    private final String sqlCreacionTablaUsuario = "CREATE TABLE USUARIO (id INTEGER PRIMARY KEY AUTOINCREMENT, usuario TEXT, pass TEXT,fav number)";
    private final String sqlCreacionTablaFoto = ("CREATE TABLE FOTO(idfoto INTEGER PRIMARY KEY references USUARIO(id),foto number)");

    public DataBase(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version); //el método padre, llamará a Oncreate o OnUpgrade, segn corresponda
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(sqlCreacionTablaUsuario);

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
    public void insertarusuario (Usuario usuario){
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL("INSERT INTO USUARIO (usuario,pass,fav) VALUES ('"+ usuario.getUser()+"' , '"+ usuario.getPass()+"', "+ usuario.getFav()+")");
        this.cerrarBaseDatos(database);
    }
/*
    public void insertarCoche (Coche coche)
    {

        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL("INSERT INTO COCHE (modelo, idpersona) VALUES ('"+coche.getModelo()+"' , "+coche.getPersona().getId()+")");
        this.cerrarBaseDatos(database);
    }

    public Persona buscarPersona (String nombre)
    {
        Persona persona = null;
        int aux_id = -1;
        String nombre_aux = null;

        String consulta = "SELECT id, nombre FROM PERSONA WHERE nombre LIKE %"+nombre+"%;";


        SQLiteDatabase basedatos = this.getReadableDatabase();
        Cursor cursor = basedatos.rawQuery(consulta, null);


        if( cursor != null || cursor.getCount() >=0)
        {
            cursor.moveToFirst();

            aux_id = cursor.getInt(0); //la posicion primera, el id
            nombre_aux = cursor.getString(1); //la posicion segunda, el id
            persona = new Persona(aux_id, nombre_aux);

            cursor.close();
        }

        this.cerrarBaseDatos(basedatos);

        return persona;
    }



    public List<Coche> buscarCochesPersona (Persona persona)
    {
        List<Coche> lista_coches = null;
        Coche coche = null;
        int aux_id = -1;
        String modelo = null;


        String consulta = "SELECT modelo FROM COCHE WHERE idpersona ="+persona.getId();

        SQLiteDatabase basedatos = this.getReadableDatabase();
        Cursor cursor = basedatos.rawQuery(consulta, null);


        if( cursor != null || cursor.getCount() <=0)
        {
            cursor.moveToFirst();
            lista_coches = new ArrayList<Coche>(cursor.getCount());

            do
            {
                modelo = cursor.getString(0); //la posicion primera, el id
                coche = new Coche(modelo);
                lista_coches.add(coche);
            }while (cursor.moveToNext());

            cursor.close();
        }

        this.cerrarBaseDatos(basedatos);
        return lista_coches;
    }
    */
}
