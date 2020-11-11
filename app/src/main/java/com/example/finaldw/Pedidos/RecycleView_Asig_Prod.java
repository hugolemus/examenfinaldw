package com.example.finaldw.Pedidos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.finaldw.ConexionSQLiteHelper;
import com.example.finaldw.Marcas.AdapterMarca;
import com.example.finaldw.Productos.AdapterProducto;
import com.example.finaldw.Entidades.Asig_pro;
import com.example.finaldw.utilidades.Utilidades;
import com.example.finaldw.R;

import java.util.ArrayList;

public class RecycleView_Asig_Prod extends AppCompatActivity {

    ArrayList<Asig_pro> listaAsig_Pro;
    RecyclerView recyclerViewAsig_Pro;
    ConexionSQLiteHelper conn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclew_view_asig_pro);
        try{
            conn=new ConexionSQLiteHelper(getApplicationContext(), Utilidades.DB_NAME, null, Utilidades.DB_VERSION);

            listaAsig_Pro = new ArrayList<>();
            recyclerViewAsig_Pro = findViewById(R.id.IdRecyclerAsig_Prod);

            recyclerViewAsig_Pro.setLayoutManager(new LinearLayoutManager(this));

            consultarListaProductos();

            AdapterAsig_Prod adapter = new AdapterAsig_Prod(listaAsig_Pro);
            recyclerViewAsig_Pro.setAdapter(adapter);

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }

    }

    private void consultarListaProductos(){
        SQLiteDatabase db=conn.getReadableDatabase();
        Asig_pro asig_pro = null;
        Cursor cursor=db.rawQuery("Select * from " +Utilidades.TABLA_ASIG_PRO, null);
        while (cursor.moveToNext()){
            asig_pro = new Asig_pro();
            asig_pro.setId_asig_pro(cursor.getInt(0));
            asig_pro.setCliente(cursor.getString(1));
            asig_pro.setDireccion(cursor.getString(2));
            asig_pro.setRepartidor(cursor.getString(3));
            asig_pro.setId_producto(cursor.getInt(4));
            asig_pro.setId_marca(cursor.getInt(5));

            listaAsig_Pro.add(asig_pro);
        }

    }

}