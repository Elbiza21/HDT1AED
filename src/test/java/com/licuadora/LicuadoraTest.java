package com.licuadora;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LicuadoraTest {

    @Test
    void testEncender() {
        Licuadora licuadora = new IBlender();
        licuadora.llenar("Agua");
        licuadora.encender();
        assertEquals(1, licuadora.obtenerVelocidad());
    }

    @Test
    void testIncrementarVelocidad() {
        Licuadora licuadora = new IBlender();
        licuadora.llenar("Batido");
        licuadora.encender();
        licuadora.incrementarVelocidad();
        assertEquals(2, licuadora.obtenerVelocidad());
    }

    @Test
    void testVacia() {
        Licuadora licuadora = new IBlender();
        assertFalse(licuadora.estaLlena());
    }
}
