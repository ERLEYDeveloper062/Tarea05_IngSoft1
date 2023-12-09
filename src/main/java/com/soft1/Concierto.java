package com.soft1;

import java.sql.Date;
import java.util.List;

public class Concierto {
    private String nombre;
    private java.util.Date fecha;
    private List<Cancion> canciones;
    private int boletosVendidos;

    public Concierto(String nombre, java.util.Date date){
        this.nombre = nombre;
        this.fecha = date;
    }

    public String getNombre(){
        return this.nombre;
    }

    public java.util.Date getfecha(){
        return this.fecha;
    }

    public void setListaDeCanciones(List<Cancion> canciones){
        this.canciones = canciones;
    }

    public void registrarBoletosVendidos(int boletosVendidos){
        this.boletosVendidos = boletosVendidos;
    }

    public int getBoletosVendidos(){
        return boletosVendidos;
    }
}
