package com.example.desayunoscebanc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Actividad_admin extends AppCompatActivity{

    ListView lista;
    TextView prueba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_admin);

        //color en las barras
        getWindow().setStatusBarColor(Color.parseColor("#21A5C5"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#21A5C5")));

        lista=findViewById(R.id.lstClientes);

        ArrayList<Cliente> listaCliente=new ArrayList<>();

        //Base de Datos
        BDSQLiteHelper bdDesayunos = new BDSQLiteHelper(this, "BDDesayunos", null, 11);
        final SQLiteDatabase bd = bdDesayunos.getWritableDatabase();


        Cursor cursor=bd.rawQuery("SELECT CodCliente,Contrasena,Nombre,Direccion,Telefono,Email FROM Cliente",null);
        if(cursor.moveToFirst()){
            do{
                int codCliente=cursor.getInt(0);
                int contrasena=cursor.getInt(1);
                String nombre=cursor.getString(2);
                String direccion=cursor.getString(3);
                String telefono=cursor.getString(4);
                String email=cursor.getString(5);

                Cliente cli=new Cliente(codCliente,contrasena,nombre,direccion,telefono,email);
                listaCliente.add(cli);
            }while(cursor.moveToNext());
        }
        cursor.close();

        ClienteListAdapter adapter=new ClienteListAdapter(this,R.layout.cliente_adaptador,listaCliente);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(Actividad_admin.this,ModificarCliente.class);
                Cliente obj=(Cliente)parent.getAdapter().getItem(position);
                //Cliente cli=new Cliente(obj);
                intent.putExtra("cliente",obj);
                startActivity(intent);
                finish();
            }
        });




    }
}
