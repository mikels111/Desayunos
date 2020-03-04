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
    }
}
