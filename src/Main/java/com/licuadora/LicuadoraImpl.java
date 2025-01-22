package com.licuadora;

public class LicuadoraImpl implements Licuadora {
    private int velocidad = 0;
    private boolean llena = false;

    @Override
    public void encender() {
        if (llena) velocidad = 1;
    }

    @Override
    public void llenar(String contenido) {
        llena = true;
    }

    @Override
    public void incrementarVelocidad() {
        if (llena && velocidad < 10) velocidad++;
    }

    @Override
    public int obtenerVelocidad() {
        return velocidad;
    }

    @Override
    public boolean estaLlena() {
        return llena;
    }

    @Override
    public void vaciar() {
        llena = false;
        velocidad = 0;
    }
}
