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
    EditText codigo,direccion,telefono,email;
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
        codigo=findViewById(R.id.editCodigo);
        direccion=findViewById(R.id.editDireccion);
        telefono=findViewById(R.id.editTelefono);
        email=findViewById(R.id.editEmail);

        prueba=findViewById(R.id.txtPrueba);

        //Base de Datos
        BDSQLiteHelper bdDesayunos = new BDSQLiteHelper(this, "BDDesayunos", null, 1);
        final SQLiteDatabase bd = bdDesayunos.getWritableDatabase();

        codigo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    prueba.setText("prueba");
                    Cursor c=bd.rawQuery("SELECT CodCliente,Direccion,Telefono,Email FROM Cliente WHERE CodCliente='"+codigo.getText()+"'",null);

                    if(c.moveToFirst()){
                        do {
                            direccion.setText(c.getString(1));
                            telefono.setText(c.getString(2));
                            email.setText(c.getString(3));
                        }while(c.moveToNext());
                    }
                }
            }
        });


        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(codigo.getText().length()!=0 && direccion.getText().length()!=0 && telefono.getText().length()!=0 && email.getText().length()!=0){

                }else if(codigo.getText().length()==0){
                    Toast.makeText(getApplicationContext(), "Le falta introducir el código", Toast.LENGTH_SHORT).show();

                }else if (direccion.getText().length()==0){
                    Toast.makeText(getApplicationContext(), "Le falta introducir la dirección", Toast.LENGTH_SHORT).show();
                }else if(telefono.getText().length()==0){
                    Toast.makeText(getApplicationContext(), "Le falta introducir el teléfono", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Le falta introducir el Email", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
