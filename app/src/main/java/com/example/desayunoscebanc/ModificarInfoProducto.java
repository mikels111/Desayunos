package com.example.desayunoscebanc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ModificarInfoProducto extends AppCompatActivity {
    TextView prueba;
    EditText editNombre, editPrecio;
    Button btnAceptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_info_producto);

        //color en las barras
        getWindow().setStatusBarColor(Color.parseColor("#21A5C5"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#21A5C5")));

        editNombre =findViewById(R.id.editNombre);
        editPrecio =findViewById(R.id.editPrecio);
        btnAceptar=findViewById(R.id.btnAceptar);

        Intent intent=getIntent();
        final String producto=intent.getStringExtra("producto");
        prueba=findViewById(R.id.textView57);
        prueba.setText(producto);

        //Base de Datos
        BDSQLiteHelper bdDesayunos = new BDSQLiteHelper(this, "BDDesayunos", null, 11);
        final SQLiteDatabase bd = bdDesayunos.getWritableDatabase();


        Cursor c = bd.rawQuery("SELECT CodProducto,Nombre,Precio FROM Producto WHERE Nombre='" + producto + "'", null);
        c.moveToFirst();
        final int codProducto=c.getInt(0);
        String nomb = c.getString(1);
        Double precio = c.getDouble(2);

        editNombre.setText(nomb);
        editPrecio.setText(precio.toString());
        c.close();

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Cursor c=bd.rawQuery("SELECT COUNT(*) FROM Producto WHERE Nombre='"+editNombre.getText()+"' AND Precio="+editPrecio.getText()+"",null);
               c.moveToFirst();
               int count=c.getInt(0);
               if(count>0){
                   Toast aviso = Toast.makeText(getApplicationContext(), "Ese producto ya está registrado", Toast.LENGTH_SHORT);
                   aviso.show();
               }else{
                   try {
                       bd.execSQL("UPDATE Producto SET Nombre='"+editNombre.getText()+"', Precio="+editPrecio.getText()+" WHERE CodProducto="+codProducto+"");
                   }catch(SQLiteException e){
                       Toast aviso = Toast.makeText(getApplicationContext(), "Ese nombre ya existe", Toast.LENGTH_SHORT);
                       aviso.show();
                   }

               }
                Intent intent=new Intent(ModificarInfoProducto.this,Admin_productos.class);
                startActivity(intent);
                finish();

            }
        });


    }
}
