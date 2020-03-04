package com.example.desayunoscebanc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

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

    }
}
