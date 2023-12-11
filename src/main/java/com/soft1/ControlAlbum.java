package com.soft1;

import java.util.ArrayList;
import java.util.List;

public class ControlAlbum {

    private List<Album> albumes;

    public ControlAlbum() {
        this.albumes = new ArrayList<>();
    }

    public Album buscarAlbum(String nombreAlbum) {
        return albumes.stream()
                .filter(album -> album.getNombre().equals(nombreAlbum))
                .findFirst()
                .orElse(null);
    }

    public Boolean buscarCancion(String nombreCancion, String nombreAlbum) {
        Album album = buscarAlbum(nombreAlbum);
        return album.getCanciones().contains(nombreCancion);
    }

    public void agregarCanciones(Cancion cancion, String nombreAlbum){
        Album album = buscarAlbum(nombreAlbum);
        if (buscarCancion(cancion.getNombre(), nombreAlbum) == false){
            album.agregarCancion(cancion);
        }
    }

}
