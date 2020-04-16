package com.example.desayunoscebanc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Actividad_1 extends AppCompatActivity {
    Button btnSiguiente,salir;
    ImageButton cafe,te,infusion,cacao,agua;
    TextView txtCafe,txtTe,txtInfusion,txtCacao,txtAgua;
    TextView txtPrecioCafe,txtPrecioTe,txtPrecioInfusion,txtPrecioCacao,txtPrecioAgua;
    int cantCafe,cantTe,cantInfu,cantCacao,cantAgua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_1);

        //color en las barras
        getWindow().setStatusBarColor(Color.parseColor("#21A5C5"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#21A5C5")));

        //Button
        {
            btnSiguiente = findViewById(R.id.btnSiguiente);
            salir = findViewById(R.id.btnCancelar);
        }
        //ImageButton
        {
            cafe = findViewById(R.id.btnCafe);
            te = findViewById(R.id.btnTe);
            infusion = findViewById(R.id.btnInfusion);
            cacao = findViewById(R.id.btnCacao);
            agua = findViewById(R.id.btnAgua);
        }
        //Text
        {
            txtCafe = findViewById(R.id.txtCafe);
            txtTe = findViewById(R.id.txtTe);
            txtInfusion = findViewById(R.id.txtInfusion);
            txtCacao = findViewById(R.id.txtCacao);
            txtAgua = findViewById(R.id.txtAgua);

            txtPrecioCafe=findViewById(R.id.txtPrecioCafe);
            txtPrecioTe=findViewById(R.id.txtPrecioTe);
            txtPrecioInfusion=findViewById(R.id.txtPrecioInfu);
            txtPrecioCacao=findViewById(R.id.txtPrecioCacao);
            txtPrecioAgua=findViewById(R.id.txtPrecioAgua);
        }
        //Cantidades
        {
            cantCafe = 0;
            cantTe = 0;
            cantInfu = 0;
            cantCacao = 0;
            cantAgua = 0;
            txtCafe.setText(String.valueOf(cantCafe));
            txtTe.setText(String.valueOf(cantTe));
            txtInfusion.setText(String.valueOf(cantInfu));
            txtCacao.setText(String.valueOf(cantCacao));
            txtAgua.setText(String.valueOf(cantAgua));
        }

        BDSQLiteHelper bdDesayunos = new BDSQLiteHelper(this, "BDDesayunos", null, 11);
        SQLiteDatabase bd = bdDesayunos.getWritableDatabase();

        Cursor c = bd.rawQuery("SELECT CodProducto,Precio FROM Producto", null);
        if(c.moveToFirst()){
            do{
                int codProducto=c.getInt(0);
                double precio=c.getDouble(1);
                if(codProducto==1){
                    txtPrecioCafe.setText(String.valueOf(precio));
                }else if(codProducto==2){
                    txtPrecioTe.setText(String.valueOf(precio));
                }else if(codProducto==3){
                    txtPrecioInfusion.setText(String.valueOf(precio));
                }else if(codProducto==4){
                    txtPrecioCacao.setText(String.valueOf(precio));
                }else if(codProducto==5){
                    txtPrecioAgua.setText(String.valueOf(precio));
                }
            }while(c.moveToNext());
        }


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
                bundle.putInt("cafe", cantCafe);
                bundle.putInt("te",cantTe);
                bundle.putInt("infusion",cantInfu);
                bundle.putInt("cacao",cantCacao);
                bundle.putInt("agua",cantAgua);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
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








