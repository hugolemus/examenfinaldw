package com.example.finaldw.Marcas;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finaldw.ConexionSQLiteHelper;
import com.example.finaldw.utilidades.Utilidades;

import com.example.finaldw.R;

public class Marca extends AppCompatActivity {

    EditText edtIdMarca, edtMarca;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marca);

        edtIdMarca=(EditText) findViewById(R.id.edtIdMarca) ;
        edtMarca = (EditText) findViewById(R.id.edtMarca);

        conn= new ConexionSQLiteHelper(getApplicationContext(), Utilidades.DB_NAME, null, Utilidades.DB_VERSION);
    }

    public void onClick(View view){
        registrarMarcas();
    }

    private void limpiar() {
        edtMarca.setText("");
    }

    // Método para registrar
    public void registrarMarcas(){

        SQLiteDatabase db=conn.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_MARCA, edtMarca.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_MARCA,Utilidades.CAMPO_IDM,values);

        Toast.makeText(getApplicationContext(),"Registro Marca No.: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();
        edtMarca.setText("");

    }

    //METODO BUSCAR//
    public void Buscar(View view){
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={edtIdMarca.getText().toString()};

        try{
            Cursor cursor=db.rawQuery("SELECT "+Utilidades.CAMPO_MARCA+
                    " FROM "+Utilidades.TABLA_MARCA+" WHERE "+Utilidades.CAMPO_IDM+"=?",parametros);

            cursor.moveToFirst();
            edtMarca.setText(cursor.getString(0));
        }catch (Exception e) {
            Toast.makeText(getApplicationContext(),"El registro no existe",Toast.LENGTH_LONG).show();
            limpiar();
        }
    }

    //METODO EDITAR//
    public void Editar(View view){
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={edtIdMarca.getText().toString()};
        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_MARCA, edtMarca.getText().toString());

        db.update(Utilidades.TABLA_MARCA,values, Utilidades.CAMPO_IDM+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Se Edito el Registro Correctamente",Toast.LENGTH_LONG).show();
        db.close();
    }

    //METODO ELIMINAR//
    public void Eliminar(View view){
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={edtIdMarca.getText().toString()};

        db.delete(Utilidades.TABLA_MARCA, Utilidades.CAMPO_IDM+"=?",parametros);
        Toast.makeText(getApplicationContext(), "Registro Eliminado Correctamente", Toast.LENGTH_LONG).show();
        edtIdMarca.setText("");
        limpiar();
        db.close();
    }

    public void Lista(View view){
        Intent lista = new Intent(this, Recycle_view_marca.class);
        startActivity(lista);
    }



}