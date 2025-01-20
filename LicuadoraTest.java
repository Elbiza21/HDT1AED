// Pruebas unitarias con JUnit LicuadoraTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LicuadoraTest {
    @Test
    void testEncenderSinContenido() {
        Licuadora licuadora = new LicuadoraImpl();
        licuadora.encender();
        assertEquals(0, licuadora.getVelocidad(), "La licuadora no debe encender vacía");
    }

    @Test
    void testIncrementarVelocidad() {
        Licuadora licuadora = new LicuadoraImpl();
        licuadora.llenar("Frutas");
        licuadora.encender();
        licuadora.incrementarVelocidad();
        assertEquals(1, licuadora.getVelocidad(), "La velocidad debe incrementarse a 1");
    }

    @Test
    void testVaciarLicuadora() {
        Licuadora licuadora = new LicuadoraImpl();
        licuadora.llenar("Leche");
        licuadora.vaciar();
        assertFalse(licuadora.estaLlena(), "La licuadora debe estar vacía");
    }
}
