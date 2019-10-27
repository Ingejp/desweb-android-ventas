package com.example.desweb2019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.desweb2019.Modelos.Producto;
import com.example.desweb2019.Utilidades.Assets;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Producto> listProductos;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Conexion conn=new Conexion(this, Assets.DB_NAME, null, Assets.DB_VERSION);

    }



    public void onClick(View view){
        Intent intent = null;
        switch (view.getId()){
            case R.id.btnProducto:
                intent = new Intent(this, RegistroProducto.class );
                break;
            case R.id.btnListProducto:
                intent = new Intent(this, ListaDeProductos.class );
                break;
        }
        if (intent!=null){
            startActivity(intent);
        }
    }


}
