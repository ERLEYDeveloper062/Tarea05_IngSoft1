package com.soft1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;


public class ControlAlbumTest {
    
    @Test
    void registrarAlbum(){
        Cancion cancion1 = new Cancion("cancion1", 3.1);
        Album album1 = new Album("AlbumPrueba1", new Date(123,1,2), Arrays.asList(cancion1));
        ControlAlbum controlAlbum1 = new ControlAlbum();

        controlAlbum1.registrarAlbum(album1);
        assertNotNull(album1);
    }

    @Test
    void buscarAlbum(){
        Cancion cancion1 = new Cancion("cancion1", 3.1);
        Album album1 = new Album("AlbumPrueba1", new Date(123,1,2), Arrays.asList(cancion1));
        ControlAlbum controlAlbum1 = new ControlAlbum();
        controlAlbum1.registrarAlbum(album1);

        Album resultado = controlAlbum1.buscarAlbum("AlbumPrueba1");
        assertNotNull(resultado);
  
    }

    @Test
    void buscarCancionNoExiste(){
        Cancion cancion1 = new Cancion("cancion1", 3.1);
        Album album1 = new Album("AlbumPrueba1", new Date(123,1,2), Arrays.asList(cancion1));
        ControlAlbum controlAlbum1 = new ControlAlbum();
        controlAlbum1.registrarAlbum(album1);

        boolean resultado = controlAlbum1.buscarCancion("cancion1", "AlbumPrueba1");
        assertTrue(resultado);
    }

    @Test
    void buscarCancionSiExiste(){
        Cancion cancion1 = new Cancion("cancion1", 3.1);
        Album album1 = new Album("AlbumPrueba1", new Date(123,1,2), Arrays.asList(cancion1));
        ControlAlbum controlAlbum1 = new ControlAlbum();
        controlAlbum1.registrarAlbum(album1);

        boolean resultado = controlAlbum1.buscarCancion("cancion2", "AlbumPrueba1");
        assertFalse(resultado);
    }

    @Test
    void agregarCanciones(){
        Cancion cancion1 = new Cancion("cancion1", 3.1);
        Album album1 = new Album("AlbumPrueba1", new Date(123,1,2), Arrays.asList(cancion1));
        ControlAlbum controlAlbum1 = new ControlAlbum();
        controlAlbum1.registrarAlbum(album1);

        controlAlbum1.agregarCanciones(cancion1, "AlbumPrueba1");
    }

    @Test
    void consultarAlbum(){
        Cancion cancion1 = new Cancion("cancion1", 3.1);
        Album album1 = new Album("AlbumPrueba1", new Date(123,1,2), Arrays.asList(cancion1));
        ControlAlbum controlAlbum1 = new ControlAlbum();
        controlAlbum1.registrarAlbum(album1);

        String resultado = controlAlbum1.consultarAlbum("AlbumPrueba1");
        assertNotNull(resultado);
    }

    @Test
    void consultarAlbumNoExiste(){
        Cancion cancion1 = new Cancion("cancion1", 3.1);
        Album album1 = new Album("AlbumPrueba1", new Date(123,1,2), Arrays.asList(cancion1));
        ControlAlbum controlAlbum1 = new ControlAlbum();
        controlAlbum1.registrarAlbum(album1);

        String resultado = controlAlbum1.consultarAlbum("AlbumPrueba2");
        assertEquals("Álbum no encontrado.", resultado);    
    }
}
