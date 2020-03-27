package com.example.desayunoscebanc;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Actividad_admin extends AppCompatActivity {

    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_admin);

        lista=findViewById(R.id.lstClientes);

        final ArrayList<Cliente> listaCliente=new ArrayList<>();

        BDSQLiteHelper bdDesayunos = new BDSQLiteHelper(this, "BDDesayunos", null, 10);
        final SQLiteDatabase bd = bdDesayunos.getWritableDatabase();


        Cursor c=bd.rawQuery("SELECT CodCliente,Contrasena,Nombre,Direccion,Telefono,Email FROM Cliente",null);
        if(c.moveToFirst()){
            do{
                int codCliente=c.getInt(0);
                int contrasena=c.getInt(1);
                String nombre=c.getString(2);
                String direccion=c.getString(3);
                String telefono=c.getString(4);
                String email=c.getString(5);

                Cliente cli=new Cliente(codCliente,contrasena,nombre,direccion,telefono,email);
                listaCliente.add(cli);
            }while(c.moveToNext());
        }
        ClienteListAdapter adapter=new ClienteListAdapter(this,R.layout.cliente_adaptador,listaCliente);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });




    }
}
