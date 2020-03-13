package com.example.desayunoscebanc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

public class Actividad_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_4);

        getWindow().setStatusBarColor(Color.parseColor("#21A5C5"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#21A5C5")));

    }
}
