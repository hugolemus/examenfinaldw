package com.example.finaldw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.finaldw.Marcas.Marca;
import com.example.finaldw.Pedidos.Pedido;
import com.example.finaldw.Productos.Producto;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConexionSQLiteHelper conn= new ConexionSQLiteHelper(this, "bd_productos", null, 1);
    }

    public void onClick(View view){

        Intent miIntent= null;

        switch (view.getId()){
            case R.id.img_productos:
                miIntent= new Intent(MainActivity.this, Producto.class);
                break;
            case R.id.img_marcas:
                miIntent= new Intent(MainActivity.this, Marca.class);
                break;
            case R.id.img_pedidos:
                miIntent= new Intent(MainActivity.this, Pedido.class);
                break;


        }startActivity(miIntent);
    }
}