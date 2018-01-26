package com.example.vulcanussoft.carviewfinal.presentador;

import android.content.Context;

import com.example.vulcanussoft.carviewfinal.db.ConstructorMascotas;
import com.example.vulcanussoft.carviewfinal.fragment.IRecyclerViewFragmentView;
import com.example.vulcanussoft.carviewfinal.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Vulcanus Soft on 23/01/2018.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    public IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView=iRecyclerViewFragmentView;
        this.context=context;
        obtenerMascotasBaseDeDatos();
    }
    @Override
    public void obtenerMascotasBaseDeDatos() {
        constructorMascotas= new ConstructorMascotas(context);
        mascotas =constructorMascotas.obtenerDatos();
        mostarMascotasRV();
    }

    @Override
    public void mostarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRecyclerView(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.GenerarLinearLayoutVertical();
    }
}
