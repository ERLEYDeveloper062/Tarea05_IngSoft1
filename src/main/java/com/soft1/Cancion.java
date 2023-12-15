package com.soft1;

/**
 * Clase para guardar info de Canciones
 * con su respectivo nombre y duracion.
 */
public class Cancion {

    private String nombre;
    private double duracion;

    /**
     *
     * Constructor de Cancion.
     *
     * @param nombre    Ingresa el nombre de la cancion.
     * @param duracion  Ingresa la duracion.
     */
    public Cancion(String nombre, double duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }



}
