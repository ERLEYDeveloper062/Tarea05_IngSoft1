package com.soft1;

import java.util.HashSet;
import java.util.Set;

public class Miembro {
    private String nombre;
    private String rol;
    private Set<Instrumento> instrumentos;

    public Miembro(String nombre, String rol, Set<Instrumento> instrumentos) {
        this.nombre = nombre;
        this.rol = rol;
        this.instrumentos = new HashSet<>(instrumentos);
    }

    public void agregarInstrumento(Instrumento instrumento){
        this.instrumentos.add(instrumento);
    }

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
