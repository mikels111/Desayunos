package com.example.desayunoscebanc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.telephony.SmsManager;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Actividad_4 extends AppCompatActivity {
    Button aceptar;
    EditText contrasena,nombre,direccion,telefono,email;
    TextView prueba;
    public static final String DATE_FORMAT_2 = "dd-MM-yyyy HH:mm:ss";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_4);

       /*if(checkSelfPermission(Manifest.permission.SEND_SMS)==PackageManager.PERMISSION_GRANTED){

            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.SEND_SMS)){

            }else{

                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},123);
            }
        }*/


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
        //prueba=findViewById(R.id.textView27);

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
        BDSQLiteHelper bdDesayunos = new BDSQLiteHelper(this, "BDDesayunos", null, 11);
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
                    if(contrasena.getText().length()==0){
                        contrasena.setBackgroundResource(R.drawable.color_rojo);
                    }else{
                        contrasena.setBackgroundResource(R.drawable.color_gris);
                    }
                }
            }
        });

        nombre.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    if(nombre.getText().length()==0){
                        nombre.setBackgroundResource(R.drawable.color_rojo);
                    }else{
                        nombre.setBackgroundResource(R.drawable.color_gris);
                    }
                }
            }
        });
        telefono.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    if(telefono.getText().length()==0){
                        telefono.setBackgroundResource(R.drawable.color_rojo);
                    }else{
                        telefono.setBackgroundResource(R.drawable.color_gris);
                    }
                }
            }
        });

        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    if(email.getText().length()==0){
                        email.setBackgroundResource(R.drawable.color_rojo);
                    }else{
                        email.setBackgroundResource(R.drawable.color_gris);
                    }
                }
            }
        });

        direccion.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    if(direccion.getText().length()==0){
                        direccion.setBackgroundResource(R.drawable.color_rojo);
                    }else{
                        direccion.setBackgroundResource(R.drawable.color_gris);
                    }
                }
            }
        });

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(contrasena.getText().length()!=0 && direccion.getText().length()!=0 && telefono.getText().length()!=0 && email.getText().length()!=0){
                    Cursor c=bd.rawQuery("SELECT count(*) FROM Cliente WHERE Nombre='"+nombre.getText()+"' AND Contrasena='"+contrasena.getText()+"'",null);
                    c.moveToFirst();
                    int count=c.getInt(0);
                    int codigo;

                    SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_2);
                    dateFormat.setTimeZone(TimeZone.getTimeZone("CET"));
                    Date today = Calendar.getInstance().getTime();
                    //datetime('now','localtime')
                    if(count==0){
                        c=bd.rawQuery("SELECT count(*) FROM Cliente WHERE Nombre='"+nombre.getText()+"'",null);
                        c.moveToFirst();
                        int countNomb=c.getInt(0);
                        if(countNomb>0){
                            Toast t=Toast.makeText(getApplicationContext(), "Ese nombre ya existe", Toast.LENGTH_SHORT);
                            t.setGravity(Gravity.CENTER|Gravity.LEFT,320,40);
                            t.show();
                        }else{
                            bd.execSQL("INSERT INTO Cliente(Contrasena,Nombre,Direccion,Telefono,Email) VALUES('"+contrasena.getText()+"','"+nombre.getText()+"','"+direccion.getText()+"','"+telefono.getText()+"','"+email.getText()+"')");
                            c=bd.rawQuery("SELECT CodCliente FROM Cliente WHERE Nombre='"+nombre.getText()+"'",null);
                            c.moveToFirst();
                            codigo=c.getInt(0);
                            bd.execSQL("INSERT INTO Pedido(CodCliente,Total,FechaPed) VALUES('"+codigo+"','"+preciofinal+"','"+dateFormat.format(today)+"')");
                            //c=bd.rawQuery("SELECT codPedido FROM Pedido WHERE codCliente='"+codigo+"' AND FechaPed='"+dateFormat.format(today)+"'",null);
                            c=bd.rawQuery("SELECT codPedido,CodCliente,Total FROM Pedido WHERE codPedido = (SELECT MAX(codPedido) FROM Pedido WHERE codCliente = '"+codigo+"')",null);
                            c.moveToFirst();
                            int codigoPed=c.getInt(0);
                            int codCliente=c.getInt(1);
                            double total=c.getDouble(2);
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

                            //Control de la duración del Toast


                            Intent intent=new Intent(Actividad_4.this,MainActivity.class);

                            try{
                                String textoMsg="Pedido realizado "+codigoPed+", por el cliente "+codCliente+", fecha "+dateFormat.format(today)+". Importe total: "+total+". Gracias por su visita";

                                Intent intento=new Intent(Intent.ACTION_SEND);
                                intento.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getText().toString()});
                                intento.putExtra(Intent.EXTRA_SUBJECT, "Pedido Cebanc Desayunos");
                                intento.putExtra(Intent.EXTRA_TEXT, textoMsg);
                                intento.setType("message/rfc822");

                                finish();
                                startActivity(intent);
                                startActivity(intento.createChooser(intento,"Escoge una aplicación"));

                            }catch(Exception e){
                                Toast t=Toast.makeText(getApplicationContext(), "error en Email", Toast.LENGTH_SHORT);
                                t.show();
                            }
                        }


                    }else{


                        c=bd.rawQuery("SELECT CodCliente FROM Cliente WHERE Nombre='"+nombre.getText()+"'",null);
                        c.moveToFirst();
                        codigo=c.getInt(0);
                        bd.execSQL("INSERT INTO Pedido(CodCliente,total,FechaPed) VALUES('"+codigo+"','"+preciofinal+"','"+dateFormat.format(today)+"')");
                        //c=bd.rawQuery("SELECT codPedido FROM Pedido WHERE codCliente='"+codigo+"' AND FechaPed='"+dateFormat.format(today)+"'",null);
                        c=bd.rawQuery("SELECT codPedido,CodCliente,Total FROM Pedido WHERE codPedido = (SELECT MAX(codPedido) FROM Pedido WHERE codCliente = '"+codigo+"')",null);
                        c.moveToFirst();
                        int codigoPed=c.getInt(0);
                        int codCliente=c.getInt(1);
                        double total=c.getDouble(2);
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

                        Intent intent=new Intent(Actividad_4.this,MainActivity.class);

                        try{
                            String textoMsg="Pedido realizado "+codigoPed+", por el cliente "+codCliente+", fecha "+dateFormat.format(today)+". Importe total: "+total+". Gracias por su visita";

                            Intent intento=new Intent(Intent.ACTION_SEND);
                            intento.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getText().toString()});
                            intento.putExtra(Intent.EXTRA_SUBJECT, "Pedido Cebanc Desayunos");
                            intento.putExtra(Intent.EXTRA_TEXT, textoMsg);
                            intento.setType("message/rfc822");

                            finish();
                            startActivity(intent);
                            startActivity(intento.createChooser(intento,"Escoge una aplicación"));

                        }catch(Exception e){
                            Toast t=Toast.makeText(getApplicationContext(), "error en Email", Toast.LENGTH_SHORT);
                            t.show();
                        }

                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Le falta algún dato por rellenar", Toast.LENGTH_SHORT).show();
                }
                //Control de avisos de campos vacios
                if(contrasena.getText().length()==0){
                    contrasena.setBackgroundResource(R.drawable.color_rojo);
                }else{
                    contrasena.setBackgroundResource(R.drawable.color_gris);
                }
                if(nombre.getText().length()==0){
                    nombre.setBackgroundResource(R.drawable.color_rojo);
                }else{
                    nombre.setBackgroundResource(R.drawable.color_gris);
                }
                if (direccion.getText().length()==0){
                    direccion.setBackgroundResource(R.drawable.color_rojo);
                }else{
                    direccion.setBackgroundResource(R.drawable.color_gris);
                }
                if(telefono.getText().length()==0){
                    telefono.setBackgroundResource(R.drawable.color_rojo);
                }else{
                    telefono.setBackgroundResource(R.drawable.color_gris);
                }
                if(email.getText().length()==0){
                    email.setBackgroundResource(R.drawable.color_rojo);
                }else{
                    email.setBackgroundResource(R.drawable.color_gris);
                }
            }
        });

    }
}
