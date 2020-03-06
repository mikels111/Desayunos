package com.example.desayunoscebanc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Actividad_2 extends AppCompatActivity {
    Button siguiente,salir;
    ImageButton suizo,croissant,bizcocho,tortilla,jamon,chatka,sandia,melon,pina;
    TextView textoSuizo, textoCroissant, textoBizcocho,textoTortilla, textoJamon, textoChatka, textoSandia, textoMelon, textoPina;
    int cantSuizo,cantCroissant,cantBizcocho,cantTortilla,cantJamon,cantChatka,cantSandia,cantMelon,cantPina;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_2);

        Bundle bun=getIntent().getExtras();
        final String cantCafe,cantTe,cantInfu,cantCacao,cantAgua;
        cantCafe=bun.getString("cafe");
        cantTe=bun.getString("te");
        cantInfu=bun.getString("infusion");
        cantCacao=bun.getString("cacao");
        cantAgua=bun.getString("agua");

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
        textoSuizo =findViewById(R.id.txtSuizo);
        textoCroissant =findViewById(R.id.txtCroissant);
        textoBizcocho =findViewById(R.id.txtBizcocho);
        textoTortilla=findViewById(R.id.txtTortilla);
        textoJamon =findViewById(R.id.txtJamon);
        textoChatka =findViewById(R.id.txtChatka);
        textoSandia =findViewById(R.id.txtSandia);
        textoMelon =findViewById(R.id.txtMelon);
        textoPina =findViewById(R.id.txtPina);

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

        textoSuizo.setText(String.valueOf(cantSuizo));
        textoCroissant.setText(String.valueOf(cantCroissant));
        textoBizcocho.setText(String.valueOf(cantBizcocho));
        textoTortilla.setText(String.valueOf(cantTortilla));
        textoJamon.setText(String.valueOf(cantJamon));
        textoChatka.setText(String.valueOf(cantChatka));
        textoSandia.setText(String.valueOf(cantSandia));
        textoMelon.setText(String.valueOf(cantMelon));
        textoPina.setText(String.valueOf(cantPina));

        suizo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantSuizo+=1;
                textoSuizo.setText(String.valueOf(cantSuizo));

            }
        });

        croissant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantCroissant+=1;
                textoCroissant.setText(String.valueOf(cantCroissant));
            }
        });

        bizcocho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantBizcocho+=1;
                textoBizcocho.setText(String.valueOf(cantBizcocho));
            }
        });

        tortilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantTortilla+=1;
                textoTortilla.setText(String.valueOf(cantTortilla));
            }
        });
        jamon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantJamon+=1;
                textoJamon.setText(String.valueOf(cantJamon));
            }
        });
        chatka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantChatka+=1;
                textoChatka.setText(String.valueOf(cantChatka));
            }
        });

        sandia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantSandia+=1;
                textoSandia.setText(String.valueOf(cantSandia));
            }
        });

        melon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantMelon+=1;
                textoMelon.setText(String.valueOf(cantMelon));
            }
        });

        pina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantPina+=1;
                textoPina.setText(String.valueOf(cantPina));

            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Actividad_2.this,Actividad_3.class);
                Bundle bun =new Bundle();
                bun.putString("cafe",cantCafe);
                bun.putString("te",cantTe);
                bun.putString("infusion",cantInfu);
                bun.putString("cacao",cantCacao);
                bun.putString("agua",cantAgua);

                bun.putString("suizo",textoSuizo.getText().toString());
                bun.putString("croissant",textoCroissant.getText().toString());
                bun.putString("bizcocho",textoBizcocho.getText().toString());
                bun.putString("tortilla",textoTortilla.getText().toString());
                bun.putString("jamon",textoJamon.getText().toString());
                bun.putString("chatka",textoChatka.getText().toString());
                bun.putString("sandia",textoSandia.getText().toString());
                bun.putString("melon",textoMelon.getText().toString());
                bun.putString("pina",textoPina.getText().toString());

                intent.putExtras(bun);
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














