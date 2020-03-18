package com.example.desayunoscebanc;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.PreparedStatement;

import androidx.annotation.Nullable;

public class BDSQLiteHelper extends SQLiteOpenHelper {

    String cliente="CREATE TABLE Cliente(" +
            "CodCliente INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Contrasena VARCHAR(25) ," +
            "Nombre VARCHAR(30)," +
            "Direccion VARCHAR(20)," +
            "Telefono VARCHAR(9)," +
            "Email VARCHAR(50)," +
            "UNIQUE(Nombre))";

    String producto="CREATE TABLE Producto(" +
            "CodProducto INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Nombre VARCHAR(40)," +
            "Precio DOUBLE(2,2))";

    String pedido="CREATE TABLE Pedido(" +
            "CodPedido INTEGER PRIMARY KEY AUTOINCREMENT," +
            "CodCliente INTEGER," +
            "Total INTEGER," +
            "FechaPed DATETIME," +
            "FOREIGN KEY(CodCliente) REFERENCES Cliente(CodCliente))";

    String linea="CREATE TABLE Linea(" +
            "CodLinea INTEGER PRIMARY KEY AUTOINCREMENT," +
            "CodProducto INTEGER," +
            "CodPedido INTEGER," +
            "FOREIGN KEY(CodProducto) REFERENCES Producto(CodProducto)," +
            "FOREIGN KEY(CodPedido) REFERENCES Pedido(CodPedido))";
    public void onCreate(SQLiteDatabase bd){

        bd.execSQL(cliente);
        bd.execSQL(producto);
        bd.execSQL(pedido);
        bd.execSQL(linea);

    }

    public BDSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int oldVersion, int newVersion) {
        if(oldVersion<8){
            bd.execSQL("DROP TABLE IF EXISTS Cliente");
            bd.execSQL("DROP TABLE IF EXISTS Producto");
            bd.execSQL("DROP TABLE IF EXISTS Pedido");
            bd.execSQL("DROP TABLE IF EXISTS Linea");
            onCreate(bd);
            bd.execSQL("INSERT INTO Cliente(Contrasena,Nombre,Direccion,Telefono,Email) VALUES('1234','Antonio','Calle Zubieta','943875621','antonio11@gmail.com');");
        }


    }
}
