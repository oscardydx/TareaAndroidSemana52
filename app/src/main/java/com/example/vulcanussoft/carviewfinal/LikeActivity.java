package com.example.vulcanussoft.carviewfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class LikeActivity extends AppCompatActivity {

    private ArrayList<Contacto> favoritePets;
    private RecyclerView petList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        petList= findViewById(R.id.rvPets);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        petList.setLayoutManager(llm);
        inicializarListaDeContactos();
        inicializadorAdaptador();

    }
    public void inicializadorAdaptador(){
        ContactoAdaptador adaptador=new ContactoAdaptador(favoritePets);
        petList.setAdapter(adaptador);
    }
    public void inicializarListaDeContactos(){
        favoritePets = new ArrayList<Contacto>();

        favoritePets.add(new Contacto(R.drawable.animal1,"Jako","jako@.com","5666666","4/3/4"));
        favoritePets.add(new Contacto(R.drawable.animal2,"Toby","Toby@oar.com","1455666","4/3/4"));
        favoritePets.add(new Contacto(R.drawable.animal3,"Juno","jako@.com","5666666","4/3/4"));
        favoritePets.add(new Contacto(R.drawable.animal4,"Betto","Toby@oar.com","1455666","4/3/4"));
        favoritePets.add(new Contacto(R.drawable.animal5,"Jako","jako@.com","5666666","4/3/4"));

    }

}
