package com.example.recycleview.adaptador;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recycleview.R;

import com.example.recycleview.model.Persona;

import java.util.List;

public class AdaptadorPersona extends RecyclerView.Adapter<AdaptadorPersona.ViewHolder>{

    List<Persona> lp;

    Integer pos;

    public  AdaptadorPersona(List<Persona> lp){//Devuelve un viewholder(un renglon)
        this.lp = lp;
    }

    @NonNull
    @Override
    public AdaptadorPersona.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemrcd, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewholder, final int i) {//objeto, elemento
        Persona p = lp.get(i);
        pos = i;
       viewholder.txtNombre.setText(lp.get(i).getNombre());
       viewholder.txtApellido.setText(lp.get(i).getApellido());
       viewholder.txtEdad.setText(lp.get(i).getEdad().toString());
       viewholder.txtTelefono.setText(lp.get(i).getTelefono());

      /* viewholder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent int1 = new Intent(Intent.ACTION_CALL);
               int1.setData(Uri.parse(lp.get(pos).getTelefono()));
               v.getContext().startActivity(int1);
           }
       });*/

      viewholder.itemView.setOnClickListener(Persona.llamar(p));

    }

    @Override
    public int getItemCount() {
        return lp.size();
    }

    public  class  ViewHolder extends  RecyclerView.ViewHolder{ //renglon

        TextView txtNombre, txtApellido, txtEdad, txtTelefono;

        public ViewHolder(View itemView)
        {
            super(itemView);//super, las caracteristicas del padre

            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtApellido = itemView.findViewById(R.id.txtApellido);
            txtEdad = itemView.findViewById(R.id.txtEdad);
            txtTelefono = itemView.findViewById(R.id.txtTelefono);

        }
    }
}
