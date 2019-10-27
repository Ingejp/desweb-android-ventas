package com.example.desweb2019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.desweb2019.Modelos.Producto;
import com.example.desweb2019.Utilidades.Assets;

import java.util.ArrayList;

public class ListaDeProductos extends AppCompatActivity {

    ArrayList<Producto> listaProducto;
    RecyclerView recyclerViewProductos;
    Conexion conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_productos);

        try{
            conn=new Conexion(getApplicationContext(), Assets.DB_NAME, null, Assets.DB_VERSION);

            listaProducto = new ArrayList<>();
            recyclerViewProductos = findViewById(R.id.IdRecyclerProductos);

            recyclerViewProductos.setLayoutManager(new LinearLayoutManager(this));

            consultarListaProductos();

            AdapterProductList adapter = new AdapterProductList(listaProducto);
            recyclerViewProductos.setAdapter(adapter);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG ).show();
        }



    }

    private void consultarListaProductos() {
        SQLiteDatabase db=conn.getReadableDatabase();
        Producto producto =null;

        Cursor cursor=db.rawQuery("Select * from " + Assets.TABLA_PRODUCTO, null);

        while(cursor.moveToNext()){
            producto = new Producto();
            producto.setId(cursor.getString(0));
            producto.setNombre(cursor.getString(1));
            producto.setPrecio(cursor.getString(2));

            listaProducto.add(producto);

        }

    }
}
