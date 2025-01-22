package com.licuadora;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BlenderUnitTests {

    private IBlender blender;

    @BeforeEach
    void setUp() {
        blender = new BlenderImpl();
    }

    @Test
    void testInitialPowerStatus() {
        assertEquals(0, blender.checkPowerStatus(), "El estado inicial de la licuadora debe ser apagado.");
    }

    @Test
    void testSwitchPowerStatus() {
        assertEquals(0, blender.checkPowerStatus(), "La licuadora debe iniciar apagada.");
        blender.switchPowerStatus();
        assertEquals(1, blender.checkPowerStatus(), "La licuadora debe encenderse después de cambiar el estado.");
    }

    @Test
    void testFillBlender() {
        blender.fillBlender("Jugo", 500);
        assertEquals(500, blender.actualCapacity(), "La capacidad debe ser de 500 ml después de llenar la licuadora.");
        assertTrue(blender.isFull(), "La licuadora debería estar llena cuando la capacidad máxima sea alcanzada.");
    }

    @Test
    void testOverfillBlender() {
        assertThrows(IllegalArgumentException.class, () -> {
            blender.fillBlender("Jugo", 1500);
        }, "Debe lanzar una excepción al intentar llenar más allá de la capacidad máxima.");
    }

    @Test
    void testIncreaseSpeed() {
        blender.switchPowerStatus();
        blender.increaseSpeed();
        assertEquals(1, blender.checkSpeed(), "La velocidad debe ser 1 después de incrementarla una vez.");
    }

    @Test
    void testDecreaseSpeed() {
        blender.switchPowerStatus();
        blender.increaseSpeed();
        blender.increaseSpeed();
        blender.decreaseSpeed();
        assertEquals(1, blender.checkSpeed(), "La velocidad debe ser 1 después de reducirla desde 2.");
    }

    @Test
    void testEmptyBlender() {
        blender.fillBlender("Jugo", 1000);
        blender.emptyBlender();
        assertEquals(0, blender.actualCapacity(), "La capacidad debe ser 0 después de vaciar la licuadora completamente.");
    }

    @Test
    void testPartialEmptyBlender() {
        blender.fillBlender("Jugo", 1000);
        blender.emptyBlender(500);
        assertEquals(500, blender.actualCapacity(), "La capacidad debe ser 500 después de vaciar parcialmente 500 ml.");
    }

    @Test
    void testInvalidPartialEmptyBlender() {
        blender.fillBlender("Jugo", 500);
        assertThrows(IllegalArgumentException.class, () -> {
            blender.emptyBlender(600);
        }, "Debe lanzar una excepción al intentar vaciar más contenido del que tiene.");
    }

    @Test
    void testSpeedWhenOff() {
        assertThrows(IllegalStateException.class, () -> {
            blender.increaseSpeed();
        }, "No se debe permitir incrementar la velocidad cuando la licuadora está apagada.");
    }
}
