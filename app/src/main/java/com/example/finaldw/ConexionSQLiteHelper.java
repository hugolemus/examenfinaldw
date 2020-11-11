package com.example.finaldw;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.finaldw.utilidades.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {




    public ConexionSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_PRODUCTO);
        db.execSQL(Utilidades.CREAR_TABLA_MARCA);
        db.execSQL(Utilidades.CREAR_TABLA_ASIG_PRO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_PRODUCTO);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_MARCA);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_ASIG_PRO);
        onCreate(db);

    }
}
