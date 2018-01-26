package com.example.vulcanussoft.carviewfinal.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.vulcanussoft.carviewfinal.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Vulcanus Soft on 23/01/2018.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private  Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryCrearTablaMascotas="CREATE TABLE "+ConstantesBaseDatos.TABLE_MASCOTAS+"("+
                ConstantesBaseDatos.TABLE_MASCOTAS_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE+" TEXT, "+
                ConstantesBaseDatos.TABLE_MASCOTAS_EMAIL+" TEXT, "+
                ConstantesBaseDatos.TABLE_MASCOTAS_FECHA+" TEXT, "+
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTO+" INTEGER "
                +")";

        String queryCrearTablaLikes="CREATE TABLE "+ConstantesBaseDatos.TABLE_LIKES+"("+
                ConstantesBaseDatos.TABLE_LIKES_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA+" INTEGER, "+
                ConstantesBaseDatos.TABLE_LIKES_NUMERO+" INTEGER, "+
                "FOREIGN KEY ("+ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA+") "+
                "REFERENCES "+ConstantesBaseDatos.TABLE_MASCOTAS+"("+ConstantesBaseDatos.TABLE_MASCOTAS_ID+")"
                +")";


        sqLiteDatabase.execSQL(queryCrearTablaMascotas);
        sqLiteDatabase.execSQL(queryCrearTablaLikes);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ConstantesBaseDatos.TABLE_LIKES);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ConstantesBaseDatos.TABLE_MASCOTAS);

        onCreate(sqLiteDatabase);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){

        ArrayList<Mascota> mascotas= new ArrayList<>();

        String query="SELECT * FROM "+ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor registros= db.rawQuery(query, null);

        while(registros.moveToNext()){
            Mascota masccotaActual= new Mascota();
            masccotaActual.setId(registros.getInt(0));
            masccotaActual.setNombre(registros.getString(1));
            masccotaActual.setEmail(registros.getString(2));
            masccotaActual.setFecha(registros.getString(3));
            masccotaActual.setFoto(registros.getInt(4));

            String queryLikes="SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_NUMERO+") as likes "+
                    " FROM "+ConstantesBaseDatos.TABLE_LIKES+" WHERE "+ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA+
                    "="+masccotaActual.getId();

            Cursor registrosLikes=db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                masccotaActual.setLike(registrosLikes.getInt(0));

            }else{
                masccotaActual.setLike(0);
            }


            mascotas.add(masccotaActual);
        }
        db.close();

        return mascotas ;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS,null,contentValues);
        db.close();

    }

    public void insertarLikeMascota(ContentValues contentValues){


        try {SQLiteDatabase db = this.getWritableDatabase();
            db.insert(ConstantesBaseDatos.TABLE_LIKES, null, contentValues);
            db.close();
        } catch (NullPointerException e) {Log.i("SnackBAR", e.getMessage());

           }


    }

    public  int obtenerLikesMascota(Mascota mascota){

        int likes =0;
        String query="SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_NUMERO+")"+" FROM "
                +ConstantesBaseDatos.TABLE_LIKES+" WHERE "+ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA+"="+mascota.getId();

        SQLiteDatabase bd=this.getWritableDatabase();
        Cursor registros=bd.rawQuery(query,null);

        while(registros.moveToNext()){
            likes=registros.getInt(0);

        }
        bd.close();
        return likes;

    }
}
