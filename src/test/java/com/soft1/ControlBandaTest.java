package com.soft1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class ControlBandaTest {
    @Test
    void ActualizarMiembros() {
        // Crear una instancia de ControlBanda
        ControlBanda controlBanda = new ControlBanda();

        // Crear una banda
        Banda banda1 = new Banda("Los Rockeros", "Rock", new Date(), Arrays.asList("foto1.jpg", "foto2.jpg"));
        Set<Instrumento> instrumentosM1 = EnumSet.of(Instrumento.GUITARRA, Instrumento.VOZ);
        Set<Instrumento> instrumentosM2 = EnumSet.of(Instrumento.VIOLIN);
        Set<Instrumento> instrumentosM3 = EnumSet.of(Instrumento.SAXOFON);
        Set<Instrumento> instrumentosM4 = EnumSet.of(Instrumento.TECLADO);
        // Registrar la banda
        controlBanda.registrarBanda(banda1);

        // Crear miembros y agregarlos a la banda
        Miembro miembro1 = new Miembro("Juan", "Guitarrista", instrumentosM1);

        Miembro miembro2 = new Miembro("Ana", "Bajista", instrumentosM2);

        banda1.agregarMiembro(miembro1);
        banda1.agregarMiembro(miembro2);

        // Crear una nueva lista de miembros para la actualización
        List<Miembro> nuevosMiembros = new ArrayList<>();
        instrumentosM3 = EnumSet.of(Instrumento.TECLADO);
        instrumentosM4 = EnumSet.of(Instrumento.VOZ);
        nuevosMiembros.add(new Miembro("Carlos", "Tecladista", instrumentosM3));
        nuevosMiembros.add(new Miembro("Marta", "Vocalista", instrumentosM4));

        // Act
        controlBanda.actualizarBandaMiembros("Los Rockeros", "Rock", nuevosMiembros);

        // Assert
        assertEquals(4, banda1.getMiembros().size());
    }

     @Test
        public void consultarBandaInexistente() {
            // Arrange
            ControlBanda controlBanda = new ControlBanda();

            // Act
            String informacionBanda = controlBanda.consultarBanda("Metallica");

            // Assert
            assertEquals("Banda no encontrada.", informacionBanda);
        }

        @Test
    public void registrarBandaNullException() {
        // Act
        ControlBanda controlBanda = new ControlBanda();

        // Assert
        assertThrows(IllegalArgumentException.class, () -> controlBanda.registrarBanda(null));
    }

    @Test
    public void buscarBandaInexistenteNull() {
        // Arrange
        ControlBanda controlBanda = new ControlBanda();
        
        assertThrows(Exception.class, ()->controlBanda.buscarBanda("Metallica"));
    }
}
