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
import android.widget.EditText;
import android.widget.Toast;

public class InsertarCliente extends AppCompatActivity {

    Button insertar;
    EditText editNombre,editContrasena,editDireccion,editEmail,editTelefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_cliente);

        //color en las barras
        getWindow().setStatusBarColor(Color.parseColor("#21A5C5"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#21A5C5")));

        //Base de Datos
        BDSQLiteHelper bdDesayunos = new BDSQLiteHelper(this, "BDDesayunos", null, 11 );
        final SQLiteDatabase bd = bdDesayunos.getWritableDatabase();

        insertar=findViewById(R.id.btnInsertarCliente);
        //editViews
        {
            editNombre=findViewById(R.id.editNombre);
            editContrasena=findViewById(R.id.editContrasena);
            editDireccion=findViewById(R.id.editDireccion);
            editEmail=findViewById(R.id.editEmail);
            editTelefono=findViewById(R.id.editNumero);
        }
        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editEmail.getText().length()!=0 && editTelefono.getText().length()!=0 && editDireccion.getText().length()!=0 && editNombre.getText().length()!=0 && editContrasena.getText().length()!=0){

                    Cursor c=bd.rawQuery("SELECT count(*) FROM Cliente WHERE Nombre='"+editNombre.getText()+"' AND contrasena='"+editContrasena.getText()+"' AND direccion='"+editDireccion.getText()+"' AND email='"+editEmail.getText()+"' AND telefono='"+editTelefono.getText()+"'",null);
                    c.moveToFirst();
                    int count=c.getInt(0);
                    if(count>0){
                        Toast aviso = Toast.makeText(getApplicationContext(), "Ese cliente ya está registrado", Toast.LENGTH_SHORT);
                        aviso.show();
                    }else{
                        c=bd.rawQuery("SELECT COUNT(*) FROM Cliente WHERE Nombre='"+editNombre.getText()+"'",null);
                        int cont;
                        if(c.moveToFirst()){
                            do{
                                cont=c.getInt(0);
                                if(cont>0){
                                    Toast aviso = Toast.makeText(getApplicationContext(), "Ese nombre ya existe", Toast.LENGTH_SHORT);
                                    aviso.show();
                                }else{
                                    try {
                                        bd.execSQL("INSERT INTO Cliente(Contrasena,Nombre,Direccion,Telefono,Email) VALUES('"+editContrasena.getText()+"','"+editNombre.getText()+"','"+editDireccion.getText()+"','"+editTelefono.getText()+"','"+editEmail.getText()+"')");
                                    }catch(Exception e){
                                        Toast aviso = Toast.makeText(getApplicationContext(), "Error al insertar cliente", Toast.LENGTH_SHORT);
                                        aviso.show();
                                    }
                                    Intent intent=new Intent(InsertarCliente.this,Actividad_admin.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }while(c.moveToNext());
                        }
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Le falta algún dato por rellenar", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
