package com.example.vulcanussoft.carviewfinal.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vulcanussoft.carviewfinal.R;
import com.example.vulcanussoft.carviewfinal.adapter.ContactoAdaptador;
import com.example.vulcanussoft.carviewfinal.pojo.Contacto;

import java.util.ArrayList;


public class RecyclerViewFragment extends Fragment{

    private ArrayList<Contacto> contactos;
    private RecyclerView listaDeContactos;

    public void inicializadorAdaptador(){
        ContactoAdaptador adaptador=new ContactoAdaptador(contactos);
        listaDeContactos.setAdapter(adaptador);
    }
    public void inicializarListaDeContactos(){
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.panda,"Jako","jako@.com","20","4/3/4"));
        contactos.add(new Contacto(R.drawable.animal1,"Toby","Toby@oar.com","14","4/3/4"));
        contactos.add(new Contacto(R.drawable.animal2,"Juno","jako@.com","56","4/3/4"));
        contactos.add(new Contacto(R.drawable.animal3,"Betto","Toby@oar.com","6","4/3/4"));
        contactos.add(new Contacto(R.drawable.animal4,"Fito","jako@.com","5","4/3/4"));
        contactos.add(new Contacto(R.drawable.animal6,"Toby","Toby@oar.com","6","4/3/4"));
        contactos.add(new Contacto(R.drawable.animal7,"Juno","jako@.com","56","4/3/4"));
        contactos.add(new Contacto(R.drawable.animal8,"Betto","Toby@oar.com","14","4/3/4"));
        contactos.add(new Contacto(R.drawable.animal9,"Juno","jako@.com","66","4/3/4"));
        contactos.add(new Contacto(R.drawable.animal10,"Betto","Toby@oar.com","16","4/3/4"));

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v= inflater.inflate(R.layout.fragment_recyclerview, container,false);
        listaDeContactos= v.findViewById(R.id.rvContactos);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaDeContactos.setLayoutManager(llm);


        inicializarListaDeContactos();
        inicializadorAdaptador();


        return v;
    }
}
