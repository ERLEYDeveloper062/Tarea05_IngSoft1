package com.soft1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Album {
    private String nombre;
    private Date fecha;
    private double duracion;
    private List<Cancion> canciones;

    public Album(String nombre, Date fecha, List<Cancion> canciones) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.duracion = 0;
        this.canciones = new ArrayList<>(canciones);

        duracionAlbum();
    }

    public void agregarCancion(Cancion cancion){
        this.canciones.add(cancion);
        duracionAlbum();
    }

    public void duracionAlbum(){
        double duracionTotal = 0;
        for (Cancion cancion : canciones) {
            duracionTotal += cancion.getDuracion();
        }
        setDuracion(duracionTotal);
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }
}
