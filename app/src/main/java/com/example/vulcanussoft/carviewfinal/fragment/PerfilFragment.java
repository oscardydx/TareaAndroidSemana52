package com.example.vulcanussoft.carviewfinal.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vulcanussoft.carviewfinal.R;
import com.example.vulcanussoft.carviewfinal.adapter.MascotaAdaptador;
import com.example.vulcanussoft.carviewfinal.pojo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {


    public PerfilFragment() {
        // Required empty public constructor
    }

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaDeFotos;

    public void inicializadorAdaptador(){
        MascotaAdaptador adaptador=new MascotaAdaptador(mascotas, getActivity());
        listaDeFotos.setAdapter(adaptador);
    }
    public void inicializarListaDeContactos(){
        mascotas = new ArrayList<Mascota>();


        mascotas.add(new Mascota(R.drawable.animal4,"Fito","jako@.com",10,"4/3/4"));
        mascotas.add(new Mascota(R.drawable.animal4,"Fito","jako@.com",15,"4/3/4"));
        mascotas.add(new Mascota(R.drawable.animal4,"Fito","jako@.com",5,"4/3/4"));
        mascotas.add(new Mascota(R.drawable.animal4,"Fito","jako@.com",51,"4/3/4"));



    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_perfil, container, false);
        View v= inflater.inflate(R.layout.fragment_perfil, container,false);
        listaDeFotos= v.findViewById(R.id.rvFotos);

        /*
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);*/



        GridLayoutManager llm = new GridLayoutManager(getActivity(),2);


        listaDeFotos.setLayoutManager(llm);


        inicializarListaDeContactos();
        inicializadorAdaptador();


        return v;
    }







}
