package com.example.desayunoscebanc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.desayunoscebanc.R.id.listProductos;

public class Actividad_3 extends AppCompatActivity {


    TextView txtPrecioFinal;
    Button validar,salir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_3);

        //color en las barras
        getWindow().setStatusBarColor(Color.parseColor("#21A5C5"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#21A5C5")));

        ListView lista=findViewById(listProductos);
        txtPrecioFinal=findViewById(R.id.txtPrecioFinal);
        validar=findViewById(R.id.btnValidar);
        salir=findViewById(R.id.btnCancelar);

        Bundle bun=getIntent().getExtras();
        final int cafe,te,infusion,cacao,agua,suizo,croissant,bizcocho,tortilla,jamon,chatka,sandia,melon,pina;

        cafe=bun.getInt("cantCafe");
        te=bun.getInt("te");
        infusion=bun.getInt("infusion");
        cacao=bun.getInt("cacao");
        agua=bun.getInt("agua");
        suizo=bun.getInt("suizo");
        croissant=bun.getInt("croissant");
        bizcocho=bun.getInt("bizcocho");
        tortilla=bun.getInt("tortilla");
        jamon=bun.getInt("jamon");
        chatka=bun.getInt("chatka");
        sandia=bun.getInt("sandia");
        melon=bun.getInt("melon");
        pina=bun.getInt("pina");

        ArrayList <Producto> listaProductos=new ArrayList<>();
        Producto cafes=new Producto();
        Producto tes=new Producto();
        Producto infus=new Producto();
        Producto cacaos=new Producto();
        Producto aguas=new Producto();
        Producto suizos= new Producto();
        Producto croissants= new Producto();
        Producto bizcochos=new Producto();
        Producto tortillas=new Producto();
        Producto jamones=new Producto();
        Producto chatkas= new Producto();
        Producto sandias=new Producto();
        Producto melones=new Producto();
        Producto pinas=new Producto();
        if(cafe>0){
            cafes=new Producto("Cafe",cafe,1);
            listaProductos.add(cafes);
        }
        if(te>0){
            tes=new Producto("Te",te,0.70);
            listaProductos.add(tes);
        }
        if(infusion>0){
            infus=new Producto("Infusion",infusion,0.80);
            listaProductos.add(infus);
        }
        if(cacao>0){
            cacaos=new Producto("Cacao",cacao,1.25);
            listaProductos.add(cacaos);
        }
        if(agua>0){
            aguas=new Producto("Agua",agua,0.60);
            listaProductos.add(aguas);
        }
        if(suizo>0){
            suizos=new Producto("Bollo Suizo",suizo,1.90);
            listaProductos.add(suizos);
        }
        if(croissant>0){
            croissants=new Producto("Croissant",croissant,2);
            listaProductos.add(croissants);
        }
        if(bizcocho>0){
            bizcochos=new Producto("Bizcocho",bizcocho,2);
            listaProductos.add(bizcochos);
        }
        if(tortilla>0){
            tortillas=new Producto("Tortilla",tortilla,2.60);
            listaProductos.add(tortillas);
        }
        if (jamon>0){
            jamones=new Producto("Jamon",jamon,2.80);
            listaProductos.add(jamones);
        }
        if(chatka>0){
            chatkas=new Producto("Chatka",chatka,2.80);
            listaProductos.add(chatkas);
        }
        if(sandia>0){
            sandias=new Producto("Sandia",sandia,1);
            listaProductos.add(sandias);
        }
        if(melon>0){
            melones=new Producto("Melon",melon,1);
            listaProductos.add(melones);
        }
        if(pina>0){
            pinas=new Producto("Piña",melon,1);
            listaProductos.add(pinas);
        }

        ProductoListAdapter adaptador=new ProductoListAdapter(this,R.layout.producto_adaptador,listaProductos);
        lista.setAdapter(adaptador);
        final double precioFinal=((cafes.getPrecio())*(cafes.getCantidad())+
                (tes.getPrecio())*(tes.getCantidad())+
                (infus.getPrecio())*(infus.getCantidad())+
                (cacaos.getPrecio())*(cacaos.getCantidad())+
                (aguas.getPrecio())*(aguas.getCantidad())+
                (suizos.getPrecio())*(suizos.getCantidad())+
                (croissants.getPrecio())*(croissants.getCantidad())+
                (bizcochos.getPrecio())*(bizcochos.getCantidad())+
                (sandias.getPrecio())*(sandias.getCantidad())+
                (tortillas.getPrecio())*(tortillas.getCantidad())+
                (jamones.getPrecio())*(jamones.getCantidad())+
                (chatkas.getPrecio())*(chatkas.getCantidad())+
                (melones.getPrecio())*(melones.getCantidad())+
                (pinas.getPrecio())*(pinas.getCantidad()));

        txtPrecioFinal.setText(precioFinal+" €");

        validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Actividad_3.this,Actividad_4.class);
                Bundle bun=new Bundle();
                bun.putDouble("precioFinal",precioFinal);
                bun.putInt("cantCafe",cafe);
                bun.putInt("cantTe",te);
                bun.putInt("cantInfus",infusion);
                bun.putInt("cantCacao",cacao);
                bun.putInt("cantAgua",agua);
                bun.putInt("cantSuizo",suizo);
                bun.putInt("cantCroissant",croissant);
                bun.putInt("cantBizcocho",bizcocho);
                bun.putInt("cantTortilla",tortilla);
                bun.putInt("cantJamon",jamon);
                bun.putInt("cantChatka",chatka);
                bun.putInt("cantSandia",sandia);
                bun.putInt("cantMelon",melon);
                bun.putInt("cantPina",pina);
                intent.putExtras(bun);
                startActivity(intent);
            }
        });








    }
}
