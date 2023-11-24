package com.soft1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControlBanda {
    private List<Banda> bandas;

    public ControlBanda() {
        this.bandas = new ArrayList<>();
    }

    public void RegistarBanda(Banda nuevaBanda,Miembro nuevosMiembro) {
            bandas.add(nuevaBanda);

            for (Banda banda : bandas) {
                banda.agregarMiembro(nuevosMiembro);
            }
    }

    public void eliminarBandaMienbros(String nombreBanda) {
        for (Banda banda : bandas) {
            if (banda != null) {
                if (banda.getNombre().equals(nombreBanda)) {
                    bandas.remove(banda);
                }
            }
        }
    }

    public void actualizarBandaMienbros(String nombreBanda, String genero, List<Miembro> nuevosMiembros) {
        for (Banda banda : bandas) {
            if (banda != null) {
                if (banda.getNombre().equals(nombreBanda) && banda.getGenero().equals(genero)) {
                    banda.actualizarMiembros(nuevosMiembros);
                    break;
                }
            }
        }
    }

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
}
