package com.soft1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControlBanda implements IControlBanda {
    private List<Banda> bandas;

    public ControlBanda() {
        this.bandas = new ArrayList<>();
    }

    /**
     * Actualiza los mienbros de la banda.
     * @param nombreBanda Ingresa el nombre de la banda
     * @param genero Ingresa su genero musical
     * @param nuevosMiembros Incorpora los nuevos miembros a la banda
     */
    public void actualizarBandaMiembros(String nombreBanda, String genero, List<Miembro> nuevosMiembros) {
        for (Banda banda : bandas) {
            if (banda != null) {
                if (banda.getNombre().equals(nombreBanda)) {
                    banda.actualizarMiembros(nuevosMiembros);
                    break;
                }
            }
        }
    }

    /***
     * Consulta toda la informacion de la banda.
     * @param nombreBanda Ingresa el nombre de la banda
     * @return Retorna toda la informacion con respecto a la conformacion de la banda.
     */
    public String consultarBanda(String nombreBanda) {
        for (Banda banda : bandas) {
            if (banda.getNombre().equals(nombreBanda)) {
                return "Nombre: " + banda.getNombre() +
                       ", Género: " + banda.getGenero() +
                       ", Fecha de Creación: " + banda.getFechaCreacion().toString() +
                       ", Miembros: " + banda.getMiembros().stream()
                           .map(miembro -> miembro.getNombre() + " (" + miembro.getRol() + ")")
                           .collect(Collectors.joining(", "));
            }
        }
        return "Banda no encontrada.";
    }

    @Override
    public void registrarBanda(Banda banda) {
        if (banda == null) {
            throw new IllegalArgumentException("La banda no puede ser null");
        }
        if (!bandas.contains(banda)) {
            bandas.add(banda);
        }
    }

    @Override
    public void eliminarBanda(String nombreBanda) {
        bandas.removeIf(banda -> banda.getNombre().equals(nombreBanda));
    }

    @Override
    public Banda buscarBanda(String nombreBanda) {
        return bandas.stream()
                .filter(banda -> banda.getNombre().equals(nombreBanda))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void actualizarBanda(Banda bandaActualizada) {
        for (int i = 0; i < bandas.size(); i++) {
            if (bandas.get(i).getNombre().equals(bandaActualizada.getNombre())) {
                bandas.set(i, bandaActualizada);
                break;
            }
        }
    }
}
