package com.soft1;

import java.util.Arrays;
import java.util.Date;
import java.util.EnumSet;
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
        //Crear instancia de banda
        ControlBanda controlBanda = new ControlBanda();

        //Crear una nueva banda
        String nombreBanda = "Los Rockeros";
        Date fechaCreacion = new Date();
        Set<Instrumento> instrumentosM1 = EnumSet.of(Instrumento.GUITARRA, Instrumento.VOZ);
        Miembro miembro1 = new Miembro("Juan", "Gitarrista", instrumentosM1);
        Banda banda1 = new Banda(nombreBanda, "Rock", fechaCreacion, Arrays.asList("foto1.jpg", "foto2.jpg"));

        System.out.println(miembro1);
        banda1.agregarMiembro(miembro1);

        String b1 = controlBanda.consultarBanda(nombreBanda);
        System.out.println("Información de la banda: " + banda1.getNombre() +
        " y sus mienbros son: " + banda1.getMiembros());

    }
}
