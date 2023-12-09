package com.soft1;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/*
 * Creacion de la banda con sus respectivos miembros
 */

public class Banda {
    private String nombre;
    private String genero;
    private java.util.Date fechaCreacion;
    private List<String> fotos;
    private List<Miembro> miembros;

    /**
     *
     * @param nombre Ingresa el nombre de la banda
     * @param genero Ingresa el genero musical en la que se conforma
     * @param fechaCreacion2 Ingresa la fecha la creacion de la banda
     * @param fotos Atributo donde se va a guardar las fotos de los miembros de la banda
     */
    public Banda(String nombre, String genero, java.util.Date fechaCreacion2, List<String> fotos) {
        this.nombre  =nombre;
        this.genero = genero;
        this.fechaCreacion = fechaCreacion2;
        this.fotos = new ArrayList<>();
        this.miembros = new ArrayList<>();
    }

    /**
     *
     * @param miembro Agrega un mienbro de la banda a la lista
     */
    public void agregarMiembro(Miembro miembro){
        miembros.add(miembro);
    }

    /**
     *
     * @param miembro Elimina un miembro de la banda que haya sido expulsado
     */
    public void eliminarMiembro(Miembro miembro){
        miembros.remove(miembro);
    }

    /**
     *
     * @param nombre
     * @return
     */
    public Miembro buscarMiembroPorNombre(String nombre){
        for(Miembro miembro: miembros){
            if(miembro.getNombre().equals(nombre)){
                return miembro;
            }
        }
        return null;
    }

    /**
     *
     * @param miembrosActualizados Se ingresan los nuevos miembros de la banda y se verifica que no se hayan repetido.
     */
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
