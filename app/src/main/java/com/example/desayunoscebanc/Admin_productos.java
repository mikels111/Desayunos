package com.example.desayunoscebanc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Admin_productos extends AppCompatActivity {

    LinearLayout cafe,te,infu,cacao,agua,suizo,croissant,bizcocho,tortilla,jamon,chatka,sandia,melon,pina;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_productos);
        //color en las barras
        getWindow().setStatusBarColor(Color.parseColor("#21A5C5"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#21A5C5")));

        cafe=findViewById(R.id.HorizontalCafe);
        te=findViewById(R.id.HorizontalTe);
        infu=findViewById(R.id.HorizontalInfu);
        cacao=findViewById(R.id.HorizontalCacao);
        agua=findViewById(R.id.horizontalAgua);
        suizo=findViewById(R.id.horizontalBollo);
        croissant=findViewById(R.id.horizontalCroissant);
        bizcocho=findViewById(R.id.horizontalBizco);
        tortilla=findViewById(R.id.horizontalTortilla);
        jamon=findViewById(R.id.horizontalJamon);
        chatka=findViewById(R.id.horizontalChatka);
        sandia=findViewById(R.id.horizontalSandia);
        melon=findViewById(R.id.horizontalMelon);
        pina=findViewById(R.id.horizontalPina);


        cafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarProducto("Cafe");
            }
        });
        te.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarProducto("Te");
            }
        });
        infu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarProducto("Infusion");
            }
        });
        cacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarProducto("Cacao");
            }
        });
        agua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarProducto("Agua");
            }
        });
        suizo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarProducto("Bollo Suizo");
            }
        });
        croissant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarProducto("Croissant");
            }
        });
        bizcocho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarProducto("Bizcocho");
            }
        });
        tortilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarProducto("Tortilla");
            }
        });
        jamon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarProducto("Jamon");
            }
        });
        chatka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarProducto("Chatka");
            }
        });
        sandia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarProducto("Sandia");
            }
        });
        melon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarProducto("Melon");
            }
        });
        pina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarProducto("Piña");
            }
        });
    }
    public void modificarProducto(String nombre){
        Intent intent=new Intent(Admin_productos.this,ModificarInfoProducto.class);
        intent.putExtra("producto",nombre);
        startActivity(intent);
    }
}
