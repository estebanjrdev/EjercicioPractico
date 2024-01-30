package com.ejrm.ejerciciopractico.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ejrm.ejerciciopractico.R;
import com.ejrm.ejerciciopractico.data.model.AbastecimientoModel;

import java.util.List;

public class AbastecimientoAdapter extends RecyclerView.Adapter<AbastecimientoAdapter.AbastecimientoViewHolder> {

    private Context context;
    private List<AbastecimientoModel> List;

    public AbastecimientoAdapter(Context context, List<AbastecimientoModel> List) {
        this.context =  context;
        this.List = List;
    }
    @NonNull
    @Override
    public AbastecimientoAdapter.AbastecimientoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AbastecimientoViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AbastecimientoAdapter.AbastecimientoViewHolder holder, int position) {
        AbastecimientoModel abastecimientoModel=List.get(position);
        holder.id.setText("Id "+abastecimientoModel.getIdAbastecimiento());
        holder.tipo.setText("Tipo "+abastecimientoModel.getTipoAbastecimiento());
        holder.usuario.setText("Usuario "+abastecimientoModel.getUsuarioCreacion());
        holder.fecha.setText("Fecha "+abastecimientoModel.getFechaCreacion());
    }

    public void getAll(List<AbastecimientoModel> List)
    {
        this.List=List;
    }
    @Override
    public int getItemCount() {
        return List.size();
    }
    public static class AbastecimientoViewHolder extends RecyclerView.ViewHolder{
        public TextView id,tipo,usuario,fecha;
        public AbastecimientoViewHolder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.id);
            tipo=itemView.findViewById(R.id.tipo);
            usuario=itemView.findViewById(R.id.usuario);
            fecha=itemView.findViewById(R.id.fecha);
        }
    }
}
