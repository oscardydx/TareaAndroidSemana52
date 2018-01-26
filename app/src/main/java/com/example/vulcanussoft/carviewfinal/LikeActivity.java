package com.example.vulcanussoft.carviewfinal;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.vulcanussoft.carviewfinal.adapter.MascotaAdaptador;
import com.example.vulcanussoft.carviewfinal.fragment.IRecyclerViewFragmentView;
import com.example.vulcanussoft.carviewfinal.pojo.Mascota;

import java.util.ArrayList;

public class LikeActivity extends AppCompatActivity {

    private ArrayList<Mascota> favoritePets;
    private RecyclerView petList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like);


       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        petList= findViewById(R.id.rvPets);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        petList.setLayoutManager(llm);
        inicializarListaDeContactos();
        inicializadorAdaptador();

    }

    public void inicializadorAdaptador(){
        MascotaAdaptador adaptador=new MascotaAdaptador(favoritePets, null);
        petList.setAdapter(adaptador);
    }
    public void inicializarListaDeContactos(){
        favoritePets = new ArrayList<Mascota>();

        favoritePets.add(new Mascota(R.drawable.panda,"Jako","jako@.com",40,"4/3/4"));
        favoritePets.add(new Mascota(R.drawable.animal1,"Toby","Toby@oar.com",35,"4/3/4"));
        favoritePets.add(new Mascota(R.drawable.animal2,"Juno","jako@.com",10,"4/3/4"));
        favoritePets.add(new Mascota(R.drawable.animal3,"Betto","Toby@oar.com",50,"4/3/4"));
        favoritePets.add(new Mascota(R.drawable.animal4,"fito","jako@.com",10,"4/3/4"));

    }

}
