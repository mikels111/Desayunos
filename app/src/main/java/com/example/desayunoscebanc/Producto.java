package com.example.desayunoscebanc;

public class Producto {
    private String nombre;
    private int cantidad;
    private double precio;

    public Producto(String nom,int cant,double pr){
        nombre=nom;
        precio=pr;
        cantidad=cant;
    }
    public Producto(){

    }

    public String getNombre(){
        return nombre;
    }

    public double getPrecio(){
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setNombre(String nom){
        nombre=nom;
    }

    public void setPrecio(int pr){
        precio=pr;
    }

    public void setCantidad(int cant){
        cantidad=cant;
    }


}
