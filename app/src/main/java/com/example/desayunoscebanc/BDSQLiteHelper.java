package com.example.desayunoscebanc;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.PreparedStatement;

import androidx.annotation.Nullable;

public class BDSQLiteHelper extends SQLiteOpenHelper {


    public void onCreate(SQLiteDatabase bd){

        bd.execSQL("CREATE TABLE Cliente(" +
                "CodCliente INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Direccion VARCHAR(20)," +
                "Telefono VARCHAR(9)," +
                "Email VARCHAR(50))");

        bd.execSQL("CREATE TABLE Producto(" +
                "CodProducto INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Nombre VARCHAR(40)," +
                "Precio DOUBLE(2,2))");

        bd.execSQL("CREATE TABLE Pedido(" +
                "CodPedido INTEGER PRIMARY KEY AUTOINCREMENT," +
                "CodCliente INTEGER," +
                "Total INTEGER," +
                "FechaPed DATE," +
                "HoraPed TIME," +
                "FOREIGN KEY(CodCliente) REFERENCES Cliente(CodCliente))");

        bd.execSQL("CREATE TABLE Linea(" +
                "CodLinea INTEGER PRIMARY KEY AUTOINCREMENT," +
                "CodProducto INTEGER," +
                "CodPedido INTEGER," +
                "FOREIGN KEY(CodProducto) REFERENCES Producto(CodProducto)," +
                "FOREIGN KEY(CodPedido) REFERENCES Pedido(CodPedido))");

    }

    public BDSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
