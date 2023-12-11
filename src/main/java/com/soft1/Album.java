package com.soft1;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Album {
    private String nombre;
    private Date fecha;
    private float duracion;
    private List<Cancion> canciones;

    public Album(String nombre, Date fecha, float duracion, List<Cancion> canciones) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.duracion = duracion;
        this.canciones = canciones;
    }

    public void agregarCancion(Cancion cancion){
        this.canciones.add(cancion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    
    
}
