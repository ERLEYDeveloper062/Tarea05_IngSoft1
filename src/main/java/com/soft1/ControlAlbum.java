package com.soft1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControlAlbum {

    private List<Album> albumes;

    /*
     * Constructor inicial de ControlAlbum
     */
    public ControlAlbum() {
        this.albumes = new ArrayList<>();
    }

    /*
     * Añadir el album ya creado previamente a lista de albumes
     */
    public void registrarAlbum(Album album) {
        if (album == null) {
            throw new IllegalArgumentException("El album no puede ser null");
        }
        if (!albumes.contains(album)) {
            albumes.add(album);
        }
    }

    /*
     * Con el nombre del album, se busca en la lista de albumes
     * que exista alguno con ese nombre y lo retorna
     * 
     * @return
     * Retorna el objeto de Album que coincide con el nombre ingresado
     */
    public Album buscarAlbum(String nombreAlbum) {
        if (nombreAlbum == null){
            throw new IllegalArgumentException("El nombre no puede ser null");
        }else{
            return albumes.stream()
                .filter(album -> album.getNombre().equals(nombreAlbum))
                .findFirst()
                .orElse(null);
        }
    }

    /*
     * Con el nombre de la cancion y el nombre del album buscamos primero
     * el album que tenga el mismo nombre para con ese objeto buscar las 
     * canciones que tiene en su lista
     * 
     * @return
     * Retorna True o False si la cancion ya se encuentra o no en el album
     */
    public Boolean buscarCancion(String nombreCancion, String nombreAlbum) {
        Album album = buscarAlbum(nombreAlbum);
        if (album != null) {
            for (Cancion cancion : album.getCanciones()) {
                if (cancion.getNombre().equals(nombreCancion)) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * Con el objeto de cancion y el nombre del album se busca que en el album
     * no este agregada la cancion para poder agregarla
     */
    public void agregarCanciones(Cancion cancion, String nombreAlbum){
        Album album = buscarAlbum(nombreAlbum);
        if (buscarCancion(cancion.getNombre(), nombreAlbum) == false){
            album.agregarCancion(cancion);
        }
    }

    /*
     * Con el nombre del album buscamos el objeto para recorrer su lista de canciones
     * y añadir su informacion a un string, donde despues se añadira a un return con
     * la informacion del album
     * 
     * @return
     * Retorna toda la informacion del album con sus canciones
     */
    public String consultarAlbum(String nombreAlbum) {
        for (Album album : albumes) {
            if (album.getNombre().equals(nombreAlbum)) {
                String cancionesStr = album.getCanciones().stream()
                    .map(cancion -> "Nombre: " + cancion.getNombre() + ", Duración: " + 
                            cancion.getDuracion() + " minutos")
                    .collect(Collectors.joining("; "));

                return "Nombre: " + album.getNombre() +
                       ", Duración: " + album.getDuracion() + " minutos" +
                       ", Fecha de Creación: " + album.getFecha() +
                       ", Canciones: " + cancionesStr;
            }
        }
        return "Álbum no encontrado.";
    }

}
