package com.example.desayunoscebanc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Actividad_1 extends AppCompatActivity {
    Button btnSiguiente,salir;
    ImageButton cafe,te,infusion,cacao,agua;
    TextView txtCafe,txtTe,txtInfusion,txtCacao,txtAgua;
    int cantCafe,cantTe,cantInfu,cantCacao,cantAgua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_1);

        //Button
        btnSiguiente=findViewById(R.id.btnSiguiente);
        salir=findViewById(R.id.btnCancelar);

        //ImageButton
        cafe=findViewById(R.id.btnCafe);
        te=findViewById(R.id.btnTe);
        infusion=findViewById(R.id.btnInfusion);
        cacao=findViewById(R.id.btnCacao);
        agua=findViewById(R.id.btnAgua);

        //Text
        txtCafe=findViewById(R.id.txtCafe);
        txtTe=findViewById(R.id.txtTe);
        txtInfusion=findViewById(R.id.txtInfusion);
        txtCacao=findViewById(R.id.txtCacao);
        txtAgua=findViewById(R.id.txtAgua);

        //Cantidades
        cantCafe=0;
        cantTe=0;
        cantInfu=0;
        cantCacao=0;
        cantAgua=0;
        txtCafe.setText(String.valueOf(cantCafe));
        txtTe.setText(String.valueOf(cantTe));
        txtInfusion.setText(String.valueOf(cantInfu));
        txtCacao.setText(String.valueOf(cantCacao));
        txtAgua.setText(String.valueOf(cantAgua));




        cafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantCafe+=1;
                txtCafe.setText(String.valueOf(cantCafe));
            }
        });

        te.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantTe+=1;
                txtTe.setText(String.valueOf(cantTe));
            }
        });

        infusion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantInfu+=1;
                txtInfusion.setText(String.valueOf(cantInfu));
            }
        });

        cacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantCacao+=1;
                txtCacao.setText(String.valueOf(cantCacao));
            }
        });

        agua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantAgua+=1;
                txtAgua.setText(String.valueOf(cantAgua));
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Actividad_1.this,Actividad_2.class);
                Bundle bundle =new Bundle();
                bundle.putInt("cafe", Integer.parseInt(txtCafe.getText().toString()));
                bundle.putString("te",txtTe.getText().toString());
                bundle.putString("infusion",txtInfusion.getText().toString());
                bundle.putString("cacao",txtCacao.getText().toString());
                bundle.putString("agua",txtAgua.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}








