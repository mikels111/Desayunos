package com.example.desayunoscebanc;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Actividad_4 extends AppCompatActivity {

    Button aceptar;
    EditText contrasena,nombre,direccion,telefono,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_4);

        //color en las barras
        getWindow().setStatusBarColor(Color.parseColor("#21A5C5"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#21A5C5")));

        //Boton
        aceptar=findViewById(R.id.btnAceptar);

        //EditText
        contrasena=findViewById(R.id.editContrasena);
        nombre=findViewById(R.id.editNombre);
        direccion=findViewById(R.id.editDireccion);
        telefono=findViewById(R.id.editTelefono);
        email=findViewById(R.id.editEmail);

        //Bundle
        Bundle bun=getIntent().getExtras();
        final double preciofinal=bun.getDouble("precioFinal");

        //Base de Datos
        BDSQLiteHelper bdDesayunos = new BDSQLiteHelper(this, "BDDesayunos", null, 8);
        final SQLiteDatabase bd = bdDesayunos.getWritableDatabase();

        contrasena.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    Cursor c=bd.rawQuery("SELECT Contrasena,Nombre,Direccion,Telefono,Email FROM Cliente WHERE Contrasena='"+ contrasena.getText()+"'",null);
                    if(c.moveToFirst()){
                        do {
                            nombre.setText(c.getString(1));
                            direccion.setText(c.getString(2));
                            telefono.setText(c.getString(3));
                            email.setText(c.getString(4));
                        }while(c.moveToNext());
                    }
                }
            }
        });


        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(contrasena.getText().length()!=0 && direccion.getText().length()!=0 && telefono.getText().length()!=0 && email.getText().length()!=0){
                    Cursor c=bd.rawQuery("SELECT count(*) FROM Cliente WHERE Nombre='"+nombre.getText()+"'",null);
                    c.moveToFirst();
                    int count=c.getInt(0);
                    int codigo;
                    if(count==0){
                        bd.execSQL("INSERT INTO Cliente(Contrasena,Nombre,Direccion,Telefono,Email) VALUES('"+contrasena.getText()+"','"+nombre.getText()+"','"+direccion.getText()+"','"+telefono.getText()+"','"+email.getText()+"')");
                        c=bd.rawQuery("SELECT CodCliente FROM Cliente WHERE Nombre='"+nombre.getText()+"'",null);
                        c.moveToFirst();
                        codigo=c.getInt(0);
                        bd.execSQL("INSERT INTO Pedido(CodCliente,Total,FechaPed) VALUES('"+codigo+"','"+preciofinal+"',datetime('now','localtime'))");
                    }else{
                        c=bd.rawQuery("SELECT CodCliente FROM Cliente WHERE Nombre='"+nombre.getText()+"'",null);
                        c.moveToFirst();
                        codigo=c.getInt(0);
                        bd.execSQL("INSERT INTO Pedido(CodCliente,total,FechaPed) VALUES('"+codigo+"','"+preciofinal+"',datetime('now','localtime'))");
                        Toast aviso = Toast.makeText(getApplicationContext(), "Gracias por su visita, pedido validado a nombre de "+nombre.getText(), Toast.LENGTH_SHORT);
                        aviso.show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Le falta algún dato por rellenar", Toast.LENGTH_SHORT).show();
                }

                if(contrasena.getText().length()==0){
                    contrasena.setBackgroundResource(R.drawable.color_rojo);
                }else{
                    contrasena.setBackgroundResource(R.drawable.color_gris);
                }
                if (direccion.getText().length()==0){
                    direccion.setBackgroundResource(R.drawable.color_rojo);
                }else{
                    contrasena.setBackgroundResource(R.drawable.color_gris);
                }
                if(telefono.getText().length()==0){
                    telefono.setBackgroundResource(R.drawable.color_rojo);
                }else{
                    contrasena.setBackgroundResource(R.drawable.color_gris);
                }
                if(email.getText().length()==0){
                    email.setBackgroundResource(R.drawable.color_rojo);
                }else{
                    contrasena.setBackgroundResource(R.drawable.color_gris);
                }
            }
        });

    }
}
