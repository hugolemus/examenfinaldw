package com.example.finaldw.Productos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.finaldw.R;
import com.example.finaldw.Entidades.Producto;
import java.util.ArrayList;

public class AdapterProducto extends RecyclerView.Adapter<AdapterProducto.ViewHolderDatos> {
    ArrayList<Producto> listProducto;

    public AdapterProducto(ArrayList<Producto> listProducto){this.listProducto = listProducto;}

    @NonNull
    @Override
    public AdapterProducto.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adapter_producto, null, false);
            return new AdapterProducto.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProducto.ViewHolderDatos holder, int position) {
        holder.id_producto.setText(listProducto.get(position).getId_producto().toString());
        holder.nombre.setText(listProducto.get(position).getNombre().toString());
        holder.proveedor.setText(listProducto.get(position).getProveedor().toString());
        holder.stock.setText(listProducto.get(position).getStock().toString());
    }

    @Override
    public int getItemCount() {
        return listProducto.size();
    }


    public class ViewHolderDatos extends RecyclerView.ViewHolder{
        TextView id_producto, nombre, proveedor, stock;
        public ViewHolderDatos(@NonNull View itemView){
            super(itemView);
            id_producto= itemView.findViewById(R.id.txtid_producto);
            nombre = itemView.findViewById(R.id.txtnombre);
            proveedor = itemView.findViewById(R.id.txtproveedor);
            stock = itemView.findViewById(R.id.txtstock);
        }
    }
}