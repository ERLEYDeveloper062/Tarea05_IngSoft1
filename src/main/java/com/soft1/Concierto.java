package com.soft1;

import java.sql.Date;
import java.util.List;

/**
 *
 */
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

    public List <Cancion> getCanciones(){
        return this.canciones;
    }

    public java.util.Date getfecha(){
        return this.fecha;
    }

    /**
     *
     * @param canciones
     */
    public void setListaDeCanciones(List<Cancion> canciones){
        this.canciones = canciones;
    }

    /**
     *
     * @param boletosVendidos
     */
    public void registrarBoletosVendidos(int boletosVendidos){
        this.boletosVendidos = boletosVendidos;
    }

    /**
     *Obtiene los boletos que se hayan vendido en el concierto
     * @return la cantidad de boletos vendidos
     */
    public int getBoletosVendidos(){
        return boletosVendidos;
    }
}
