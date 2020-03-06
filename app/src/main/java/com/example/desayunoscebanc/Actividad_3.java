package com.example.desayunoscebanc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Actividad_3 extends AppCompatActivity {
    ArrayList <String> listaProductos=new ArrayList<>();
    ListView lista;
    TextView txtPrecioFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_3);

        lista=findViewById(R.id.listProductos);
        txtPrecioFinal=findViewById(R.id.txtPrecioFinal);

        Bundle bun=getIntent().getExtras();
        int cafe,te,infusion,cacao,agua,suizo,croissant,bizcocho,tortilla,jamon,chatka,sandia,melon,pina;

        cafe=bun.getInt("cantCafe");
        te=bun.getInt("te");
        infusion=bun.getInt("infusion");
        cacao=bun.getInt("cacao");
        agua=bun.getInt("agua");
        suizo=bun.getInt("suizo");
        croissant=bun.getInt("croissant");
        bizcocho=bun.getInt("bizcocho");
        tortilla=bun.getInt("torilla");
        jamon=bun.getInt("jamon");
        chatka=bun.getInt("chatka");
        sandia=bun.getInt("sandia");
        melon=bun.getInt("melon");
        pina=bun.getInt("pina");



        /*ArrayAdapter <Bebida> adapterBebidas=new ArrayAdapter<Bebida>(this,android.R.layout.simple_list_item_1,listaBebidas);
        lista.setAdapter(adapterBebidas);
        Bebida bebida1=new Bebida("cafe",2);
        listaBebidas.add(bebida1);*/

        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,android.R.layout.simple_list_item_2,listaProductos);
        lista.setAdapter(adaptador);

        listaProductos.add(String.valueOf(cafe));
        listaProductos.add(String.valueOf(te));






    }
}
