package org.example;

public class Carta {
    private String nombre;
    private String tipo;
    private int cantidad;


    public Carta(String nombre, String tipo, int cantidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad(){return cantidad;}

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    
    public String toString(){
        return "Carta{ nombre =" +nombre + "tipo= " + tipo + " cantidad= " +cantidad;}


}
