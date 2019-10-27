package com.example.desweb2019;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.desweb2019.Utilidades.Assets;

public class Conexion extends SQLiteOpenHelper {

    public Conexion(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Assets.CREAR_TABLA_PRODUCTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS PRODUCTO");
        db.execSQL("DROP TABLE IF EXISTS USUARIO");
        onCreate(db);
    }

}
