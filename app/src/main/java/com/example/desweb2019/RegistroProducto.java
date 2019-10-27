package com.example.desweb2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.desweb2019.Utilidades.Assets;

public class RegistroProducto extends AppCompatActivity {
    EditText id, nombre, precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_producto);

        id = findViewById(R.id.editText);
        nombre = findViewById(R.id.editText2);
        precio = findViewById(R.id.editText3);
    }

    public void onCLick(View view){
        registrarUsuarios();
    }

    private void registrarUsuarios() {
        try{
            Conexion conn = new Conexion(this, Assets.DB_NAME, null, Assets.DB_VERSION);
            SQLiteDatabase db = conn.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(Assets.CAMPO_ID_PRODUCTO, id.getText().toString());
            values.put(Assets.CAMPO_NOMBRE_PRODUCTO, nombre.getText().toString());
            values.put(Assets.CAMPO_PRECIO_PRODUCTO, Double.parseDouble(precio.getText().toString()));


            Long result = db.insert(Assets.TABLA_PRODUCTO, Assets.CAMPO_ID_PRODUCTO, values);

            Toast.makeText(getApplicationContext(), "Id Registrado :"+result, Toast.LENGTH_LONG ).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG ).show();
        }

    }
}
