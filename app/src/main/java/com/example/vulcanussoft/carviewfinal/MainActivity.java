package com.example.vulcanussoft.carviewfinal;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contacto> contactos;
    private RecyclerView listaDeContactos;

    //Toolbar actionbare=(Toolbar) findViewById(R.id.Bar);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaDeContactos= findViewById(R.id.rvContactos);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaDeContactos.setLayoutManager(llm);
        inicializarListaDeContactos();
        inicializadorAdaptador();

        Fab();
    }

    public void inicializadorAdaptador(){
        ContactoAdaptador adaptador=new ContactoAdaptador(contactos);
        listaDeContactos.setAdapter(adaptador);
    }
    public void inicializarListaDeContactos(){
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.animal1,"Jako","jako@.com","5666666","4/3/4"));
        contactos.add(new Contacto(R.drawable.animal2,"Toby","Toby@oar.com","1455666","4/3/4"));
        contactos.add(new Contacto(R.drawable.animal3,"Juno","jako@.com","5666666","4/3/4"));
        contactos.add(new Contacto(R.drawable.animal4,"Betto","Toby@oar.com","1455666","4/3/4"));
        contactos.add(new Contacto(R.drawable.animal5,"Jako","jako@.com","5666666","4/3/4"));
        contactos.add(new Contacto(R.drawable.animal6,"Toby","Toby@oar.com","1455666","4/3/4"));
        contactos.add(new Contacto(R.drawable.animal7,"Juno","jako@.com","5666666","4/3/4"));
        contactos.add(new Contacto(R.drawable.animal8,"Betto","Toby@oar.com","1455666","4/3/4"));
        contactos.add(new Contacto(R.drawable.animal9,"Juno","jako@.com","5666666","4/3/4"));
        contactos.add(new Contacto(R.drawable.animal10,"Betto","Toby@oar.com","1455666","4/3/4"));

    }

    private void Fab() {
        FloatingActionButton miFab= findViewById(R.id.floatButton);
        miFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(getBaseContext(),getString(R.string.app_name), Toast.LENGTH_SHORT).show();
            /*    Snackbar.make(view,getResources().getString(R.string.app_name),Snackbar.LENGTH_SHORT)
                                .setAction(getResources().getString(R.string.mensaje), new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.i("SnackBAR","Click en SnackBar");
                            }
                        }).setActionTextColor(getResources().getColor(R.color.colorPrimary)).show();
         */
                Intent intent= new Intent(MainActivity.this,LikeActivity.class);
                startActivity(intent);

            }
        }


        );
    }
}




