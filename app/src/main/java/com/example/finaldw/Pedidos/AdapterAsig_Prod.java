package com.example.finaldw.Pedidos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Bundle;
import com.example.finaldw.Entidades.Asig_pro;
import java.util.ArrayList;
import com.example.finaldw.R;

public class AdapterAsig_Prod extends RecyclerView.Adapter<AdapterAsig_Prod.ViewHolderDatos> {

    ArrayList<Asig_pro> listAsig_Prod;

    public AdapterAsig_Prod(ArrayList<Asig_pro> listAsig_Prod){
        this.listAsig_Prod= listAsig_Prod;
    }

    @NonNull
    @Override
    public AdapterAsig_Prod.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adapter_asig_pro, null, false);
        return  new AdapterAsig_Prod.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAsig_Prod.ViewHolderDatos holder, int position) {
        holder.id_asig_pro.setText(listAsig_Prod.get(position).getId_asig_pro().toString());
        holder.Cliente.setText(listAsig_Prod.get(position).getCliente().toString());
        holder.Direccion.setText(listAsig_Prod.get(position).getDireccion().toString());
        holder.Repartidor.setText(listAsig_Prod.get(position).getRepartidor().toString());
        holder.id_prod.setText(listAsig_Prod.get(position).getId_producto().toString());
        holder.id_marc.setText(listAsig_Prod.get(position).getId_marca().toString());
    }

    @Override
    public int getItemCount() {
        return listAsig_Prod.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder{
        TextView id_asig_pro, Repartidor, Cliente, Direccion, id_prod, id_marc;

        public ViewHolderDatos(@NonNull View itemView){
            super(itemView);
            id_asig_pro = itemView.findViewById(R.id.txtID_Asig_Alum);
            Cliente = itemView.findViewById(R.id.txtCliente);
            Direccion = itemView.findViewById(R.id.txtDireccion);
            Repartidor = itemView.findViewById(R.id.txtRepartidor);
            id_prod = itemView.findViewById(R.id.txtID_ALUMNO);
            id_marc = itemView.findViewById(R.id.txtID_CURSO);

        }
    }

}