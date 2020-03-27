package com.example.desayunoscebanc;

public class Cliente {
    private int codCliente;
    private int contrasena;
    private String nombre;
    private String direccion;
    private String numero;
    private String email;
    public Cliente(int codCli,int contra,String nomb,String direc,String num,String correo){
        codCliente=codCli;
        contrasena=contra;
        nombre=nomb;
        direccion=direc;
        numero=num;
        email=correo;
    }
    public int getCodCliente(){
        return codCliente;
    }
    public int getContrasena(){
        return contrasena;
    }
    public String getNombre(){
        return  nombre;
    }
    public String getDireccion(){
        return direccion;
    }
    public String getNumero(){
        return numero;
    }
    public String getEmail(){
        return email;
    }
    public void setCodCliente(int cod){
        codCliente=cod;
    }
    public void setContrasena(int contr){
        contrasena=contr;
    }
    public void setNombre(String nom){
        nombre=nom;
    }
    public void setDireccion(String direc){
        direccion=direc;
    }
    public void setNumero(String num){
        numero=num;
    }
    public void setEmail(String correo){
        email=correo;
    }
}
