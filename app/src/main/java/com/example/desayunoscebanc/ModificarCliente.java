package com.example.desayunoscebanc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class ModificarCliente extends AppCompatActivity {

    EditText editNombre,editContrasena,editTelefono,editEmail,editDireccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_cliente);

        editNombre=findViewById(R.id.editNombre);
        editContrasena=findViewById(R.id.editContrasena);
        editDireccion=findViewById(R.id.editDireccion);
        editEmail=findViewById(R.id.editEmail);
        editTelefono=findViewById(R.id.editNumero);

        Intent intent=getIntent();
        Cliente cliente=(Cliente)intent.getSerializableExtra("cliente");
        if (cliente != null) {
            editNombre.setText(cliente.getNombre());
        }
        editContrasena.setText(String.valueOf(cliente.getContrasena()));
        editDireccion.setText(cliente.getDireccion());
        editEmail.setText(cliente.getEmail());
        editTelefono.setText(cliente.getNumero());




    }
}
