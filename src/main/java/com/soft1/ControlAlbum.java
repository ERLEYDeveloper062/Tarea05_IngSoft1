package com.soft1;

public class ControlAlbum {

    private List<Album> albumes;

    public ControlAlbum() {
        this.albumes = new ArrayList<>();
    }

    public Banda buscarAlbum(String nombreAlbum) {
        return albumes.stream()
                .filter(album -> albumes.getNombre().equals(nombreAlbum))
                .findFirst()
                .orElse(null);
    }

    public Banda buscarCancion(String nombreCancion) {
        return canciones.stream()
                .filter(cancion -> cancion.getNombre().equals(nombreCancion))
                .findFirst()
                .orElse(null);
    }

    public void agregarCanciones(String nombreCancion, String nombreAlbum){
        private Cancion cancion = buscarCancion(nombreCancion);
        private Album album = 

        
    }
    
}
