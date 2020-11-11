package com.example.finaldw.Marcas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;
import com.example.finaldw.ConexionSQLiteHelper;
import com.example.finaldw.Entidades.Marca;
import com.example.finaldw.utilidades.Utilidades;

import com.example.finaldw.R;
import java.util.ArrayList;

public class Recycle_view_marca extends AppCompatActivity {
    ArrayList<Marca> listaMarca;
    RecyclerView recyclerViewMarca;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclew_view_marca);
        try {
            conn=new ConexionSQLiteHelper(getApplicationContext(), Utilidades.DB_NAME, null, Utilidades.DB_VERSION);

            listaMarca = new ArrayList<>();
            recyclerViewMarca = findViewById(R.id.IdRecyclerMarca);
            recyclerViewMarca.setLayoutManager(new LinearLayoutManager(this));
            consultarListaProductos();

            AdapterMarca adapter = new AdapterMarca(listaMarca);
            recyclerViewMarca.setAdapter(adapter);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
    }
    private void consultarListaProductos(){
        SQLiteDatabase db=conn.getReadableDatabase();
        Marca marca=null;
        Cursor cursor=db.rawQuery("Select * from " +Utilidades.TABLA_MARCA, null);

        while(cursor.moveToNext()){
            marca = new Marca();
            marca.setId_marca(cursor.getInt(0));
            marca.setMarca(cursor.getString(1));

            listaMarca.add(marca);
        }

    }
}