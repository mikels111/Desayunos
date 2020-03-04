package com.example.desayunoscebanc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Actividad_2 extends AppCompatActivity {
    Button siguiente,salir;
    ImageButton suizo,croissant,bizcocho,tortilla,jamon,chatka,sandia,melon,pina;
    TextView txtSuizo,txtCroissant,txtBizcocho,txtTortilla,txtJamon,txtChatka,txtSandia,txtMelon,txtPina;
    int cantSuizo,cantCroissant,cantBizcocho,cantTortilla,cantJamon,cantChatka,cantSandia,cantMelon,cantPina;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_2);


        //Buttons
        siguiente=findViewById(R.id.btnSiguiente);
        salir=findViewById(R.id.btnCancelar);

        //ImageButtons
        suizo=findViewById(R.id.btnSuizo);
        croissant=findViewById(R.id.btnCroissant);
        bizcocho=findViewById(R.id.btnBizcocho);
        tortilla=findViewById(R.id.btnTortilla);
        jamon=findViewById(R.id.btnJamon);
        chatka=findViewById(R.id.btnChatka);
        sandia=findViewById(R.id.btnSandia);
        melon=findViewById(R.id.btnMelon);
        pina=findViewById(R.id.btnPina);

        //Text
        txtSuizo=findViewById(R.id.txtSuizo);
        txtCroissant=findViewById(R.id.txtCroissant);
        txtBizcocho=findViewById(R.id.txtBizcocho);
        txtTortilla=findViewById(R.id.txtTortilla);
        txtJamon=findViewById(R.id.txtJamon);
        txtChatka=findViewById(R.id.txtChatka);
        txtSandia=findViewById(R.id.txtSandia);
        txtMelon=findViewById(R.id.txtMelon);
        txtPina=findViewById(R.id.txtPina);

        //cantidades
        cantSuizo=0;
        cantCroissant=0;
        cantBizcocho=0;
        cantTortilla=0;
        cantJamon=0;
        cantChatka=0;
        cantSandia=0;
        cantMelon=0;
        cantPina=0;

        txtSuizo.setText(String.valueOf(cantSuizo));
        txtCroissant.setText(String.valueOf(cantCroissant));
        txtBizcocho.setText(String.valueOf(cantBizcocho));
        txtTortilla.setText(String.valueOf(cantTortilla));
        txtJamon.setText(String.valueOf(cantJamon));
        txtChatka.setText(String.valueOf(cantChatka));
        txtSandia.setText(String.valueOf(cantSandia));
        txtMelon.setText(String.valueOf(cantMelon));
        txtPina.setText(String.valueOf(cantPina));

        suizo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantSuizo+=1;
                txtSuizo.setText(String.valueOf(cantSuizo));

            }
        });

        croissant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantCroissant+=1;
                txtCroissant.setText(String.valueOf(cantCroissant));
            }
        });

        bizcocho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantBizcocho+=1;
                txtBizcocho.setText(String.valueOf(cantBizcocho));
            }
        });

        tortilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantTortilla+=1;
                txtTortilla.setText(String.valueOf(cantTortilla));
            }
        });
        jamon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantJamon+=1;
                txtJamon.setText(String.valueOf(cantJamon));
            }
        });
        chatka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantChatka+=1;
                txtChatka.setText(String.valueOf(cantChatka));
            }
        });

        sandia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantSandia+=1;
                txtSandia.setText(String.valueOf(cantSandia));
            }
        });

        melon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantMelon+=1;
                txtMelon.setText(String.valueOf(cantMelon));
            }
        });

        pina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantPina+=1;
                txtPina.setText(String.valueOf(cantPina));
                //
            }
        });
    }
}














