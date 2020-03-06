package com.example.desayunoscebanc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Actividad_3 extends AppCompatActivity {
    ArrayList <String> listaProductos=new ArrayList<>();
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_3);

        lista=findViewById(R.id.listProductos);

        Bundle bun=new Bundle();
        String cafe,te,infusion,cacao,agua,suizo,croissant,bizcocho,tortilla,jamon,chatka,sandia,melon,pina;
        cafe=bun.getString("cafe");
        te=bun.getString("te");
        infusion=bun.getString("infusion");
        cacao=bun.getString("cacao");
        agua=bun.getString("agua");
        suizo=bun.getString("suizo");
        croissant=bun.getString("croissant");
        bizcocho=bun.getString("bizcocho");
        tortilla=bun.getString("torilla");
        jamon=bun.getString("jamon");
        chatka=bun.getString("chatka");
        sandia=bun.getString("sandia");
        melon=bun.getString("melon");
        pina=bun.getString("pina");


        /*ArrayAdapter <Bebida> adapterBebidas=new ArrayAdapter<Bebida>(this,android.R.layout.simple_list_item_1,listaBebidas);
        lista.setAdapter(adapterBebidas);
        Bebida bebida1=new Bebida("cafe",2);
        listaBebidas.add(bebida1);*/

        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listaProductos);
        lista.setAdapter(adaptador);
        //listaProductos.add();

        for (String record:listaProductos){
        }

    }
}
