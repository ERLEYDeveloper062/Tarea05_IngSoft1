package com.soft1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {

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

        // Imprimir información de la banda
        System.out.println("Banda registrada:");
        System.out.println("Nombre de la banda es: " + banda1.getNombre()+ "Genero de la banda es: " + banda1.getGenero());

        // Buscar la banda y mostrar su información
        Banda buscada = controlBanda.buscarBanda("Los Rockeros");
        System.out.println("Banda buscada:");
        System.out.println(buscada.getNombre());

        // Actualizar la banda (puedes modificar la banda y luego actualizarla)
        banda1.setNombre("Los 50 De Joselito");
        controlBanda.actualizarBanda(banda1);

        // Crear una nueva lista de miembros para la actualización
        List<Miembro> nuevosMiembros = new ArrayList<>();
        Set<Instrumento> instrumentosM3 = EnumSet.of(Instrumento.TECLADO);
        Set<Instrumento> instrumentosM4 = EnumSet.of(Instrumento.VOZ);
        nuevosMiembros.add(new Miembro("Carlos", "Tecladista",instrumentosM3));
        nuevosMiembros.add(new Miembro("Marta", "Vocalista", instrumentosM4));

        // Actualizar los miembros de la banda
        controlBanda.actualizarBandaMiembros("Los Rockeros", "Rock", nuevosMiembros);

        // Volver a buscar la banda con el nuevo nombre
        buscada = controlBanda.buscarBanda("Los 50 De Joselito");
        System.out.println("Banda actualizada:");
        System.out.println(buscada.getNombre());

        //Consultar toda la informacion de la banda
        System.out.println("Cosulta ...");
        controlBanda.consultarBanda("Los 50 De Joselito");
        System.out.println(controlBanda.consultarBanda("Los 50 De Joselito"));

        // Eliminar una banda
        controlBanda.eliminarBanda("Los 50 De Joselito");
        buscada = controlBanda.buscarBanda("Los 50 De Joselito");
        System.out.println("Banda después de eliminar:");
        System.out.println(buscada != null ? buscada : "Banda no encontrada");

    }
}
