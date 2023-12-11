package com.soft1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControlAlbum {

    private List<Album> albumes;

    public ControlAlbum() {
        this.albumes = new ArrayList<>();
    }

    public void registrarAlbum(Album album) {
        if (album == null) {
            throw new IllegalArgumentException("El album no puede ser null");
        }
        if (!albumes.contains(album)) {
            albumes.add(album);
        }
    }

    public Album buscarAlbum(String nombreAlbum) {
        return albumes.stream()
                .filter(album -> album.getNombre().equals(nombreAlbum))
                .findFirst()
                .orElse(null);
    }

    public Boolean buscarCancion(String nombreCancion, String nombreAlbum) {
        Album album = buscarAlbum(nombreAlbum);
        System.out.println("Validando" + album.getCanciones().contains(nombreCancion));
        return album.getCanciones().contains(nombreCancion);
    }

    public void agregarCanciones(Cancion cancion, String nombreAlbum){
        Album album = buscarAlbum(nombreAlbum);
        if (buscarCancion(cancion.getNombre(), nombreAlbum) == false){
            album.agregarCancion(cancion);
        }
    }

    public String consultarAlbum(String nombreAlbum) {
        for (Album album : albumes) {
            if (album.getNombre().equals(nombreAlbum)) {
                String cancionesStr = album.getCanciones().stream()
                    .map(cancion -> "Nombre: " + cancion.getNombre() + ", Duración: " + cancion.getDuracion() + " minutos")
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
