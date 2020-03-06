package com.example.desayunoscebanc;

public class Bebida {
    String nombre;
    int cantidad;
    public Bebida(String nom,int cant){
        nombre=nom;
        cantidad=cant;
    }

    public String getNombre(){
        return nombre;
    }
    public int getCantidad(){
        return cantidad;
    }
    public void setNombre(String n){
        nombre=n;
    }
    public void setCantidad(int cant){
        cantidad=cant;
    }


}
