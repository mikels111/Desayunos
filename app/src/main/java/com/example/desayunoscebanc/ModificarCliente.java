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

public class ModificarCliente extends AppCompatActivity {

    EditText editNombre,editContrasena,editTelefono,editEmail,editDireccion;
    Button aceptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_cliente);

        //color en las barras
        getWindow().setStatusBarColor(Color.parseColor("#21A5C5"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#21A5C5")));

        //Base de Datos
        BDSQLiteHelper bdDesayunos = new BDSQLiteHelper(this, "BDDesayunos", null, 11);
        final SQLiteDatabase bd = bdDesayunos.getWritableDatabase();

        editNombre=findViewById(R.id.editNombre);
        editContrasena=findViewById(R.id.editContrasena);
        editDireccion=findViewById(R.id.editDireccion);
        editEmail=findViewById(R.id.editEmail);
        editTelefono=findViewById(R.id.editNumero);

        aceptar=findViewById(R.id.btnAceptar);

        Intent intent=getIntent();
        Cliente cliente=(Cliente)intent.getSerializableExtra("cliente");

        if (cliente != null) {
            editNombre.setText(cliente.getNombre());
        }
        editContrasena.setText(String.valueOf(cliente.getContrasena()));
        editDireccion.setText(cliente.getDireccion());
        editEmail.setText(cliente.getEmail());
        editTelefono.setText(cliente.getNumero());

        final int codCliente=cliente.getCodCliente();

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c=bd.rawQuery("SELECT count(*) FROM Cliente WHERE Nombre='"+editNombre.getText()+"' AND contrasena='"+editContrasena.getText()+"' AND direccion='"+editDireccion.getText()+"' AND email='"+editEmail.getText()+"' AND telefono='"+editTelefono.getText()+"'",null);
                c.moveToFirst();
                int count=c.getInt(0);
                if(count>0){
                    Toast aviso = Toast.makeText(getApplicationContext(), "Ese cliente ya está registrado", Toast.LENGTH_SHORT);
                    aviso.show();
                }else{
                    /*c=bd.rawQuery("SELECT count(*) FROM Cliente WHERE Nombre='"+editNombre.getText()+"'",null);
                    c.moveToFirst();
                    int count2=c.getInt(0);*/

                    try {
                        bd.execSQL("UPDATE Cliente SET nombre='" + editNombre.getText() + "'," +
                                "contrasena='" + editContrasena.getText() + "'," +
                                "direccion='" + editDireccion.getText() + "'," +
                                "email='" + editEmail.getText() + "'," +
                                "telefono='" + editTelefono.getText() + "'WHERE codCliente=" + codCliente + "");
                    }catch(Exception e){
                        Toast aviso = Toast.makeText(getApplicationContext(), "Ese nombre de producto ya existe", Toast.LENGTH_SHORT);
                        aviso.show();
                    }

                    Intent intent=new Intent(ModificarCliente.this,Actividad_admin.class);
                    startActivity(intent);
                    finish();
                }

            }
        });




    }
}
