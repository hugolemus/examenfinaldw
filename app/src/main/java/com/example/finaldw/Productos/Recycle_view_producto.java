package com.example.finaldw.Productos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import com.example.finaldw.ConexionSQLiteHelper;

import com.example.finaldw.utilidades.Utilidades;
import com.example.finaldw.Entidades.Producto;

import com.example.finaldw.R;


import java.util.ArrayList;
public class Recycle_view_producto extends AppCompatActivity {

    ArrayList<Producto> listaProducto;
    RecyclerView recyclerViewProducto;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclew_view_producto);

        try{
            conn = new ConexionSQLiteHelper(getApplicationContext(), Utilidades.DB_NAME, null, Utilidades.DB_VERSION);
            listaProducto = new ArrayList<>();
            recyclerViewProducto = findViewById(R.id.IdRecyclerProducto);

            recyclerViewProducto.setLayoutManager(new LinearLayoutManager(this));

            consultarListaProductos();

            AdapterProducto adapter = new AdapterProducto(listaProducto);
            recyclerViewProducto.setAdapter(adapter);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }

    }

    private void consultarListaProductos(){
        SQLiteDatabase db= conn.getReadableDatabase();
        Producto producto = null;
        Cursor cursor=db.rawQuery("Select * from " +Utilidades.TABLA_PRODUCTO, null);

        while (cursor.moveToNext()){
            producto = new Producto();
            producto.setId_producto(cursor.getInt(0));
            producto.setNombre(cursor.getString(1));
            producto.setProveedor(cursor.getString(2));
            producto.setStock(cursor.getString(3));

            listaProducto.add(producto);
        }
    }
}