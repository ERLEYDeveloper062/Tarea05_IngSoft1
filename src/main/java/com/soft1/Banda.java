package com.soft1;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Banda {
    private String nombre;
    private String genero;
    private java.util.Date fechaCreacion;
    private List<String> fotos;
    private List<Miembro> miembros;

    public Banda(String nombre, String genero, java.util.Date fechaCreacion2, List<String> fotos) {
        this.nombre  =nombre;
        this.genero = genero;
        this.fechaCreacion = fechaCreacion2;
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

    public void actualizarMiembros(List<Miembro> miembrosActualizados){
        for(Miembro miembroActualizado : miembrosActualizados){
            Miembro miembroExistente = buscarMiembroPorNombre(miembroActualizado.getNombre());

            if(miembroExistente != null){
                miembroExistente.setNombre(miembroActualizado.getNombre());
                miembroExistente.setRol(miembroActualizado.getRol());
                miembroExistente.setInstrumentos(miembroActualizado.getInstrumentos());
            }else{
                agregarMiembro(miembroExistente);
            }
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public java.util.Date getFechaCreacion() {
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
