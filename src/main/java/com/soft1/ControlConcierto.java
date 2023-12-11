package com.soft1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class ControlConcierto {
    private Map<String, Concierto> conciertos;

    public ControlConcierto() {
        conciertos = new HashMap<>();
    }

    /**
     *
     * @param nombre
     * @param canciones
     */
    public void seleccionarConcierto(String nombre, List<Cancion> canciones) {
        for (Concierto concierto : conciertos.values()) {
            if (concierto.getNombre().equals(nombre)) {
                conciertos.get(nombre).setListaDeCanciones(canciones);
            }
        }
    }

    /**
     *
     * @param nombre
     * @param boletosVendidos
     */
    public void registrarBoletosVendidos(String nombre, int boletosVendidos) {
        for (Concierto concierto : conciertos.values()) {
            if (concierto.getNombre().equals(nombre)) {
                conciertos.get(nombre).registrarBoletosVendidos(boletosVendidos);
            }
        }
    }

    /**
     *
     */
    public void consultarConciertos() {
        for (Concierto concierto : conciertos.values()) {
            System.out.println("Concierto: " + concierto.getNombre() +
                    "Fecha: " + concierto.getfecha() +
                    "Boletos Vendidos: " + concierto.getBoletosVendidos());
        }
    }

    /**
     *
     * @param concierto
     */
    public void agregarConcierto(Concierto concierto) {
        if (conciertos == null) {
            throw new NullPointerException("La lista de conciertos es vacía");
        }
        conciertos.put(concierto.getNombre(), concierto);
    }

    /**
     *
     * @param nombreConcierto
     * @return
     */
    public Concierto getConciertoPorNombre(String nombreConcierto) {
        if (conciertos.containsKey(nombreConcierto)) {
            return conciertos.get(nombreConcierto);
        } else {
            throw new NoSuchElementException("No se encontró el concierto con nombre: " + nombreConcierto);
            // O podrías devolver null o algún otro valor que indique la ausencia del
            // concierto.
        }
    }

    /**
     *
     * @param nombreConcierto
     * @return
     */
    public List<Cancion> getCancionesPorConcierto(String nombreConcierto) {
        for (Concierto concierto : conciertos.values()) {
            if (concierto.getNombre().equals(nombreConcierto)) {
                return conciertos.get(nombreConcierto).getCanciones();
            } else {
                throw new IllegalArgumentException("No se encontraron canciones para el concierto: " + nombreConcierto);
            }
        }
        return null;
    }

}
