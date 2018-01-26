package com.example.vulcanussoft.carviewfinal.db;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.example.vulcanussoft.carviewfinal.R;
import com.example.vulcanussoft.carviewfinal.pojo.Mascota;

import java.util.ArrayList;
import java.io.IOException;

/**
 * Created by Vulcanus Soft on 23/01/2018.
 */

public class ConstructorMascotas {

    private static final int LIKE =1  ;
    private Context context ;

    public ConstructorMascotas(Context context){
        this.context=context;
    }
    public ArrayList<Mascota> obtenerDatos(){


        BaseDatos Database=new BaseDatos(context);
        insertarMascotas(Database);
        return Database.obtenerTodasLasMascotas();

/*      ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.panda,"Jako","jako@.com","20","4/3/4"));
        mascotas.add(new Mascota(R.drawable.animal1,"Toby","Toby@oar.com","14","4/3/4"));
        mascotas.add(new Mascota(R.drawable.animal2,"Juno","jako@.com","56","4/3/4"));
        mascotas.add(new Mascota(R.drawable.animal3,"Betto","Toby@oar.com","6","4/3/4"));
        mascotas.add(new Mascota(R.drawable.animal4,"Fito","jako@.com","5","4/3/4"));
        mascotas.add(new Mascota(R.drawable.animal6,"Toby","Toby@oar.com","6","4/3/4"));
        mascotas.add(new Mascota(R.drawable.animal7,"Juno","jako@.com","56","4/3/4"));
        mascotas.add(new Mascota(R.drawable.animal8,"Betto","Toby@oar.com","14","4/3/4"));
        mascotas.add(new Mascota(R.drawable.animal9,"Juno","jako@.com","66","4/3/4"));
        mascotas.add(new Mascota(R.drawable.animal10,"Betto","Toby@oar.com","16","4/3/4"));*/


    }

    public  void insertarMascotas(BaseDatos bd){
        ContentValues contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Floki");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_EMAIL,"Floki@fg.com");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FECHA,"5/8/5");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.animal1);

        bd.insertarMascota(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Toby");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_EMAIL,"Floki@fg.com");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FECHA,"5/8/5");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.animal2);

        bd.insertarMascota(contentValues);

         contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Juno");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_EMAIL,"Floki@fg.com");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FECHA,"5/8/5");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.animal3);

        bd.insertarMascota(contentValues);

         contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Betto");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_EMAIL,"Floki@fg.com");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FECHA,"5/8/5");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.animal4);

        bd.insertarMascota(contentValues);

         contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Fito");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_EMAIL,"Floki@fg.com");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FECHA,"5/8/5");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.animal5);

        bd.insertarMascota(contentValues);

    }

    public void darLikeMascota(Mascota mascota){

        BaseDatos bd=new BaseDatos(context);
        ContentValues contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_NUMERO, LIKE);

        bd.insertarLikeMascota(contentValues);


    }

    public int obtenerLikesMascota(Mascota mascota){

        BaseDatos bd=new BaseDatos(context);
        return bd.obtenerLikesMascota(mascota);


    }

}
