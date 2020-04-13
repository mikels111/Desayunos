package com.example.desayunoscebanc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ModificarInfoProducto extends AppCompatActivity {
    TextView prueba;
    EditText editNombre, editPrecio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_info_producto);

        //color en las barras
        getWindow().setStatusBarColor(Color.parseColor("#21A5C5"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#21A5C5")));

        editNombre =findViewById(R.id.editNombre);
        editPrecio =findViewById(R.id.editPrecio);

        Intent intent=getIntent();
        String producto=intent.getStringExtra("producto");
        prueba=findViewById(R.id.textView57);
        prueba.setText(producto);

        //Base de Datos
        BDSQLiteHelper bdDesayunos = new BDSQLiteHelper(this, "BDDesayunos", null, 10);
        SQLiteDatabase bd = bdDesayunos.getWritableDatabase();


            Cursor c = bd.rawQuery("SELECT Nombre,Precio FROM Producto WHERE Nombre='" + producto + "'", null);
            c.moveToFirst();
            String nomb = c.getString(0);
            Double precio = c.getDouble(1);
            editNombre.setText(nomb);
            editPrecio.setText(precio.toString());


    }
}
