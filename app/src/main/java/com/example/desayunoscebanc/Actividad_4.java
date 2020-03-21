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
    TextView prueba;
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
        prueba=findViewById(R.id.textView27);

        //Bundle
        Bundle bun=getIntent().getExtras();
        final int cantCafe=bun.getInt("cantCafe");
        final int cantTe=bun.getInt("cannTe");
        final int cantInfus=bun.getInt("cantInfus");
        final int cantCacao=bun.getInt("cantCacao");
        final int cantAgua=bun.getInt("cantAgua");
        final int cantSuizo=bun.getInt("cantSuizo");
        final int cantCroissant=bun.getInt("cantCroissant");
        final int cantBizcocho=bun.getInt("cantBizcocho");
        final int cantTortilla=bun.getInt("cantTortilla");
        final int cantJamon=bun.getInt("cantJamon");
        final int cantChatka=bun.getInt("cantChatka");
        final int cantSandia=bun.getInt("cantSandia");
        final int cantMelon=bun.getInt("cantMelon");
        final int cantPina=bun.getInt("cantPina");
        final double preciofinal=bun.getDouble("precioFinal");

        //Base de Datos
        BDSQLiteHelper bdDesayunos = new BDSQLiteHelper(this, "BDDesayunos", null, 10);
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
                        c=bd.rawQuery("SELECT codPedido FROM Pedido WHERE codCliente='"+codigo+"' AND FechaPed=datetime('now','localtime')",null);
                        c.moveToFirst();
                        int codigoPed=c.getInt(0);
                        if(cantCafe>0){
                            bd.execSQL("INSERT INTO Linea(codProducto,codPedido,cantidad) VALUES(1,'"+codigoPed+"','"+cantCafe+"')");
                        }
                        if(cantTe>0){
                            bd.execSQL("INSERT INTO Linea(codProducto,codPedido,cantidad) VALUES(2,'"+codigoPed+"','"+cantTe+"')");
                        }
                        if(cantInfus>0){
                            bd.execSQL("INSERT INTO Linea(codProducto,codPedido,cantidad) VALUES(3,'"+codigoPed+"','"+cantInfus+"')");
                        }
                        if(cantCacao>0){
                            bd.execSQL("INSERT INTO Linea(codProducto,codPedido,cantidad) VALUES(4,'"+codigoPed+"','"+cantCacao+"')");
                        }
                        if(cantAgua>0){
                            bd.execSQL("INSERT INTO Linea(codProducto,codPedido,cantidad) VALUES(5,'"+codigoPed+"','"+cantAgua+"')");
                        }
                        if(cantSuizo>0){
                            bd.execSQL("INSERT INTO Linea(codProducto,codPedido,cantidad) VALUES(6,'"+codigoPed+"','"+cantSuizo+"')");
                        }
                        if(cantCroissant>0){
                            bd.execSQL("INSERT INTO Linea(codProducto,codPedido,cantidad) VALUES(7,'"+codigoPed+"','"+cantCroissant+"')");
                        }
                        if(cantBizcocho>0){
                            bd.execSQL("INSERT INTO Linea(codProducto,codPedido,cantidad) VALUES(8,'"+codigoPed+"','"+cantBizcocho+"')");
                        }
                        if(cantTortilla>0){
                            bd.execSQL("INSERT INTO Linea(codProducto,codPedido,cantidad) VALUES(9,'"+codigoPed+"','"+cantTortilla+"')");
                        }
                        if(cantJamon>0){
                            bd.execSQL("INSERT INTO Linea(codProducto,codPedido,cantidad) VALUES(10,'"+codigoPed+"','"+cantJamon+"')");
                        }
                        if(cantChatka>0){
                            bd.execSQL("INSERT INTO Linea(codProducto,codPedido,cantidad) VALUES(11,'"+codigoPed+"','"+cantChatka+"')");
                        }
                        if(cantSandia>0){
                            bd.execSQL("INSERT INTO Linea(codProducto,codPedido,cantidad) VALUES(12,'"+codigoPed+"','"+cantSandia+"')");
                        }
                        if(cantMelon>0){
                            bd.execSQL("INSERT INTO Linea(codProducto,codPedido,cantidad) VALUES(13,'"+codigoPed+"','"+cantMelon+"')");
                        }
                        if(cantPina>0){
                            bd.execSQL("INSERT INTO Linea(codProducto,codPedido,cantidad) VALUES(14,'"+codigoPed+"','"+cantPina+"')");
                        }
                        Toast aviso = Toast.makeText(getApplicationContext(), "Gracias por su visita, pedido validado a nombre de "+nombre.getText(), Toast.LENGTH_SHORT);
                        aviso.show();
                    }else{
                        c=bd.rawQuery("SELECT CodCliente FROM Cliente WHERE Nombre='"+nombre.getText()+"'",null);
                        c.moveToFirst();
                        codigo=c.getInt(0);
                        bd.execSQL("INSERT INTO Pedido(CodCliente,total,FechaPed) VALUES('"+codigo+"','"+preciofinal+"',datetime('now','localtime'))");
                        c=bd.rawQuery("SELECT codPedido FROM Pedido WHERE codCliente='"+codigo+"' AND FechaPed=datetime('now','localtime')",null);
                        c.moveToFirst();
                        int codigoPed=c.getInt(0);
                        if(cantCafe>0){
                            bd.execSQL("INSERT INTO Linea(codProducto,codPedido,cantidad) VALUES(1,'"+codigoPed+"','"+cantCafe+"')");
                        }
                        if(cantTe>0){
                            bd.execSQL("INSERT INTO Linea(codProducto,codPedido,cantidad) VALUES(2,'"+codigoPed+"','"+cantTe+"')");
                        }
                        if(cantInfus>0){
                            bd.execSQL("INSERT INTO Linea(codProducto,codPedido,cantidad) VALUES(3,'"+codigoPed+"','"+cantInfus+"')");
                        }
                        if(cantCacao>0){
                            bd.execSQL("INSERT INTO Linea(codProducto,codPedido,cantidad) VALUES(4,'"+codigoPed+"','"+cantCacao+"')");
                        }
                        if(cantAgua>0){
                            bd.execSQL("INSERT INTO Linea(codProducto,codPedido,cantidad) VALUES(5,'"+codigoPed+"','"+cantAgua+"')");
                        }
                        if(cantSuizo>0){
                            bd.execSQL("INSERT INTO Linea(codProducto,codPedido,cantidad) VALUES(6,'"+codigoPed+"','"+cantSuizo+"')");
                        }
                        if(cantCroissant>0){
                            bd.execSQL("INSERT INTO Linea(codProducto,codPedido,cantidad) VALUES(7,'"+codigoPed+"','"+cantCroissant+"')");
                        }
                        if(cantBizcocho>0){
                            bd.execSQL("INSERT INTO Linea(codProducto,codPedido,cantidad) VALUES(8,'"+codigoPed+"','"+cantBizcocho+"')");
                        }
                        if(cantTortilla>0){
                            bd.execSQL("INSERT INTO Linea(codProducto,codPedido,cantidad) VALUES(9,'"+codigoPed+"','"+cantTortilla+"')");
                        }
                        if(cantJamon>0){
                            bd.execSQL("INSERT INTO Linea(codProducto,codPedido,cantidad) VALUES(10,'"+codigoPed+"','"+cantJamon+"')");
                        }
                        if(cantChatka>0){
                            bd.execSQL("INSERT INTO Linea(codProducto,codPedido,cantidad) VALUES(11,'"+codigoPed+"','"+cantChatka+"')");
                        }
                        if(cantSandia>0){
                            bd.execSQL("INSERT INTO Linea(codProducto,codPedido,cantidad) VALUES(12,'"+codigoPed+"','"+cantSandia+"')");
                        }
                        if(cantMelon>0){
                            bd.execSQL("INSERT INTO Linea(codProducto,codPedido,cantidad) VALUES(13,'"+codigoPed+"','"+cantMelon+"')");
                        }
                        if(cantPina>0){
                            bd.execSQL("INSERT INTO Linea(codProducto,codPedido,cantidad) VALUES(14,'"+codigoPed+"','"+cantPina+"')");
                        }
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
