package com.example.desweb2019;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desweb2019.Modelos.Producto;

import java.util.ArrayList;

public class AdapterProductList extends RecyclerView.Adapter<AdapterProductList.ViewHolderDatos> {

    ArrayList<Producto> listProductos;

    public AdapterProductList(ArrayList<Producto> listProductos) {
        this.listProductos = listProductos;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlistproductos, null, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        //holder.asignarDatos(listProductos.get(position));
        holder.id.setText(listProductos.get(position).getId().toString());
        holder.nombre.setText(listProductos.get(position).getNombre().toString());
        holder.precio.setText(listProductos.get(position).getPrecio().toString());
    }

    @Override
    public int getItemCount() {
        return listProductos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView id, nombre, precio;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.idDetalle);
            nombre = itemView.findViewById(R.id.nombreDetalle);
            precio = itemView.findViewById(R.id.precioDetalle);
        }

       /* public void asignarDatos(String datos) {
            dato.setText(datos);
        }*/
    }
}
