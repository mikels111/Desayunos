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
            "Cantidad INTEGER," +
            "FOREIGN KEY(CodProducto) REFERENCES Producto(CodProducto)," +
            "FOREIGN KEY(CodPedido) REFERENCES Pedido(CodPedido))";
    public void onCreate(SQLiteDatabase bd){

        bd.execSQL(cliente);
        bd.execSQL(producto);
        bd.execSQL(pedido);
        bd.execSQL(linea);
        bd.execSQL("INSERT INTO Producto(Nombre,Precio) VALUES('Cafe',1.0)");
        bd.execSQL("INSERT INTO Producto(Nombre,Precio) VALUES('Te',0.70)");
        bd.execSQL("INSERT INTO Producto(Nombre,Precio) VALUES('Infusion',0.80)");
        bd.execSQL("INSERT INTO Producto(Nombre,Precio) VALUES('Cacao',1.25)");
        bd.execSQL("INSERT INTO Producto(Nombre,Precio) VALUES('Agua',0.60)");
        bd.execSQL("INSERT INTO Producto(Nombre,Precio) VALUES('Bollo Suizo',1.90)");
        bd.execSQL("INSERT INTO Producto(Nombre,Precio) VALUES('Croissant',2)");
        bd.execSQL("INSERT INTO Producto(Nombre,Precio) VALUES('Bizcocho',2)");
        bd.execSQL("INSERT INTO Producto(Nombre,Precio) VALUES('Tortilla',2.60)");
        bd.execSQL("INSERT INTO Producto(Nombre,Precio) VALUES('jamon',2.80)");
        bd.execSQL("INSERT INTO Producto(Nombre,Precio) VALUES('Chatka',2.80)");
        bd.execSQL("INSERT INTO Producto(Nombre,Precio) VALUES('Sandia',1)");
        bd.execSQL("INSERT INTO Producto(Nombre,Precio) VALUES('Melon',1)");
        bd.execSQL("INSERT INTO Producto(Nombre,Precio) VALUES('Piña',1)");
        bd.execSQL("INSERT INTO Cliente(Contrasena,Nombre,Direccion,Telefono,Email) VALUES('1234','Antonio','Calle Zubieta','943875621','antonio11@gmail.com');");

    }

    public BDSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int oldVersion, int newVersion) {
        if(oldVersion<10){
            bd.execSQL("DROP TABLE IF EXISTS Cliente");
            bd.execSQL("DROP TABLE IF EXISTS Producto");
            bd.execSQL("DROP TABLE IF EXISTS Pedido");
            bd.execSQL("DROP TABLE IF EXISTS Linea");
            onCreate(bd);
        }


    }
}
