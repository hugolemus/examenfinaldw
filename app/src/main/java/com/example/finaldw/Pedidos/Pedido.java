package com.example.finaldw.Pedidos;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.finaldw.Entidades.Marca;
import com.example.finaldw.Entidades.Producto;
import com.example.finaldw.ConexionSQLiteHelper;
import com.example.finaldw.utilidades.Utilidades;

import java.util.ArrayList;
import com.example.finaldw.R;

public class Pedido extends AppCompatActivity {
    EditText et_id_asig_alum, edtRepartidor, edtCliente, edtDireccion, txtID_ALUMNO, txtID_CURSO, txtID_GRADO, txtID_SECCION;
    Spinner marca, producto;

    ArrayList<String> listaProducto, listaMarca;

    ArrayList<Producto> ProductoList;
    ArrayList<Marca> MarcaList;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        edtCliente = (EditText) findViewById(R.id.edtCliente);
        edtDireccion = (EditText) findViewById(R.id.edtDireccion);
        edtRepartidor = (EditText) findViewById(R.id.edtRepartidor);
        et_id_asig_alum = (EditText) findViewById(R.id.txtID_Asig_Alum);
        producto = (Spinner) findViewById(R.id.txtID_ALUMNO);
        marca = (Spinner) findViewById(R.id.txtID_CURSO);
        conn=new ConexionSQLiteHelper(getApplicationContext(), Utilidades.DB_NAME, null, Utilidades.DB_VERSION);

        consultarListaProducto();
        consultarListaMarca();

        ArrayAdapter<CharSequence> adaptado=new ArrayAdapter
                (this,android.R.layout.simple_spinner_item, listaProducto);
        producto.setAdapter(adaptado);

        ArrayAdapter<CharSequence> adaptador= new ArrayAdapter
                (this, android.R.layout.simple_spinner_item, listaMarca);
        marca.setAdapter(adaptador);

