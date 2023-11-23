package com.soft1;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Banda {
    private String genero;
    private Date fechaCreacion;
    private List<String> fotos;
    private List<Miembro> miembros;

    public Banda(String genero, Date fechaCreacion, List<String> fotos, List<Miembro> miembros) {
        this.genero = genero;
        this.fechaCreacion = fechaCreacion;
        this.fotos = new ArrayList<>();
        this.miembros = new ArrayList<>();
    }

    public void agregarMiembro(Miembro miembro){
        miembros.add(miembro);
    }

    public void eliminarMiembro(Miembro miembro){
        miembros.remove(miembro);
    }

    public Miembro buscarMiembroPorNombre(String nombre){
        for(Miembro miembro: miembros){
            if(miembro.getNombre().equals(nombre)){
                return miembro;
            }
        }
        return null;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<String> getFotos() {
        return fotos;
    }

    public void setFotos(List<String> fotos) {
        this.fotos = fotos;
    }

    public List<Miembro> getMiembros() {
        return miembros;
    }

    public void setMiembros(List<Miembro> miembros) {
        this.miembros = miembros;
    }


}
