package com.soft1;

import java.util.HashSet;
import java.util.Set;

/**
 * Clase para crear un miembro de la banda.
 * Con su respectivo nombre, rol y los instrumentos que toca.
 */

public class Miembro {
    private String nombre;
    private String rol;
    private Set<Instrumento> instrumentos;

    /**
     *
     * Constructor de Mienbro
     *
     * @param nombre        Ingresa el nombre del mienbro de la banda.
     * @param rol           Ingresa el rol que va a desempeñar.
     * @param instrumentos  Ingresa que instrumentos tóca.
     */
    public Miembro(String nombre, String rol, Set<Instrumento> instrumentos) {
        this.nombre = nombre;
        this.rol = rol;
        this.instrumentos = new HashSet<>(instrumentos);
    }

    /**
     * Agrega un instrumento a la lista.
     * @param instrumento ingresa un instrumento.
     */
    public void agregarInstrumento(Instrumento instrumento){
        this.instrumentos.add(instrumento);
    }

    /**
     * Elimina un instrumento de la lista.
     * @param instrumento ingresa un instrumento.
     */
    public void eliminarInstrumento(Instrumento instrumento) {
        this.instrumentos.remove(instrumento);
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return rol;
    }

    public Set<Instrumento> getInstrumentos() {
        return instrumentos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setInstrumentos(Set<Instrumento> instrumentos) {
        this.instrumentos = instrumentos;
    }
}
