package com.ejrm.ejerciciopractico.view.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ejrm.ejerciciopractico.R;
import com.ejrm.ejerciciopractico.data.db.CatalogoAbastecimientoEntity;
import com.ejrm.ejerciciopractico.data.model.AbastecimientoModel;
import com.ejrm.ejerciciopractico.data.model.CatalogoAbastecimiento;

import java.util.List;

public class CatalogoAdapter extends RecyclerView.Adapter<CatalogoAdapter.CatalogoViewHolder> {

    private Context context;
    private List<CatalogoAbastecimientoEntity> List;

    public CatalogoAdapter(Context context, List<CatalogoAbastecimientoEntity> List) {
        this.context = context;
        this.List = List;
    }

    @NonNull
    @Override
    public CatalogoAdapter.CatalogoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CatalogoViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_catalogos, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CatalogoAdapter.CatalogoViewHolder holder, int position) {
        CatalogoAbastecimientoEntity abastecimientoModel = List.get(position);
        holder.papel.setText("Papel " + abastecimientoModel.getPapel() + "\nToalla " + abastecimientoModel.getToallas() + "\nDesorodante " + abastecimientoModel.getDesorodante() + "\nJabon " + abastecimientoModel.getJabon() + "\nAgua " + abastecimientoModel.getAgua());
        //  holder.toalla.setText("T "+abastecimientoModel.getToallas());
        //  holder.desorodante.setText("D "+abastecimientoModel.getDesorodante());
        // holder.jabon.setText("J "+abastecimientoModel.getJabon());
        //holder.agua.setText("A "+abastecimientoModel.getAgua());
        holder.img.setImageBitmap(BitmapFactory.decodeByteArray(abastecimientoModel.getImagen(), 0, abastecimientoModel.getImagen().length));
    }

    public void getAll(List<CatalogoAbastecimientoEntity> List) {
        this.List = List;
    }

    @Override
    public int getItemCount() {
        return List.size();
    }

    public static class CatalogoViewHolder extends RecyclerView.ViewHolder {
        public TextView papel;
        ImageView img;

        public CatalogoViewHolder(@NonNull View itemView) {
            super(itemView);
            papel = itemView.findViewById(R.id.papel);
            img = itemView.findViewById(R.id.imagen);
        }
    }
}
