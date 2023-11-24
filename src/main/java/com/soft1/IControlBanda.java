package com.soft1;

public interface IControlBanda {
    void registrarBanda(Banda banda);
    void eliminarBanda(String nombreBanda);
    Banda buscarBanda(String nombreBanda);
    void actualizarBanda(Banda banda);
}
