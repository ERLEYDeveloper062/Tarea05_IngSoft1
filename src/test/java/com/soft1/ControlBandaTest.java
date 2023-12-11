package com.soft1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

class ControlBandaTest {
    @Test
    void actualizarMiembros(){
        // Crear una instancia de ControlBanda
        ControlBanda controlBanda = new ControlBanda();

        // Crear una banda
        Banda banda1 = new Banda("Los Rockeros", "Rock", new Date(), Arrays.asList("foto1.jpg", "foto2.jpg"));

        // Registrar la banda
        controlBanda.registrarBanda(banda1);

        // Crear miembros y agregarlos a la banda
        Set<Instrumento> instrumentosM1 = EnumSet.of(Instrumento.GUITARRA, Instrumento.VOZ);
        Miembro miembro1 = new Miembro("Juan", "Guitarrista", instrumentosM1);

        Set<Instrumento> instrumentosM2 = EnumSet.of(Instrumento.BAJO);
        Miembro miembro2 = new Miembro("Ana", "Bajista", instrumentosM2);

        banda1.agregarMiembro(miembro1);
        banda1.agregarMiembro(miembro2);


        // Crear una nueva lista de miembros para la actualización
        List<Miembro> nuevosMiembros = new ArrayList<>();
        Set<Instrumento> instrumentosM3 = EnumSet.of(Instrumento.TECLADO);
        Set<Instrumento> instrumentosM4 = EnumSet.of(Instrumento.VOZ);
        nuevosMiembros.add(new Miembro("Carlos", "Tecladista",instrumentosM3));
        nuevosMiembros.add(new Miembro("Marta", "Vocalista", instrumentosM4));

        // Act
        controlBanda.actualizarBandaMiembros("Slipknot", "Metal", nuevosMiembros);

        // Assert
        assertEquals(2, banda1.getMiembros().size());
        
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

        // Act
        Banda bandaEncontrada = controlBanda.buscarBanda("Metallica");

        // Assert
        assertEquals(null, bandaEncontrada);
    }

    }


