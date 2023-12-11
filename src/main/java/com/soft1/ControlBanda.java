package com.soft1;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/*
 * Clase de control para la manipulacion de las bandas.
 */

public class ControlBanda {
    private List<Banda> bandas;

    /*
     * Constructor inicial de ControlBanda
     */
    public ControlBanda() {
        this.bandas = new ArrayList<>();
    }

    /**
     * Actualiza los mienbros de la banda.
     *
     * @param nombreBanda    Ingresa el nombre de la banda
     * @param genero         Ingresa su genero musical
     * @param nuevosMiembros Incorpora los nuevos miembros a la banda
     */
    public void actualizarBandaMiembros(String nombreBanda, String genero, List<Miembro> nuevosMiembros) {
        for (Banda banda : bandas) {
            if (banda != null) {
                if (banda.getNombre().equals(nombreBanda)) {
                    banda.agregarNuevosMiembros(nuevosMiembros);
                    break;
                }
            }
        }
    }

    /***
     * Consulta toda la informacion de la banda.
     *
     * @param nombreBanda Ingresa el nombre de la banda
     * @return Retorna toda la informacion con respecto a la conformacion de la
     *         banda.
     */
    public String consultarBanda(String nombreBanda) {
        for (Banda banda : bandas) {
            if (banda.getNombre().equals(nombreBanda)) {
                return "Nombre: " + banda.getNombre() +
                        ", Género: " + banda.getGenero() +
                        ", Fecha de Creación: " + banda.getFechaCreacion() +
                        ", Miembros: " + banda.getMiembros().stream()
                                .map(miembro -> miembro.getNombre() + " (" + miembro.getRol() + ")")
                                .collect(Collectors.joining(", "));
            }
        }
        return "Banda no encontrada.";
    }

    /**
     * Registra una banda en genral.
     *
     * @param banda Ingresa una banda y si la banda no esta en la lista, la
     *              registra.
     */
    public void registrarBanda(Banda banda) {
        if (banda == null) {
            throw new IllegalArgumentException("La banda no puede ser null");
        }
        if (!bandas.contains(banda)) {
            bandas.add(banda);
        }
    }

    /**
     * Elimina la banda en una lista de bandas. Si el nombre de la banda es nulo o
     * no lo encuentra lanza excepciones.
     *
     * @param nombreBanda utilizar el nombre de la banda para buscar la banda y
     *                    validar la informacion.
     *                    Para luego ser eliminada de la lista.
     */
    public void eliminarBanda(String nombreBanda) {
        if (nombreBanda == null) {
            throw new IllegalArgumentException("El nombre de la banda es nulo.");
        }

        boolean eliminada = bandas.removeIf(banda -> banda.getNombre().equals(nombreBanda));

        if (eliminada) {
            System.out.println("La banda '" + nombreBanda + "se encontró y se pudo eliminar.");
        } else {
            throw new NoSuchElementException("La banda '" + nombreBanda + "' no se encontró o no se pudo eliminar.");
        }
    }

    /**
     * Busca a las bandas de acuerdo al su nombre respectivo.
     *
     * @param nombreBanda ingresa el nombre de la banda.
     * @return retorna la banda respectivamente.
     */
    public Banda buscarBanda(String nombreBanda) {
        if (nombreBanda == null) {
            throw new IllegalArgumentException("El nombre de la banda es nulo.");
        }
        for (Banda banda : bandas) {
            if (banda.getNombre().equals(nombreBanda)) {
                return banda;
            }
        }
        throw new NoSuchElementException("No se encontró la banda con nombre: " + nombreBanda);
    }

    /**
     * actualiza a una banda en general, busca una banda por su nombre y va iterando
     * sobre cada banda y actualizando.
     *
     * @param bandaActualizada se ingresa una banda en espefico para luego buscarla
     *                         segun su nombre.
     */
    public void actualizarBanda(Banda bandaActualizada) {
        if (bandas == null) {
            throw new IllegalArgumentException("No se encuentra la banda para actualizar.");
        }
        for (int i = 0; i < bandas.size(); i++) {
            if (bandas.get(i).getNombre().equals(bandaActualizada.getNombre())) {
                bandas.set(i, bandaActualizada);
                break;
            }
        }
    }
}
