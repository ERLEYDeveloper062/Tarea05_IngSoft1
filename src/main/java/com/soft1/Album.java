package com.soft1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase para guardar info de Álbumes
 * con su respectivo nombre, fecha de lanzamiento, duración y lista de canciones.
 */
public class Album {
    private String nombre;
    private Date fecha;
    private double duracion;
    private List<Cancion> canciones;

    /**
     * Crea un álbum con los datos dados.
     * @param nombre El nombre del álbum.
     * @param fecha La fecha de lanzamiento del álbum.
     * @param canciones La lista de canciones del álbum.
     */

    public Album(String nombre, Date fecha, List<Cancion> canciones) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.duracion = 0;
        this.canciones = new ArrayList<>(canciones);

        duracionAlbum();
    }

    /**
     * Agrega una canción con su duración.
     * @param cancion La canción a agregar.
     */
    public void agregarCancion(Cancion cancion){
        this.canciones.add(cancion);
        duracionAlbum();
    }

    /**
     * Calcula la duración total del álbum.
     * Se recorre la lista de canciones y se suma la duración de cada una.
     */
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

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

}
