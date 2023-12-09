package com.soft1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControlConcierto {
    private Map<String, Concierto> conciertos;

    public ControlConcierto() {
        conciertos = new HashMap<>();
    }

    public void seleccionarConcierto(String nombre, List<Cancion> canciones){
        if (conciertos.containsKey(nombre)) {
            conciertos.get(nombre).setListaDeCanciones(canciones);
        }
    }

    public void registrarBoletosVendidos(String nombre, int boletosVendidos){
        if (conciertos.containsKey(nombre)){
            conciertos.get(nombre).registrarBoletosVendidos(boletosVendidos);
        }
    }

    public void consultarConciertos(){
        for (Concierto concierto: conciertos.values()){
            System.out.println("Concierto: " + concierto.getNombre() +
                                "Fecha: " + concierto.getfecha() +
                                "Boletos Vendidos: " + concierto.getBoletosVendidos());
        }
    }

    public void agregarConcierto(Concierto concierto){
        conciertos.put(concierto.getNombre(), concierto);
    }
}
