package com.example.finaldw.Productos;

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
import com.example.finaldw.R;
import com.example.finaldw.utilidades.Utilidades;

public class Producto extends AppCompatActivity {

    EditText edtIdProducto, edtNombre, edtProveedor, edtStock;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        edtIdProducto=(EditText) findViewById(R.id.edtIdProducto);
        edtNombre=(EditText) findViewById(R.id.edtNombre);
        edtProveedor=(EditText) findViewById(R.id.edtProveedor);
        edtStock=(EditText) findViewById(R.id.edtStock);

        conn = new ConexionSQLiteHelper(getApplicationContext(), Utilidades.DB_NAME, null, Utilidades.DB_VERSION);
    }

    public void OnClick(View view){ registrarProductos();}

    private void limpiar() {
        edtIdProducto.setText("");
        edtNombre.setText("");
        edtProveedor.setText("");
        edtStock.setText("");

    }


    //METODO PARA REGISTRAR//
    private void registrarProductos() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_productos", null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Utilidades.CAMPO_NOMBRE, edtNombre.getText().toString());
        values.put(Utilidades.CAMPO_PROVEEDOR, edtProveedor.getText().toString());
        values.put(Utilidades.CAMPO_STOCK, edtStock.getText().toString());

        Long idResultante = db.insert(Utilidades.TABLA_PRODUCTO, Utilidades.CAMPO_IDP, values);

        Toast.makeText(getApplicationContext(), "Codigo Producto: " + idResultante, Toast.LENGTH_SHORT).show();
        db.close();
        edtNombre.setText("");
        edtProveedor.setText("");
        edtStock.setText("");
    }

//METODO BUSCAR PRODUCTOS//
    public void Buscar(View view){
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_productos", null, 1);
        SQLiteDatabase db= conn.getReadableDatabase();
        String[] parametros={edtIdProducto.getText().toString()};
        try{
            Cursor cursor=db.rawQuery("SELECT "+Utilidades.CAMPO_NOMBRE+"," + Utilidades.CAMPO_PROVEEDOR+ "," + Utilidades.CAMPO_STOCK+
                    " FROM "+Utilidades.TABLA_PRODUCTO+" WHERE "+Utilidades.CAMPO_IDP+"=? ", parametros);

            cursor.moveToFirst();
            edtNombre.setText(cursor.getString(0));
            edtProveedor.setText(cursor.getString(1));
            edtStock.setText(cursor.getString(2));
            Toast.makeText(getApplicationContext(), "Producto Encontrado", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Producto no Existe en el Registro", Toast.LENGTH_LONG).show();
            limpiar();
        }
    }
//METODO EDITAR PRODUCTOS//
    public void Modificar(View view){
    SQLiteDatabase db=conn.getWritableDatabase();
    String[] parametros={edtIdProducto.getText().toString()};
    ContentValues values=new ContentValues();

    values.put(Utilidades.CAMPO_NOMBRE, edtNombre.getText().toString());
    values.put(Utilidades.CAMPO_PROVEEDOR, edtProveedor.getText().toString());
    values.put(Utilidades.CAMPO_STOCK, edtStock.getText().toString());

    db.update(Utilidades.TABLA_PRODUCTO,values,Utilidades.CAMPO_IDP+"=?",parametros);
    Toast.makeText(getApplicationContext(), "Se ha editado el registro correctamente", Toast.LENGTH_LONG).show();
    db.close();

    }

//METODO ELIMINAR PRODUCTO//
public void Eliminar(View view){
    SQLiteDatabase db=conn.getWritableDatabase();
    String[] parametros={edtIdProducto.getText().toString()};

    db.delete(Utilidades.TABLA_PRODUCTO, Utilidades.CAMPO_IDP+"=?",parametros);
    Toast.makeText(getApplicationContext(),"Se Elimino el Registro Correctamente", Toast.LENGTH_LONG).show();
    edtIdProducto.setText("");
    limpiar();
    db.close();
}

    //METODO PARA MOSTRAR//
    public void Lista(View view) {
        Intent lista = new Intent(this, Recycle_view_producto.class);
        startActivity(lista);
    }
}