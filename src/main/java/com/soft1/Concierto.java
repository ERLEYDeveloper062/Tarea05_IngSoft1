package com.soft1;

import java.sql.Date;
import java.util.List;

/**
 * Clase para guardar informacion de los conciertos.
 */
public class Concierto {
    private String nombre;
    private java.util.Date fecha;
    private List<Cancion> canciones;
    private int boletosVendidos;


    /**
     *
     * Constructor de concierto.
     *
     * @param nombre Ingresa el nombre del concierto
     * @param date   Ingresa la fecha de realización.
     */
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
     * Actualizar la lista de canciones.
     *
     * @param canciones Ingresa una lista de canciones y se van actualizando.
     */
    public void setListaDeCanciones(List<Cancion> canciones){
        this.canciones = canciones;
    }

    /**
     *
     * Registra la cantidad de boletos que se vendieron en un concierto.
     *
     * @param boletosVendidos Ingresa la cantidad de boletos que se vendieron y los registra.
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
