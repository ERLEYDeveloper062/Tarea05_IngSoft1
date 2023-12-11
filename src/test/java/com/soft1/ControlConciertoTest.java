package com.soft1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

public class ControlConciertoTest {

    private ControlConcierto controlConcierto;

    @Test
    void agregarConcierto() {

        Concierto concierto1 = new Concierto("RockFest", new Date());
        controlConcierto.agregarConcierto(concierto1);

        assertNotNull(concierto1);
    }

    @Test
    void agregarConciertoNull() {
        // Crear una instancia del controlador
        ControlConcierto controlConcierto = new ControlConcierto();

        assertThrows(NullPointerException.class, () -> controlConcierto.agregarConcierto(null));
    }

    @Test
    void seleccionarConcierto() {
        Concierto concierto = new Concierto("RockFest", new Date());
        controlConcierto.agregarConcierto(concierto);

        List<Cancion> canciones = new ArrayList<>();
        canciones.add(new Cancion("Tutaina", 5));
        canciones.add(new Cancion("Los peces en el rio", 3));

        // Seleccionar el concierto "RockFest" y agregarle canciones
        controlConcierto.seleccionarConcierto("RockFest", canciones);

        // Obtener las canciones del concierto "RockFest"
        List<Cancion> cancionesDelConcierto = controlConcierto.getCancionesPorConcierto("RockFest");

        // Verificar si las canciones fueron agregadas correctamente
        assertNotNull(cancionesDelConcierto);
        assertEquals(2, cancionesDelConcierto.size());
        assertEquals("Tutaina", cancionesDelConcierto.get(0).getNombre());
        assertEquals("Los peces en el rio", cancionesDelConcierto.get(1).getNombre());
    }

    @Test
    void registroBoletosVendidos() {
        // Crear un concierto
        Concierto concierto = new Concierto("RockFest", new Date());
        String nombreConcierto = concierto.getNombre();

        // Agregar el concierto al controlador de conciertos
        controlConcierto.agregarConcierto(concierto);

        // Registrar boletos vendidos para el concierto
        controlConcierto.registrarBoletosVendidos(nombreConcierto, 123);

        // Obtener el concierto después de registrar los boletos
        Concierto conciertoRegistrado = controlConcierto.getConciertoPorNombre(nombreConcierto);

        // Verificar si se registraron los boletos correctamente
        assertEquals(123, conciertoRegistrado.getBoletosVendidos());
    }


}
