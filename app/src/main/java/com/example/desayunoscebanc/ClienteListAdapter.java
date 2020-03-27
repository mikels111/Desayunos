package com.example.desayunoscebanc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class ClienteListAdapter extends ArrayAdapter<Cliente> {

    private Context contexto;
    int recurso;
    public ClienteListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Cliente> objects){
        super(context,resource,objects);
        contexto=context;
        recurso=resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        String nombre=getItem(position).getNombre();
        String direccion=getItem(position).getDireccion();
        String telefono=getItem(position).getNumero();

        LayoutInflater inflater= LayoutInflater.from(contexto);
        convertView =inflater.inflate(recurso,parent,false);

        TextView convertNombre=convertView.findViewById(R.id.textView1);
        TextView convertCantidad=convertView.findViewById(R.id.textView2);
        TextView convertPrecio=convertView.findViewById(R.id.textView3);

        convertNombre.setText(nombre);
        convertCantidad.setText(direccion);
        convertPrecio.setText(telefono);

        return convertView;
    }
}