        producto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long idl) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        marca.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long idl) {

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    private void registrarMascota(){

        SQLiteDatabase db=conn.getWritableDatabase();

        if (!et_id_asig_alum.getText().toString().isEmpty()) {
            ContentValues values = new ContentValues();

            int idCombo1 = (int) producto.getSelectedItemId();
            int idCombo2 = (int) marca.getSelectedItemId();

            if (idCombo1 != 0) {
                Log.i("TAMAÑO", ProductoList.size() + "");
                Log.i("id combo", idCombo1 + "");
                Log.i("id combo -1", (idCombo1 - 1) + "");
                int id_prod = ProductoList.get(idCombo1 - 1).getId_producto();
                Log.i("ID Producto", id_prod + "");

                values.put(Utilidades.CAMPO_ID_PROD, id_prod);

                Log.i("TAMAÑO", MarcaList.size() + "");
                Log.i("id combo", idCombo2 + "");
                Log.i("id combo -1", (idCombo2 - 1) + "");
                int id_marc = MarcaList.get(idCombo2 - 1).getId_marca();
                Log.i("ID marca", id_marc + "");

                values.put(Utilidades.CAMPO_ID_MARC, id_marc);

                values.put(Utilidades.CAMPO_ID_ASIG_PRO, et_id_asig_alum.getText().toString());
                values.put(Utilidades.CAMPO_CLIE, edtCliente.getText().toString());
                values.put(Utilidades.CAMPO_DIRE, edtDireccion.getText().toString());
                values.put(Utilidades.CAMPO_REPA, edtRepartidor.getText().toString());
                Long idResultante = db.insert(Utilidades.TABLA_ASIG_PRO, Utilidades.CAMPO_ID_ASIG_PRO, values);
                Toast.makeText(this, "pedido registrado", Toast.LENGTH_LONG).show();
                db.close();
            }
        }
    }

    private void consultarListaProducto(){
        SQLiteDatabase db=conn.getReadableDatabase();
        Producto producto=null;
        ProductoList =new ArrayList<Producto>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_PRODUCTO,null);
        while (cursor.moveToNext()){
            producto =new Producto();
            producto.setId_producto(cursor.getInt(0));
            producto.setProveedor(cursor.getString(1));
            producto.setStock(cursor.getString(2));
            Log.i("Producto",producto.getId_producto().toString());
            Log.i("nombre",producto.getProveedor().toString());
            Log.i("proveedor",producto.getStock().toString());
          ProductoList.add(producto);
        }
        obtenerListaProducto();
    }

    private void obtenerListaProducto() {
        listaProducto = new ArrayList<String>();
        listaProducto.add("Seleccione");
        for (int i = 0; i < ProductoList.size(); i++) {
            listaProducto.add(ProductoList.get(i).getId_producto() + " - " + ProductoList.get(i).getProveedor() + " - " + ProductoList.get(i).getStock());
        }
    }

    private void consultarListaMarca(){
        SQLiteDatabase db=conn.getReadableDatabase();
        Marca marca=null;
       MarcaList =new ArrayList<Marca>();

        Cursor cursor2=db.rawQuery("SELECT * FROM  "+ Utilidades.TABLA_MARCA,null);
        while (cursor2.moveToNext()){
            marca=new Marca();

            marca.setId_marca(cursor2.getInt(0));
            marca.setMarca(cursor2.getString(1));
            Log.i("id Marca",marca.getId_marca().toString());
            Log.i("Curso",marca.getMarca().toString());
            MarcaList.add(marca);
        }
        obtnerListaMarca();
    }

    private void obtnerListaMarca(){
        listaMarca = new ArrayList<String>();
        listaMarca.add("Seleccione");

        for(int i = 0; i< MarcaList.size(); i++){
            listaMarca.add(MarcaList.get(i).getId_marca()+" - "+ MarcaList.get(i).getMarca());
        }
    }


    //MOSTRAR REPORTES
    public void Lista(View view){
        Intent lista = new Intent(this, RecycleView_Asig_Prod.class);
        startActivity(lista);
    }

    //METODO ELIMINAR//
    public void Eliminar(View view){
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={et_id_asig_alum.getText().toString()};

        db.delete(Utilidades.TABLA_ASIG_PRO,Utilidades.CAMPO_ID_ASIG_PRO+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Documento eliminado exitosamente",Toast.LENGTH_LONG).show();
        et_id_asig_alum.setText("");
        limpiar();
        db.close();
    }

    //METODO MODIFICAR//
    public void Modificar(View view){
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={et_id_asig_alum.getText().toString()};

        if (!et_id_asig_alum.getText().toString().isEmpty()) {
            ContentValues values=new ContentValues();

            int idCombo1 = (int) producto.getSelectedItemId();
            int idCombo2 = (int) marca.getSelectedItemId();


            if (idCombo1 != 0) {
                Log.i("TAMAÑO", ProductoList.size() + "");
                Log.i("id combo", idCombo1 + "");
                Log.i("id combo -1", (idCombo1 - 1) + "");
                int id_prod = ProductoList.get(idCombo1 - 1).getId_producto();
                Log.i("ID Producto", id_prod + "");

                values.put(Utilidades.CAMPO_ID_PROD, id_prod);

                Log.i("TAMAÑO", MarcaList.size() + "");
                Log.i("id combo", idCombo2 + "");
                Log.i("id combo -1", (idCombo2 - 1) + "");
                int id_marc = MarcaList.get(idCombo2 - 1).getId_marca();
                Log.i("ID marca", id_marc + "");

                values.put(Utilidades.CAMPO_CLIE, edtCliente.getText().toString());
                values.put(Utilidades.CAMPO_DIRE, edtDireccion.getText().toString());
                values.put(Utilidades.CAMPO_REPA, edtRepartidor.getText().toString());
                values.put(Utilidades.CAMPO_ID_MARC, id_marc);




                db.update(Utilidades.TABLA_ASIG_PRO, values, Utilidades.CAMPO_ID_ASIG_PRO+ "=?",parametros);
                Toast.makeText(this, "Pedido Modificado", Toast.LENGTH_LONG).show();
                db.close();
            }
        }
    }

    //METODO BUSCAR//
    public void Buscar(View view){
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_productos", null, 1);
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={et_id_asig_alum.getText().toString()};
        try {
            //select nombre,telefono from usuario where codigo=?
            Cursor cursor=db.rawQuery("SELECT "+ Utilidades.CAMPO_CLIE+ "," + Utilidades.CAMPO_DIRE+ ","  + Utilidades.CAMPO_REPA+ "," +Utilidades.CAMPO_ID_PROD+","   + Utilidades.CAMPO_ID_MARC+
                    " FROM "+Utilidades.TABLA_ASIG_PRO+" WHERE "+Utilidades.CAMPO_ID_ASIG_PRO+"=? ", parametros);

            cursor.moveToFirst();

            edtCliente.setText(cursor.getString(0));
            edtDireccion.setText(cursor.getString(1));
            edtRepartidor.setText(cursor.getString(2));
            producto.setId(cursor.getInt(3));
            marca.setId(cursor.getInt(4 ));

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El pedido no existe",Toast.LENGTH_LONG).show();
            limpiar();
        }
    }


    private void limpiar(){
        et_id_asig_alum.setText("");
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnRegistroMascota : registrarMascota();
        }
    }


}