package com.soft1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Clase con la lógica de los conciertos, que realiza
 * las validaciones y operaciones necesarias en cada
 * funcionalidad antes de hacer cambios en los datos.
 */

public class ControlConcierto {
    private Map<String, Concierto> conciertos;

    public ControlConcierto() {
        conciertos = new HashMap<>();
    }

    /**
     * Método que permite seleccionar un concierto, para esto
     * se debe ingresar el nombre del concierto y la lista de canciones,
     * se valida que el concierto exista, para después asignarle la lista de canciones.
     * @param nombre El nombre del concierto.
     * @param canciones La lista de canciones que se le asignará al concierto.
     */
    public void seleccionarConcierto(String nombre, List<Cancion> canciones) {
        for (Concierto concierto : conciertos.values()) {
            if (concierto.getNombre().equals(nombre)) {
                conciertos.get(nombre).setListaDeCanciones(canciones);
            }
        }
    }

    /**
     * Método que permite hacer registro de los boletos vendidos para un concierto.
     * Para esto se debe ingresar el nombre del concierto y la cantidad de boletos vendidos,
     * se valida que el concierto exista, para después registrar la cantidad de boletos vendidos.
     * @param nombre El nombre del concierto.
     * @param boletosVendidos La cantidad de boletos vendidos.
     */
    public void registrarBoletosVendidos(String nombre, int boletosVendidos) {
        for (Concierto concierto : conciertos.values()) {
            if (concierto.getNombre().equals(nombre)) {
                conciertos.get(nombre).registrarBoletosVendidos(boletosVendidos);
            }
        }
    }

    /**
     *  Método que consulta los conciertos registrados.
     * Se recorre la lista de conciertos y se imprimen los datos de cada concierto.
     */
    public void consultarConciertos() {
        for (Concierto concierto : conciertos.values()) {
            System.out.println("Concierto: " + concierto.getNombre() +
                    "Fecha: " + concierto.getfecha() +
                    "Boletos Vendidos: " + concierto.getBoletosVendidos());
        }
    }

    public List<String> getAllConcertNames() {
        List<String> concertNames = new ArrayList<>();
        for (Concierto concierto : conciertos.values()) {
            concertNames.add(concierto.getNombre());
        }
        return concertNames;
    }

    /**
     * Permite agregar un concierto a la lista de conciertos.
     * @param concierto El concierto que se agregará a la lista.
     */
    public void agregarConcierto(Concierto concierto) {
        conciertos.put(concierto.getNombre(), concierto);
    }

    /**
     * Método que obtiene un concierto por su nombre.
     * Si el concierto existe en el mapa 'conciertos', el método lo devuelve.
     * Si el concierto no existe en el mapa, el método lanza una excepción.
     * @param nombreConcierto El nombre del concierto que se busca.
     * @return El concierto que se buscaba.
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
     * Método que obtiene la lista de canciones de un concierto.
     * Si el concierto existe en la lista de conciertos, el método devuelve la lista de canciones.
     * Si el concierto no existe en la lista de conciertos, el método lanza una excepción.
     * @param nombreConcierto El nombre del concierto del que se quiere obtener la lista de canciones.
     * @return Una lista vacía si el concierto no tiene canciones.
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
