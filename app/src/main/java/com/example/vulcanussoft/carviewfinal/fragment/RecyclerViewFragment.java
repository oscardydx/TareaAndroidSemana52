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
import com.example.vulcanussoft.carviewfinal.adapter.MascotaAdaptador;
import com.example.vulcanussoft.carviewfinal.pojo.Mascota;
import com.example.vulcanussoft.carviewfinal.presentador.IRecyclerViewFragmentPresenter;
import com.example.vulcanussoft.carviewfinal.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;


public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{

    private RecyclerView listaDeContactos;
    private IRecyclerViewFragmentPresenter presenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v= inflater.inflate(R.layout.fragment_recyclerview, container,false);
        listaDeContactos= v.findViewById(R.id.rvContactos);

        presenter= new RecyclerViewFragmentPresenter(this, getContext());

        return v;
    }

    @Override
    public void GenerarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaDeContactos.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador=new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRecyclerView(MascotaAdaptador adaptador) {
        listaDeContactos.setAdapter(adaptador);
    }
}
