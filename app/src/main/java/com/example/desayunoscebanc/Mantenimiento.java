package com.example.desayunoscebanc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class Mantenimiento extends AppCompatActivity {


    ImageButton usuarios,productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mantenimiento);

        //color en las barras
        getWindow().setStatusBarColor(Color.parseColor("#21A5C5"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#21A5C5")));

        usuarios=findViewById(R.id.btnUsuario);
        productos=findViewById(R.id.btnDesayuno);

        usuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Mantenimiento.this,Actividad_admin.class);
                startActivity(intent);
            }
        });

        productos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Mantenimiento.this,Actividad_admin.class);
                startActivity(intent);
            }
        });

    }
}
