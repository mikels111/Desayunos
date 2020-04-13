package com.example.desayunoscebanc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class ProductoListAdapter extends ArrayAdapter<Producto> {

    private Context contexto;
    int recurso;
    public ProductoListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Producto> objects) {
        super(context, resource, objects);
        contexto=context;
        recurso=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String nombre= getItem(position).getNombre();
        int cantidad=getItem(position).getCantidad();
        double precio=getItem(position).getPrecio();

        //Producto producto=new Producto(nombre,cantidad,precio);
        LayoutInflater inflater= LayoutInflater.from(contexto);
        convertView =inflater.inflate(recurso,parent,false);

        TextView convertNombre=convertView.findViewById(R.id.textView1);
        TextView convertCantidad=convertView.findViewById(R.id.textView2);
        TextView convertPrecio=convertView.findViewById(R.id.textView3);

        convertNombre.setText(nombre);
        convertCantidad.setText(String.valueOf(cantidad)+" unidades");
        convertPrecio.setText(String.valueOf(precio)+" €");

        return convertView;
    }
}
