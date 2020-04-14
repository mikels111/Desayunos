package com.example.desayunoscebanc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Admin_productos extends AppCompatActivity {

    LinearLayout cafe,te,infu,cacao,agua,suizo,croissant,bizcocho,tortilla,jamon,chatka,sandia,melon,pina;
    TextView txtcafe,txtTe,txtInfu,txtCacao,txtAgua,txtSuizo,txtCroissant,txtBizcocho,txtTortilla,txtJamon,txtChatka,txtSandia,txtMelon,txtPina;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_productos);
        //color en las barras
        getWindow().setStatusBarColor(Color.parseColor("#21A5C5"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#21A5C5")));
        //horizontalViews
        {
            cafe = findViewById(R.id.HorizontalCafe);
            te = findViewById(R.id.HorizontalTe);
            infu = findViewById(R.id.HorizontalInfu);
            cacao = findViewById(R.id.HorizontalCacao);
            agua = findViewById(R.id.horizontalAgua);
            suizo = findViewById(R.id.horizontalBollo);
            croissant = findViewById(R.id.horizontalCroissant);
            bizcocho = findViewById(R.id.horizontalBizco);
            tortilla = findViewById(R.id.horizontalTortilla);
            jamon = findViewById(R.id.horizontalJamon);
            chatka = findViewById(R.id.horizontalChatka);
            sandia = findViewById(R.id.horizontalSandia);
            melon = findViewById(R.id.horizontalMelon);
            pina = findViewById(R.id.horizontalPina);
        }
        //textViews
        {
          txtcafe=findViewById(R.id.txtCafe);
          txtTe=findViewById(R.id.txtTe);
          txtInfu=findViewById(R.id.txtInfu);
          txtCacao=findViewById(R.id.txtCacao);
          txtAgua=findViewById(R.id.txtAgua);
          txtSuizo=findViewById(R.id.txtSuizo);
          txtCroissant=findViewById(R.id.txtCroissant);
          txtBizcocho=findViewById(R.id.txtBizcocho);
          txtTortilla=findViewById(R.id.txtTortilla);
          txtJamon=findViewById(R.id.txtJamon);
          txtChatka=findViewById(R.id.txtChatka);
          txtSandia=findViewById(R.id.txtSandia);
          txtMelon=findViewById(R.id.txtMelon);
          txtPina=findViewById(R.id.txtPina);
        }

        BDSQLiteHelper bdDesayunos = new BDSQLiteHelper(this, "BDDesayunos", null, 11);
        final SQLiteDatabase bd = bdDesayunos.getWritableDatabase();


        Cursor c = bd.rawQuery("SELECT CodProducto,Nombre FROM Producto", null);
        if(c.moveToFirst()){
            do{
                int codProducto=c.getInt(0);
                String nomb = c.getString(1);
                if(codProducto==1){
                    txtcafe.setText(nomb);
                }else if(codProducto==2){
                    txtTe.setText(nomb);
                }else if(codProducto==3){
                    txtInfu.setText(nomb);
                }else if(codProducto==4){
                    txtCacao.setText(nomb);
                }else if(codProducto==5){
                    txtAgua.setText(nomb);
                }else if(codProducto==6){
                    txtSuizo.setText(nomb);
                }else if(codProducto==7){
                    txtCroissant.setText(nomb);
                }else if(codProducto==8){
                    txtBizcocho.setText(nomb);
                }else if (codProducto==9){
                    txtTortilla.setText(nomb);
                }else if(codProducto==10){
                    txtJamon.setText(nomb);
                }else if(codProducto==11){
                    txtChatka.setText(nomb);
                }else if(codProducto==12){
                    txtSandia.setText(nomb);
                }else if(codProducto==13){
                    txtMelon.setText(nomb);
                }else if (codProducto==14){
                    txtPina.setText(nomb);
                }


            }while(c.moveToNext());
        }


        cafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarProducto(txtcafe.getText().toString());
            }
        });
        te.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarProducto(txtTe.getText().toString());
            }
        });
        infu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarProducto(txtInfu.getText().toString());
            }
        });
        cacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarProducto(txtCacao.getText().toString());
            }
        });
        agua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarProducto(txtAgua.getText().toString());
            }
        });
        suizo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarProducto(txtSuizo.getText().toString());
            }
        });
        croissant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarProducto(txtCroissant.getText().toString());
            }
        });
        bizcocho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarProducto(txtBizcocho.getText().toString());
            }
        });
        tortilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarProducto(txtTortilla.getText().toString());
            }
        });
        jamon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarProducto(txtJamon.getText().toString());
            }
        });
        chatka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarProducto(txtChatka.getText().toString());
            }
        });
        sandia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarProducto(txtSandia.getText().toString());
            }
        });
        melon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarProducto(txtMelon.getText().toString());
            }
        });
        pina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarProducto(txtPina.getText().toString());
            }
        });
    }
    public void modificarProducto(String nombre){
        Intent intent=new Intent(Admin_productos.this,ModificarInfoProducto.class);
        intent.putExtra("producto",nombre);
        startActivity(intent);
        finish();
    }
}
