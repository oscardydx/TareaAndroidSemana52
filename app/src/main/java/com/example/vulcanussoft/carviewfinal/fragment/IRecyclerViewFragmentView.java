package com.example.vulcanussoft.carviewfinal.fragment;

import com.example.vulcanussoft.carviewfinal.adapter.MascotaAdaptador;
import com.example.vulcanussoft.carviewfinal.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Vulcanus Soft on 23/01/2018.
 */

public interface IRecyclerViewFragmentView {

    public void GenerarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador (ArrayList<Mascota> mascotas);
    public  void inicializarAdaptadorRecyclerView(MascotaAdaptador adaptador);
}

