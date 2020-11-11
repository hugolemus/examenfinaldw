package com.example.finaldw.Marcas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.finaldw.Entidades.Marca;
import com.example.finaldw.R;

import java.util.ArrayList;

public class AdapterMarca extends RecyclerView.Adapter<AdapterMarca.ViewHolderDatos> {

    ArrayList<Marca> listMarca;

    public AdapterMarca(ArrayList<Marca> listMarca){this.listMarca = listMarca;}

    @NonNull
    @Override
    public AdapterMarca.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adapter_marca, null, false);
        return new AdapterMarca.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMarca.ViewHolderDatos holder, int position) {
        holder.Id_Marca.setText(listMarca.get(position).getId_marca().toString());
        holder.Marca.setText(listMarca.get(position).getMarca().toString());
    }

    @Override
    public int getItemCount() {
        return listMarca.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder{
        TextView Id_Marca, Marca;

        public ViewHolderDatos(@NonNull View itemView){
            super(itemView);
            Id_Marca = itemView.findViewById(R.id.txtID_Marca);
            Marca = itemView.findViewById(R.id.txtMarca);
        }
    }

}