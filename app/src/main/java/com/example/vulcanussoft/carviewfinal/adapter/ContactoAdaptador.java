package com.example.vulcanussoft.carviewfinal.adapter;


import android.app.Activity;
//import android.support.design.widget.Snackbar;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
//import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vulcanussoft.carviewfinal.pojo.Contacto;
import com.example.vulcanussoft.carviewfinal.R;

import java.util.ArrayList;


public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{
     ArrayList<Contacto> contactos;
     Activity activity;

     public ContactoAdaptador(ArrayList<Contacto> contactos){
        this.contactos=contactos;
        this.activity=activity;
    }


    //inflar layout y lo pasara al viewholder para que obtenga los views
    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_view_contact,parent,false);
        return new ContactoViewHolder(v);
    }
    //asocia cada elemento de la lista a cada view
    @Override
    public void onBindViewHolder(final ContactoViewHolder contactoViewHolder, int position) {
        final Contacto contacto=contactos.get(position);

        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
        contactoViewHolder.tvLikeCV.setText(contacto.getLike());



        contactoViewHolder.btnLik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view,"Diste Like a:",Snackbar.LENGTH_SHORT)
                        .setAction(contacto.getNombre(), new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //Log.i("SnackBAR","Click en SnackBar");
                            }
                        }).show();

                int rating;
                rating = Integer.parseInt((String) contactoViewHolder.tvLikeCV.getText());
                ++rating;
                contactoViewHolder.tvLikeCV.setText(Integer.toString(rating));

            }
        });
    }

    @Override
    public int getItemCount() { //cantidad de elementos que contiene la lista
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvLikeCV;
        private ImageButton btnLik;

        public ContactoViewHolder(View itemView) {
            super(itemView);

            imgFoto= (ImageView) itemView.findViewById(R.id.imag1);
            tvNombreCV=(TextView) itemView.findViewById(R.id.text1);
            tvLikeCV=(TextView) itemView.findViewById(R.id.text2);
            btnLik=(ImageButton) itemView.findViewById(R.id.bntLike);

        }
    }
}