package com.licuadora;

public interface Licuadora {
    void encender();
    void llenar(String contenido);
    void incrementarVelocidad();
    int obtenerVelocidad();
    boolean estaLlena();
    void vaciar();
}
